package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.User;
import model.bean.User;
import model.bean.User;
import model.bo.BookBO;

public class UserDAO {
	Connection conn = null;
	Statement st = null;
	PreparedStatement preSt = null;

	public User getUser(String username, String password) throws ClassNotFoundException, SQLException {
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from user where username=? and password=?";

		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			Integer idUser = rs.getInt("idUser");
			String username1= rs.getString("username");
			String password1 = rs.getString("password");
			User user = new User();
			user.setIdUser(idUser);
			user.setUsername(username1);
			user.setPassword(password1);
			return user;
		}
		return null;
	}
	public User findUser(int idUser) throws SQLException, ClassNotFoundException {
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from user where idUser = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);	
		pstm.setInt(1, idUser);
		
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int idUser1 = rs.getInt("idUser");
			String username = rs.getString("username");
			String password = rs.getString("password");
			User user = new User(idUser1, username,password);
			return user;
		}
		return null;
	}
	public int insertUser(User user) throws SQLException, ClassNotFoundException{
		if(conn == null)
		conn = ConnectDatabase.getMySQLConnection();
		try {
			st = conn.createStatement();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		int result =0;
		String sql = "INSERT INTO user (username, password) VALUES (?,?)";
		preSt = conn.prepareStatement(sql);
		preSt.setString(1, user.getUsername());
		preSt.setString(2, user.getPassword());
		result= preSt.executeUpdate();
		return result;
	}
	public ArrayList<User> getAllUser() throws SQLException, ClassNotFoundException{
		if(conn == null)
		conn = ConnectDatabase.getMySQLConnection();
		ArrayList<User> list = new ArrayList<User>();
		String sql = "Select * from user";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int idUser = rs.getInt("idUser");
			String username = rs.getString("username");
			User user = new User();
			user.setIdUser(idUser);
			user.setUsername(username);
			list.add(user);
		}
		return list;
	}
	public int updateUser(User user) throws SQLException, ClassNotFoundException {
	    int rs = 0;
	    Connection conn = null;
	    PreparedStatement pstm = null;

	    try {
	        conn = ConnectDatabase.getMySQLConnection();
	        if (conn != null) {
	            String sql = "UPDATE user SET username = ?, password = ? WHERE idUser = ?";
	            pstm = conn.prepareStatement(sql);
	            pstm.setString(1, user.getUsername());
	            pstm.setString(2, user.getPassword());
	            pstm.setInt(3, user.getIdUser());
	            rs = pstm.executeUpdate();
	        }
	    } finally {
	        if (pstm != null) {
	            pstm.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }
	    
	    return rs;
	}

	
	public int deleteUser(int idUser) throws SQLException, ClassNotFoundException{
		int result =0;
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "delete From user where idUser= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idUser);
		result = pstm.executeUpdate();
		return result;
	}
	public static void main(String[] args) {
	    try {
	        UserDAO userDAO = new UserDAO();
	        
	        // Tạo một đối tượng User mới để cập nhật
	        User userToUpdate = new User();
	        userToUpdate.setIdUser(1); // Thay thế 123 bằng ID người dùng bạn muốn cập nhật
	        userToUpdate.setUsername("sa");
	        userToUpdate.setPassword("123");
	        
	        // Gọi phương thức updateUser để cập nhật thông tin người dùng
	        int updatedRows = userDAO.updateUser(userToUpdate);
	        
	        if (updatedRows > 0) {
	            System.out.println("User information updated successfully!");
	        } else {
	            System.out.println("Update failed!");
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}

}
