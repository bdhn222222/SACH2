package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Category;
import model.dao.CategoryDAO;

public class CategoryBO {
	CategoryDAO categoryDAO = new CategoryDAO();
	public Category findCategory(Integer idCategory) throws ClassNotFoundException, SQLException {
		return categoryDAO.findCategory(idCategory);
	}
	public int insertCategory(Category category) throws ClassNotFoundException, SQLException {
		int result= 0;
		result=categoryDAO.insertCategory(category);
		return result;
	}
	public ArrayList<Category> list() throws ClassNotFoundException, SQLException {
		return categoryDAO.getAllCategory();
	}
	public boolean deleteCategory(Integer idCategory) throws ClassNotFoundException, SQLException {
		int result = categoryDAO.deleteCategory(idCategory);
		if (result != 0)
			return true;
		return false;
	}
	public int deleteAllCategory() throws SQLException, ClassNotFoundException{
		int rs = 0;
		rs = categoryDAO.deleteAllCategory();
		return rs;
	}
	public int updateCategory(Category category) throws ClassNotFoundException, SQLException {
		return categoryDAO.updateCategory(category);
	}
}
