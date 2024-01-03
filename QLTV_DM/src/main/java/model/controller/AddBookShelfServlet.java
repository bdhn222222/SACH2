package model.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.BookShelf;
import model.bean.User;
import model.bo.BookShelfBO;

@WebServlet("/AddBookShelf")
public class AddBookShelfServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookShelfBO bookShelfBO = new BookShelfBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String errorString = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		if (user == null) {
			errorString = "You need login first!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/add_bookshelf.jsp");
        dispatcher.forward(request, response);
    }
}		

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nameBookShelf = request.getParameter("nameBookShelf");
        BookShelf newBookShelf = new BookShelf();
        newBookShelf.setNameBookShelf(nameBookShelf);

        try {
            int result = bookShelfBO.insertBookShelf(newBookShelf);
            if (result != 0) {
                // Insert thành công
                response.sendRedirect(request.getContextPath() + "/ManageBookShelf");
            } else {
                // Insert thất bại
                String errorString = "Thêm thất bại";
                request.setAttribute("errorString", errorString);
                // Forward hoặc redirect tới trang thông báo lỗi
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ nếu cần thiết
        }
    }
}
