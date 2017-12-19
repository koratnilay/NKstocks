package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.context.FacesContext;
import dataconnect.Dataconnect;

public class LoginDAO {
	
	public static boolean login(String username, String password, String role) {
		
		Connection con = null;
        PreparedStatement ps = null;
        
        try {	
        		con = Dataconnect.getConnection();
        		ps = con.prepareStatement("SELECT userid,name,username, password, role, status from users where username = ? and password = ? and role=?");
        		ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, role);
                                   
                ResultSet rs = ps.executeQuery();
                         
                if (rs.next()) {
                	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userid", rs.getString("userid"));
    				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", rs.getString("username"));
    				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("status", rs.getString("status"));
    				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("name", rs.getString("name"));
    				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("role", rs.getString("role"));
    				
    				Dataconnect.close(con);
    				return true;
    			}
    			
        }catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            
        } finally {
        	
        }
		return false;
	}

}
