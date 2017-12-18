package controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.AdminDAO;

@ManagedBean(name="admin")
@SessionScoped

public class Admin {
	
	private String managername;
	private String manageremail;
	private String managerphoneno;
	private String managerrole;
	private String managerstatus;
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManageremail() {
		return manageremail;
	}
	public void setManageremail(String manageremail) {
		this.manageremail = manageremail;
	}
	public String getManagerphoneno() {
		return managerphoneno;
	}
	public void setManagerphoneno(String managerphoneno) {
		this.managerphoneno = managerphoneno;
	}
	public String getManagerrole() {
		return managerrole;
	}
	public void setManagerrole(String managerrole) {
		this.managerrole = managerrole;
	}
	public String getManagerstatus() {
		return managerstatus;
	}
	public void setManagerstatus(String managerstatus) {
		this.managerstatus = managerstatus;
	}

	public ArrayList<Admin> getMessages() {
        return AdminDAO.getUser();
    }
	
}
