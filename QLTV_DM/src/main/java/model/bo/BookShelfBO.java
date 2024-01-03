package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.BookShelf;
import model.dao.BookShelfDAO;

public class BookShelfBO {
	static BookShelfDAO bookShelfDAO = new BookShelfDAO();
	public BookShelf findBookShelf(Integer idBookShelf) throws ClassNotFoundException, SQLException {
		return bookShelfDAO.findBookShelf(idBookShelf);
	}
	public int insertBookShelf(BookShelf BookShelf) throws ClassNotFoundException, SQLException {
		int result= 0;
		result=bookShelfDAO.insertBookShelf(BookShelf);
		return result;
	}
	 public ArrayList<BookShelf> getAllBookShelf() throws SQLException, ClassNotFoundException {
		 return bookShelfDAO.getAllBookShelf();
	}
	 public static ArrayList<BookShelf> getSearchBookShelf(String nameBookShelf) throws SQLException, ClassNotFoundException {
		 return bookShelfDAO.getSearchBookShelf(nameBookShelf);
	}
	public boolean deleteBookShelf(int idBookShelf) throws ClassNotFoundException, SQLException {
		int result = bookShelfDAO.deleteBookShelf(idBookShelf);
		if (result != 0)
			return true;
		return false;
	}
	public int updateBookShelf(BookShelf BookShelf) throws ClassNotFoundException, SQLException {
		return bookShelfDAO.updateBookShelf(BookShelf);
	}
	public int deleteAllBookShelf() throws SQLException, ClassNotFoundException{
		int rs = 0;
		rs = bookShelfDAO.deleteAllBookShelf();
		return rs;
	}
}
