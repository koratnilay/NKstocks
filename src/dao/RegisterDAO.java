package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataconnect.Dataconnect;

public class RegisterDAO {
	
	
public static boolean register(String name, String email, String phoneno, String username, String password, String role, String fees){
		
		Connection con = null;
	    PreparedStatement ps = null;
	    
		try {
				con = Dataconnect.getConnection();
	    		ps = con.prepareStatement("INSERT INTO users(name, email, phoneno, username,password, role,status,fees,balance) VALUES(?,?,?,?,?,?,?,?,?)");
	
				ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, phoneno);
	            ps.setString(4, username);
	            ps.setString(5, password);
	            ps.setString(6, role);
	            ps.setString(7, "d");
	            ps.setString(8, fees);
	            ps.setString(9, "100000");
	            int i = ps.executeUpdate();
	            System.out.println("Data Added Successfully");
	            
	            con.close();
				return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			return false;
		}
	        
    }

}
