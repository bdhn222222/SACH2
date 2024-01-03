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

@WebServlet("/EditAuthors")
public class EditAuthorsServlet extends HttpServlet {
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
        String idAuthorsStr = request.getParameter("idAuthors");
        
        if (idAuthorsStr != null && !idAuthorsStr.isEmpty()) {
            try {
                int idAuthors = Integer.parseInt(idAuthorsStr);
                AuthorsBO authorsBO = new AuthorsBO();
                Authors authors = authorsBO.findAuthors(idAuthors);
                
                if (authors != null) {
                    request.setAttribute("authors", authors);
                    request.getRequestDispatcher("/edit_authors.jsp").forward(request, response);
                } else {
                    response.getWriter().println("Authors not found!");
                }
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred while processing your request.");
            }
        } else {
            response.getWriter().println("Invalid Authors ID!");
        }
    }
}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idAuthorsStr = request.getParameter("idAuthors");
        String nameAuthors = request.getParameter("nameAuthors");

        if (idAuthorsStr != null && !idAuthorsStr.isEmpty()) {
            try {
                int idAuthors = Integer.parseInt(idAuthorsStr);
                Authors authors = new Authors();
                authors.setIdAuthors(idAuthors);
                authors.setNameAuthors(nameAuthors);

                AuthorsBO authorsBO = new AuthorsBO();
                int result = authorsBO.updateAuthors(authors);

                if (result != 0) {
                    response.sendRedirect(request.getContextPath() + "/ManageAuthors");
                } else {
                    response.getWriter().println("Update failed!");
                }
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred while processing your request.");
            }
        } else {
            response.getWriter().println("Invalid Authors ID!");
        }
    }
}
