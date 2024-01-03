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
import model.bean.Category;
import model.bean.User;
import model.bo.CategoryBO;



/**
 * Servlet implementation class AddCategory
 */
@WebServlet("/AddCategory")
public class AddCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryBO categoryBO = new CategoryBO();

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/add_category.jsp");
        dispatcher.forward(request, response);
		}
}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nameCategory = request.getParameter("nameCategory");

        Category category = new Category();
        category.setNameCategory(nameCategory);

        try {
            int result = categoryBO.insertCategory(category);
            if (result > 0) {
                // Nếu thêm thành công, có thể chuyển hướng đến trang khác hoặc hiển thị thông báo thành công
                response.sendRedirect("ManageCategory"); // Chuyển hướng đến trang quản lý danh mục
            } else {
                // Xử lý khi thêm không thành công, có thể hiển thị thông báo lỗi
                String errorMessage = "Thêm danh mục không thành công";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/add_category.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            // Xử lý exception nếu có
            e.printStackTrace();
            String errorMessage = "Đã xảy ra lỗi khi thêm danh mục";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/add_category.jsp");
            dispatcher.forward(request, response);
        }
    }
}
