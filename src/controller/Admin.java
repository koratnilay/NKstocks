package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.AdminDAO;

@ManagedBean(name="admin")
@SessionScoped

public class Admin {
	
	private String managerid;
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
	public String getManagerid() {
		return managerid;
	}
	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}
	
	
	
	public ArrayList<Admin> getMessages() {
        return AdminDAO.getUser();
    }
	
	public String approve() {
	      FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	      String mid =  params.get("mid"); 
	      boolean res =AdminDAO.approve(mid);
	      return "result";
	   }
	
	
	public String decline() {
	      FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	      String mid =  params.get("mid");
	      boolean res =AdminDAO.decline(mid);
	      return "adminhome";
	   }
	
	public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }
	
}
