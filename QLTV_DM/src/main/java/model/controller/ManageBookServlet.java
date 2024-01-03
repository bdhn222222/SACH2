package model.controller;

import model.bean.Authors;
import model.bean.Book;
import model.bean.BookShelf;
import model.bean.Category;
import model.bean.User;
import model.bo.AuthorsBO;
import model.bo.BookBO;
import model.bo.BookShelfBO;
import model.bo.CategoryBO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ManageBook")
public class ManageBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryBO categoryBO = new CategoryBO();
    private AuthorsBO authorsBO = new AuthorsBO();
    private BookShelfBO bookshelfBO = new BookShelfBO();
    private BookBO bookBO = new BookBO();

    public ManageBookServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorString = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userSession");
        if (user == null) {
            errorString = "Bạn cần đăng nhập trước";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            List<Category> categoryList = null;
            List<BookShelf> bookShelfList = null;
            List<Authors> authorsList = null;
            ArrayList<Book> list = null;

            try {
                list = bookBO.getAllBook();
                categoryList = categoryBO.list();
                bookShelfList = bookshelfBO.getAllBookShelf();
                authorsList = authorsBO.list();
            } catch (Exception e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }

            if (request.getAttribute("errorString") != null) {
                errorString = (String) request.getAttribute("errorString");
            }

            request.setAttribute("errorString", errorString);
            request.setAttribute("categoryList", categoryList);
            request.setAttribute("bookShelfList", bookShelfList);
            request.setAttribute("authorsList", authorsList);
            request.setAttribute("bookList", list);
            request.getSession().setAttribute("Check", "ManageBook");

            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/manage_book.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}