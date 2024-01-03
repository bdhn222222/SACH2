package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Authors;
import model.bean.Category;
import model.bo.BookBO;

public class AuthorsDAO {
	Connection conn = null;
	Statement st = null;
	PreparedStatement preSt = null;
	
	public Authors findAuthors(int idAuthors) throws SQLException, ClassNotFoundException {
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from authors where idAuthors = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);	
		pstm.setInt(1, idAuthors);
		
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int idAuthors1 = rs.getInt("idAuthors");
			String nameAuthors = rs.getString("nameAuthors");
			Authors Authors = new Authors(idAuthors1, nameAuthors);
			return Authors;
		}
		return null;
	}
	
	public int insertAuthors(Authors authors) throws SQLException, ClassNotFoundException{
		if(conn == null)
		conn = ConnectDatabase.getMySQLConnection();
		try {
			st = conn.createStatement();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		int result =0;
		String sql = "INSERT INTO authors (nameAuthors) VALUES (?)";
		preSt = conn.prepareStatement(sql);
		preSt.setString(1, authors.getNameAuthors());
		result= preSt.executeUpdate();
		return result;
	}
	public ArrayList<Authors> getAllAuthors() throws SQLException, ClassNotFoundException{
		if(conn == null)
		conn = ConnectDatabase.getMySQLConnection();
		ArrayList<Authors> list = new ArrayList<Authors>();
		String sql = "Select * from authors";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int idAuthors = rs.getInt("idAuthors");
			String nameAuthors = rs.getString("nameAuthors");
			Authors authors = new Authors();
			authors.setIdAuthors(idAuthors);
			authors.setNameAuthors(nameAuthors);
			list.add(authors);
		}
		return list;
	}
	public int updateAuthors(Authors authors) throws SQLException, ClassNotFoundException{
		int rs = 0;
		if(conn == null) {
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "update authors set nameAuthors =? where idAuthors=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, authors.getNameAuthors());
		pstm.setInt(2,authors.getIdAuthors());
		rs = pstm.executeUpdate();
		}
		return rs;
	}
	
	public int deleteAuthors(int idAuthors) throws SQLException, ClassNotFoundException{
		int result =0;
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		BookBO bookBO = new BookBO();
		bookBO.deleteBookAuthors(idAuthors);
		String sql = "Delete From authors where idAuthors= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idAuthors);
		result = pstm.executeUpdate();
		return result;
	}
	public int deleteAllAuthors() throws SQLException, ClassNotFoundException{
		int result = 0;
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "delete from authors";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		result = pstm.executeUpdate();
		return result;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AuthorsDAO authorsDAO = new AuthorsDAO();
		authorsDAO.getAllAuthors();
		System.out.println(authorsDAO);
	}
}
