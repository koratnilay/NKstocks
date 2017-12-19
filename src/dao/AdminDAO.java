package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.Admin;
import controller.Login;
import dataconnect.Dataconnect;

public class AdminDAO {
	public static ArrayList<Admin> getUser(){
		Connection con = null;
        PreparedStatement ps = null;
		
		 try {
			 	con = Dataconnect.getConnection();
	            ps = con.prepareStatement("SELECT userid,name,email,phoneno,role, status from users where role=?");
	            ps.setString(1, "Manager");
	            ArrayList<Admin> al = new ArrayList<Admin>();
	            ResultSet rs = ps.executeQuery();
	            boolean found = false;
	            System.out.println("here");
	            while (rs.next()) {
	                Admin e = new Admin();
	                e.setManagername(rs.getString("name"));
	                e.setManageremail(rs.getString("email"));
	                e.setManagerphoneno(rs.getString("phoneno"));
	                e.setManagerrole(rs.getString("role"));
	                e.setManagerstatus(rs.getString("status"));
	                e.setManagerid(rs.getString("userid"));
	                
	               
	                al.add(e);
	                found = true;
	            }
	            rs.close();
	            con.close();
	            if (found) {
	                return al;
	            } else {
	                return null;
	            }
	        } catch (Exception e) {
	            System.out.println("Error In manager retrival" + e.getMessage());
	            return (null);
	        }
		
	}
	
	
	public static boolean approve(String userid) {
		Connection con = null;
        PreparedStatement ps = null;
        		
		 try {
			 	con = Dataconnect.getConnection();
			 				 	
	            ps = con.prepareStatement("UPDATE users SET status=? WHERE userid=? ");
	            ps.setString(1, "a");
	            ps.setString(2, userid);
	            
	            
	            int rs = ps.executeUpdate();
	            
	            if(rs>0) {
	              	
	            	return true;
	            }
		 	}catch (Exception e) {
		 		return false;
			}
		return false;
	}
	
	
	public static boolean decline(String userid) {
		Connection con = null;
        PreparedStatement ps = null;
        		
		 try {
			 	con = Dataconnect.getConnection();
			 				 	
	            ps = con.prepareStatement("UPDATE users SET status=? WHERE userid=? ");
	            ps.setString(1, "d");
	            ps.setString(2, userid);
	            
	            
	            int rs = ps.executeUpdate();
	            
	            if(rs>0) {
	              	
	            	return true;
	            }
		 	}catch (Exception e) {
		 		return false;
			}
		return false;
	}
	
}
