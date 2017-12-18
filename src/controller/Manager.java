package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import dao.ManagerDAO;

@ManagedBean(name="manager")
@SessionScoped
public class Manager {
	
	private String name;
	private String email;
	private String phoneno;
	private String username;
	private String password;
	private String role;
	private String fees;
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneno() {
		return phoneno;
	}



	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getFees() {
		return fees;
	}



	public void setFees(String fees) {
		this.fees = fees;
	}
	
	private String uname = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
	private String userid = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userid");
	
	public String find() {
		
		ArrayList<String> rs = ManagerDAO.getUser(userid);
		String array[] = new String[rs.size()];
		
		for(int j =0;j<rs.size();j++){
			  array[j] = rs.get(j);
			}
			this.setName(array[0]);
			this.setEmail(array[1]);
			this.setPhoneno(array[2]);
			this.setUsername(array[3]);
			this.setPassword(array[4]);
			this.setFees(array[5]);
		
			return "managerprofile";
	}
	
public String edit() {
		
		ArrayList<String> rs = ManagerDAO.getUser(uname);
			return "editmanager";
		
	}
	
public String update() {
			
		boolean rs = ManagerDAO.updateuser(userid,username,email,phoneno,username,password,fees);
		
		if(rs) {
			return "managerprofile";
		}else {
			return "editmanager";
		}
		
		
    }


	public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }

}
