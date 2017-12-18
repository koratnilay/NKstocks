package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.Admin;
import controller.Login;
import controller.Manager;
import dataconnect.Dataconnect;

public class ManagerDAO {
	
	public static ArrayList<String> getUser(String userid){
		Connection con = null;
        PreparedStatement ps = null;
		
		 try {
			 	con = Dataconnect.getConnection();
	            ps = con.prepareStatement("SELECT name,email,phoneno,username,password,fees from users where userid=?");
				ps.setString(1, userid);
	                
	            ResultSet rs = ps.executeQuery();
	            ArrayList<String> al = new ArrayList<String>();
	            boolean found = false;
	            if(rs.next()) {
	            		           
	            	al.add(rs.getString("name"));
	            	al.add(rs.getString("email"));
	            	al.add(rs.getString("phoneno"));
	            	al.add(rs.getString("username"));
	            	al.add(rs.getString("password"));
	            	al.add(rs.getString("fees"));
	            	System.out.println(al);
	                found = true;
	            }
	            if (found) {
	            	rs.close();
		            con.close();
	                return al;
	            } else {
	                return null;
	            }
	        } catch (Exception e) {
	            System.out.println("Error In manager retrival" + e.getMessage());
	            return null;
	        }
	      }
	
	public static boolean updateuser(String userid, String name,String email,String phoneno,String username,String password,String fees) {
		Connection con = null;
        PreparedStatement ps = null;
        		
		 try {
			 	con = Dataconnect.getConnection();
			 				 	
	            ps = con.prepareStatement("UPDATE users SET name=?, email=?, phoneno=?, username=?, password=?, fees=? WHERE userid=? ");
	            ps.setString(1, name); 
	            ps.setString(2, email);
	            ps.setString(3, phoneno);
	            ps.setString(4, username);
	            ps.setString(5, password);
	            ps.setString(6, fees);
	            ps.setString(7, userid);
	            
	            int rs = ps.executeUpdate();
	            
	            if(rs>0) {
	              	Login ls = new Login();
	            	ls.setUsername(username);
	            	return true;
	            }
		 	}catch (Exception e) {
		 		return false;
			}
		return false;
	}

}
