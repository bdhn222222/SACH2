package model.controller;


import model.bean.BookShelf;
import model.bean.User;
import model.bo.BookBO;
import model.bo.BookShelfBO;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ManageBook
 */
@WebServlet("/ManageBookShelf")
public class ManageBookShelfServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookShelfBO bookShelfBO = new BookShelfBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String errorString = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		if (user == null) {
			errorString = "Bạn cần đăng nhập trước";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else {
        ArrayList<BookShelf> list = null;
        try {
            list = bookShelfBO.getAllBookShelf();
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        // Lưu thông tin vào request attribute trước khi forward sang views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("BookShelfList", list);
        request.getSession().setAttribute("Check", "ManageBookShelf");

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/manage_bookshelf.jsp");
        dispatcher.forward(request, response);
    }
}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
