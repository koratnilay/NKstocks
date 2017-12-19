package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.AdminDAO;
import dao.ManagerDAO;
import dao.UserDAO;

@ManagedBean(name="user")
@SessionScoped
public class User {
	
	private String name;
	private String email;
	private String phoneno;
	private String username;
	private String password;
	private String role;
	private String fees;
	private String mid;
	private String mname;
	private String memail;
	private String mphoneno;
	private String mrole;
	private String mfees;
	
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
		
		ArrayList<String> rs = UserDAO.getUser(userid);
		String array[] = new String[rs.size()];
		
		for(int j =0;j<rs.size();j++){
			  array[j] = rs.get(j);
			}
			this.setName(array[0]);
			this.setEmail(array[1]);
			this.setPhoneno(array[2]);
			this.setUsername(array[3]);
			this.setPassword(array[4]);
			
		
			return "userprofile";
	}
	
public String edit() {
		
		ArrayList<String> rs = UserDAO.getUser(uname);
			return "edituser";
		
	}
	
public String update() {
			
		boolean rs = UserDAO.updateuser(userid,username,email,phoneno,username,password);
		
		if(rs) {
			return "userprofile";
		}else {
			return "edituser";
		}
		
		
    }

	public String getMid() {
	return mid;
}



public void setMid(String mid) {
	this.mid = mid;
}



public String getMname() {
	return mname;
}



public void setMname(String mname) {
	this.mname = mname;
}



public String getMemail() {
	return memail;
}



public void setMemail(String memail) {
	this.memail = memail;
}



public String getMphoneno() {
	return mphoneno;
}



public void setMphoneno(String mphoneno) {
	this.mphoneno = mphoneno;
}



public String getMrole() {
	return mrole;
}



public void setMrole(String mrole) {
	this.mrole = mrole;
}



public String getMfees() {
	return mfees;
}



public void setMfees(String mfees) {
	this.mfees = mfees;
}



	public ArrayList<User> getMessages() {
	    return UserDAO.getManager();
	}
	
private double amtbuy;
private double amtsell;


	public double getAmtbuy() {
		return amtbuy;
	}
	public void setAmtbuy(double amtbuy) {
		this.amtbuy = amtbuy;
	}
	public double getAmtsell() {
		return amtsell;
	}
	public void setAmtsell(double amtsell) {
		this.amtsell = amtsell;
	}
	
	
	public String reqmanager() {
		FacesContext fc = FacesContext.getCurrentInstance();
	    Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	    String mid =  params.get("mid");
		
		boolean rs = UserDAO.req(userid,username,mid,mname,amtbuy,amtsell);
		System.out.println("rs value in user.java"+rs);
		if(rs) {
			System.out.println("going to home");
			return "managerhome";
		}else {
			System.out.println("going to same page");
			return "usermanager";
		}
		
		
    }

	public void home() throws IOException {
		String temprole = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("role");
		if(temprole.equalsIgnoreCase("manager")) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("managerhome.xhtml");
		}else if(temprole.equalsIgnoreCase("user")){
			FacesContext.getCurrentInstance().getExternalContext().redirect("userhome.xhtml");
		}
        
    }
	public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }

}
