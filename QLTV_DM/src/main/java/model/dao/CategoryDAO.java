package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bo.BookBO;

public class CategoryDAO {
	Connection conn = null;
	Statement st = null;
	PreparedStatement preSt = null;
	
	public Category findCategory(Integer idCategory)throws SQLException, ClassNotFoundException {
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from category where idCategory = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);	
		pstm.setInt(1, idCategory);
		
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			Integer idCategory1 = rs.getInt("idCategory");
			String nameCategory = rs.getString("nameCategory");
			Category category = new Category(idCategory1, nameCategory);
			return category;
		}
		return null;
	}
	
	public int insertCategory(Category category) throws SQLException, ClassNotFoundException{
		if(conn == null)
		conn = ConnectDatabase.getMySQLConnection();
		try {
			st = conn.createStatement();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		int result =0;
		String sql = "INSERT INTO category (nameCategory) VALUES (?)";
		preSt = conn.prepareStatement(sql);
		preSt.setString(1, category.getNameCategory());
		result= preSt.executeUpdate();
		return result;
	}
	public ArrayList<Category> getAllCategory() throws SQLException, ClassNotFoundException{
		if(conn == null)
		conn = ConnectDatabase.getMySQLConnection();
		ArrayList<Category> list = new ArrayList<Category>();
		String sql = "Select * from category";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int idCategory = rs.getInt("idCategory");
			String nameCategory = rs.getString("nameCategory");
			Category category = new Category();
			category.setIdCategory(idCategory);
			category.setNameCategory(nameCategory);
			list.add(category);
		}
		return list;
	}
	public int updateCategory(Category category) throws SQLException, ClassNotFoundException{
		int rs = 0;
		if(conn == null) {
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Update category set nameCategory =? where idCategory=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, category.getNameCategory());
		pstm.setInt(2,category.getIdCategory());
		rs = pstm.executeUpdate();
		}
		return rs;
	}
	public int deleteCategory(Integer idCategory) throws SQLException, ClassNotFoundException{
		int result =0;
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		BookBO bookBO = new BookBO();
		bookBO.deleteBookCategory(idCategory);
		String sql = "Delete From category where idCategory= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idCategory);
		result = pstm.executeUpdate();
		return result;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.findCategory(1);
		System.out.println(categoryDAO);
	}
	public int deleteAllCategory() throws SQLException, ClassNotFoundException{
		int result = 0;
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "delete From category";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		result = pstm.executeUpdate();
		return result;
	}
}
