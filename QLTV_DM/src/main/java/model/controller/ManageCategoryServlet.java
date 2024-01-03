package model.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Category;
import model.bean.User;
import model.bo.CategoryBO;

/**
 * Servlet implementation class ManageCategory
 */
@WebServlet("/ManageCategory")
public class ManageCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryBO categoryBO = new CategoryBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*if (request.getSession().getAttribute("User") == null) {
			String errorString = "Bạn cần đăng nhập trước";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else {*/
			String errorString = null;
			ArrayList<Category> list = null;
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("userSession");
			if (user == null) {
				errorString = "Bạn cần đăng nhập trước";
				request.setAttribute("errorString", errorString);
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			} else {
				try {
					list = categoryBO.list();
				} catch (Exception e) {
					e.printStackTrace();
					errorString = e.getMessage();
				}
				if (request.getAttribute("errorString") != null) {
					errorString = (String) request.getAttribute("errorString");
				}
				// Lưu thông tin vào request attribute trước khi forward sang views.
				request.setAttribute("errorString", errorString);
				request.setAttribute("categoryList", list);
				request.getSession().setAttribute("Check", "ManageCategory");
				// Forward  sang /WEB-INF/views/productListView.jsp
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/manage_category.jsp");
				dispatcher.forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
