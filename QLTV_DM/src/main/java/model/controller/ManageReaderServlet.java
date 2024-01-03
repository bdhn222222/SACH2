package model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Reader;
import model.bean.User;
import model.bo.ReaderBO;

/**
 * Servlet implementation class ManageReader
 */
@WebServlet("/ManageReader")
public class ManageReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReaderBO ReaderBO = new ReaderBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageReaderServlet() {
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
			
			ArrayList<Reader> list = null;
			String errorString = null;
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("userSession");
			if (user == null) {
				errorString = "Bạn cần đăng nhập trước";
				request.setAttribute("errorString", errorString);
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			} else {
			try {
				list = ReaderBO.getAllReader();
			} catch (Exception e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			if (request.getAttribute("errorString") != null) {
				errorString = (String) request.getAttribute("errorString");
			}
			// Lưu thông tin vào request attribute trước khi forward sang views.
			request.setAttribute("errorString", errorString);
			request.setAttribute("readerList", list);
			request.getSession().setAttribute("Check", "ManageReader");
			// Forward  sang /WEB-INF/views/productListView.jsp
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/manage_reader.jsp");
			dispatcher.forward(request, response);
		}
	}	//}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		doGet(request, response);
	}


}
