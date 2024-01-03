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

@WebServlet("/EditCategory")
public class EditCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
        String idCategoryStr = request.getParameter("idCategory");
        
        if (idCategoryStr != null && !idCategoryStr.isEmpty()) {
            try {
                int idCategory = Integer.parseInt(idCategoryStr);
                CategoryBO categoryBO = new CategoryBO();
                Category category = categoryBO.findCategory(idCategory);
                
                if (category != null) {
                    request.setAttribute("category", category);
                    request.getRequestDispatcher("/edit_category.jsp").forward(request, response);
                } else {
                    response.getWriter().println("Category not found!");
                }
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred while processing your request.");
            }
        } else {
            response.getWriter().println("Invalid category ID!");
        }
    }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idCategoryStr = request.getParameter("idCategory");
        String nameCategory = request.getParameter("nameCategory");

        if (idCategoryStr != null && !idCategoryStr.isEmpty()) {
            try {
                int idCategory = Integer.parseInt(idCategoryStr);
                Category category = new Category();
                category.setIdCategory(idCategory);
                category.setNameCategory(nameCategory);

                CategoryBO categoryBO = new CategoryBO();
                int result = categoryBO.updateCategory(category);

                if (result != 0) {
                    response.sendRedirect(request.getContextPath() + "/ManageCategory");
                } else {
                    response.getWriter().println("Update failed!");
                }
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred while processing your request.");
            }
        } else {
            response.getWriter().println("Invalid category ID!");
        }
    }
}
