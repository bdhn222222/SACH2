package model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Book;
import model.bean.User;
import model.bo.BookBO;
import model.bo.BookShelfBO;

@WebServlet("/DeleteBookShelf")
public class DeleteBookShelfServlet extends HttpServlet {
    BookBO bookBO = new BookBO();
    BookShelfBO bookShelfBO = new BookShelfBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userSession");

        if (user == null) {
            String errorString = "You need to log in first!";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        int idBookShelf = Integer.parseInt(request.getParameter("idBookShelf"));
        try {
            List<Book> list = bookBO.getBookbyBookShelf(idBookShelf);

            if (list != null && !list.isEmpty()) {
                String errorString = "BookShelf has associated books, cannot be deleted!";
                request.setAttribute("errorString", errorString);
            } else {
                boolean result = bookShelfBO.deleteBookShelf(idBookShelf);
                if (result) {
                    String successString = "Deleted successfully";
                    request.setAttribute("successString", successString);
                } else {
                    String errorString = "Database error. Deletion failed.";
                    request.setAttribute("errorString", errorString);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            String errorString = "Error: " + e.getMessage();
            request.setAttribute("errorString", errorString);
        }

        // Redirect back to the ManageBookShelf servlet
        response.sendRedirect(request.getContextPath() + "/ManageBookShelf");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
