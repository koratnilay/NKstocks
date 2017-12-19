package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.LoginDAO;

@ManagedBean(name = "login")
@SessionScoped
public class Login {
	
	private String name;
	private String username;
	private String password;
	private String role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String logindb() {
		 System.out.println("abc");

			boolean result = LoginDAO.login(username, password, role);
			this.name = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("name");
			String status = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("status");
			if (result) {
				if( role.equalsIgnoreCase("admin")){
					return "adminhome";
				}
				else if(role.equalsIgnoreCase("User")){
					return "userhome";
				}
				else if(role.equalsIgnoreCase("Manager") && status.equalsIgnoreCase("a") ){
					return "managerhome";
				}
			} else {

				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login!", "Please Try Again!"));
				return null;
			}
			return "login";
			
		}


	

}
