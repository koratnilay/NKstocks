package dataconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dataconnect {
	
	public static String hostName = "localhost";
    public static String portNumber = "3308";
    public static String databaseName = "nk579847stocks";
    public static String userName = "root";
    public static String password = "root";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + hostName + ":" + portNumber + "/" + databaseName, userName, password);
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }

}
