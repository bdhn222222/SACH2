package model.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bo.UserBO;

import java.io.IOException;
import java.sql.SQLException;


import model.bean.User;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " " + password);
		UserBO userBO = new UserBO();
//		String errorMessage = "";
		
		try {
			User user = userBO.getUser(username, password);
			System.out.println(username + " " + password);
			System.out.println("from Login " + user);
			if(user == null) {
				request.setAttribute("errorString", "*Your username/password is invalid!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("userSession", user);
				session.setAttribute("loginSession", true);
				response.sendRedirect("home.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}