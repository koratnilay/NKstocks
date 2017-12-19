package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.RegisterDAO;

@ManagedBean(name = "register")
@SessionScoped
public class Register {
	
	private String name;
	private String email;
	private String phoneno;
	private String username;
	private String password;
	private String role;
	private String fees;
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
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	
	public String registerdb() {
		System.out.println("hello");
        boolean result = RegisterDAO.register( name, email, phoneno, username, password, role , fees);
        if (result) {
            
        	
            return "login";
        } else {
 
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Invalid Login!",
                    "Please Try Again!"));
 
            return "register";
        }
    }
	
	
}
