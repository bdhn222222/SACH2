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
import model.bean.Authors;
import model.bean.User;
import model.bo.AuthorsBO;



/**
 * Servlet implementation class AddAuthors
 */
@WebServlet("/AddAuthors")
public class AddAuthorsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AuthorsBO authorsBO = new AuthorsBO();

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
        // Hiển thị form thêm danh mục khi nhận yêu cầu GET
        RequestDispatcher dispatcher = request.getRequestDispatcher("/add_authors.jsp");
        dispatcher.forward(request, response);
    }
}		
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        request.setCharacterEncoding("UTF-8");
        String nameAuthors = request.getParameter("nameAuthors");

        Authors authors = new Authors();
        authors.setNameAuthors(nameAuthors);

        try {
            int result = authorsBO.insertAuthors(authors);
            if (result > 0) {
                // Nếu thêm thành công, có thể chuyển hướng đến trang khác hoặc hiển thị thông báo thành công
                response.sendRedirect("ManageAuthors"); // Chuyển hướng đến trang quản lý danh mục
            } else {
                // Xử lý khi thêm không thành công, có thể hiển thị thông báo lỗi
                String errorMessage = "Thêm danh mục không thành công";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/add_authors.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            // Xử lý exception nếu có
            e.printStackTrace();
            String errorMessage = "Đã xảy ra lỗi khi thêm danh mục";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/add_authors.jsp");
            dispatcher.forward(request, response);
        }
    }
}
