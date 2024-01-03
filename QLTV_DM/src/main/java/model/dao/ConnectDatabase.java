package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectDatabase {
    
	    
	    public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
	        String dbURL = "jdbc:mysql://localhost:3306/qltv_nhap?useSSL=false&serverTimezone=UTC";
	        String username = "sa";
	        String password = "123456";
	        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(dbURL, username, password);
	            if (conn != null) {
	                System.out.println("Kết nối thành công");
	                return conn;
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	

}
