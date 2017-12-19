package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.Admin;
import controller.Login;
import controller.Manager;
import controller.User;
import dataconnect.Dataconnect;

public class UserDAO {
	
	public static ArrayList<String> getUser(String userid){
		Connection con = null;
        PreparedStatement ps = null;
		
		 try {
			 	con = Dataconnect.getConnection();
	            ps = con.prepareStatement("SELECT name,email,phoneno,username,password from users where userid=?");
				ps.setString(1, userid);
	                
	            ResultSet rs = ps.executeQuery();
	            ArrayList<String> al = new ArrayList<String>();
	            boolean found = false;
	            if(rs.next()) {
	            	User e = new User();
	            	e.setName(rs.getString("name"));
	            	e.setUsername(rs.getString("username"));
	            	al.add(rs.getString("name"));
	            	al.add(rs.getString("email"));
	            	al.add(rs.getString("phoneno"));
	            	al.add(rs.getString("username"));
	            	al.add(rs.getString("password"));
	            	
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
	
	public static boolean updateuser(String userid, String name,String email,String phoneno,String username,String password) {
		Connection con = null;
        PreparedStatement ps = null;
        		
		 try {
			 	con = Dataconnect.getConnection();
			 				 	
	            ps = con.prepareStatement("UPDATE users SET name=?, email=?, phoneno=?, username=?, password=? WHERE userid=? ");
	            ps.setString(1, name); 
	            ps.setString(2, email);
	            ps.setString(3, phoneno);
	            ps.setString(4, username);
	            ps.setString(5, password);
	            ps.setString(6, userid);
	            
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
	
	
	
	public static ArrayList<User> getManager(){
		Connection con = null;
        PreparedStatement ps = null;
		
		 try {
			 	con = Dataconnect.getConnection();
	            ps = con.prepareStatement("SELECT userid,name,email,phoneno,role, fees from users where role=?");
	            ps.setString(1, "Manager");
	            ArrayList<User> al = new ArrayList<User>();
	            ResultSet rs = ps.executeQuery();
	            boolean found = false;
	            
	            while (rs.next()) {
	            	
	            	User e = new User();
	                e.setMid(rs.getString("userid"));
	                e.setMname(rs.getString("name"));
	                e.setMemail(rs.getString("email"));
	                e.setMphoneno(rs.getString("phoneno"));
	                e.setMrole(rs.getString("role"));
	                e.setMfees(rs.getString("fees"));
	            	
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
	
	public static boolean req(String userid, String username, String mid, String mname, double amtbuy, double amtsell ) {
		Connection con = null;
        PreparedStatement ps = null;
        		
		 try {
			 	con = Dataconnect.getConnection();
			 	System.out.println("in try");
	            ps = con.prepareStatement("INSERT INTO usermanager(userid, username, mid, mname, amt_buy, amt_sell) VALUES(?,?,?,?,?,?)");
	            
	            ps.setString(1,userid);
	            ps.setString(2,username);
	            ps.setString(3,mid);
	            ps.setString(4,mname);
	            ps.setDouble(5,amtbuy);
	            ps.setDouble(6,amtsell);
	            System.out.println("before execute update");
	            int rs = ps.executeUpdate();
	            System.out.println("value of rs"+rs);
	            if(rs>0) {
	              	System.out.println("in if");
	            	return true;
	            }
		 	}catch (Exception e) {
		 		System.out.println("in catch"+e.getMessage());
		 		e.printStackTrace();
		 		return false;
			}
		 System.out.println("last statement");
		return false;
		
	}

}
