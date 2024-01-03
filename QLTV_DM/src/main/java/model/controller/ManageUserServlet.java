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
import model.bean.User;
import model.bean.Category;
import model.bean.User;
import model.bo.UserBO;

@WebServlet("/ManageUser")
public class ManageUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserBO userBO = new UserBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String errorString = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		if (user == null) {
			errorString = "You need Login first!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else {
			try {
            ArrayList<User> userList = userBO.list();
            // Gửi danh sách tác giả về cho trang JSP hiển thị
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("manage_user.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            // Xử lý các ngoại lệ nếu cần
            e.printStackTrace();
        }
    }
}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý các thao tác POST nếu cần
    }
}
