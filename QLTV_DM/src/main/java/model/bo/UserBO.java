package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.User;
import model.bean.User;
import model.bean.User;
import model.bean.User;
import model.dao.UserDAO;

public class UserBO {
	UserDAO userDAO = new UserDAO();

	public User getUser(String username, String password) throws ClassNotFoundException, SQLException {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return userDAO.getUser(username, password);
	}
	public User findUser(int idUser) throws ClassNotFoundException, SQLException {
		return userDAO.findUser(idUser);
	}
	public int insertUser(User user) throws ClassNotFoundException, SQLException {
		int result= 0;
		result=userDAO.insertUser(user);
		return result;
	}
	public ArrayList<User> list() throws ClassNotFoundException, SQLException {
		return userDAO.getAllUser();
	}
	public boolean deleteUser(int idUser) throws ClassNotFoundException, SQLException {
		int result = userDAO.deleteUser(idUser);
		if (result != 0)
			return true;
		return false;
	}
	public int updateUser(User user) throws ClassNotFoundException, SQLException {
		return userDAO.updateUser(user);
	}
}
