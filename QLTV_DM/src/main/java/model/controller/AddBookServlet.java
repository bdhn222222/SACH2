package model.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.bean.Authors;
import model.bean.Book;
import model.bean.BookShelf;
import model.bean.Category;
import model.bean.User;
import model.bo.AuthorsBO;
import model.bo.BookBO;
import model.bo.BookShelfBO;
import model.bo.CategoryBO;

@WebServlet("/AddBook")
@MultipartConfig
public class AddBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryBO categoryBO = new CategoryBO();
    private AuthorsBO authorsBO = new AuthorsBO();
    private BookShelfBO bookshelfBO = new BookShelfBO();
    private BookBO bookBO = new BookBO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Category> categoryList = null;
        List<BookShelf> bookShelfList = null;
        List<Authors> authorsList = null;
        String errorString = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		if (user == null) {
			errorString = "You need login first!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else 
			{
		        try {
		            categoryList = categoryBO.list();
		            bookShelfList = bookshelfBO.getAllBookShelf();
		            authorsList = authorsBO.list();
		
		        } catch (Exception e) {
		            e.printStackTrace();
		            errorString = e.getMessage();
		        }
		
		        request.setAttribute("categoryList", categoryList);
		        request.setAttribute("bookShelfList", bookShelfList);
		        request.setAttribute("authorsList", authorsList);
		        request.getSession().setAttribute("Check", "AddBook");
		
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/add_book.jsp");
		        dispatcher.forward(request, response);
		    }
}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nameBook = request.getParameter("nameBook");
        Part file = request.getPart("image");
//		String path = getServletContext().getRealPath("/") + "Resources/images/";
		String savePath = getServletContext().getRealPath("/") + "Resources\\img\\products";
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		String fileName = extractfilename(file);
		file.write(savePath + File.separator + fileName);
//		String filePath = savePath + File.separator + fileName;
        String idCategory = request.getParameter("category");
        String idBookShelf = request.getParameter("bookShelf");
        String idAuthors = request.getParameter("authors");
        Integer amount = Integer.parseInt(request.getParameter("amount"));
        Book book = new Book();
        book.setNameBook(nameBook);
        book.setImage(fileName);
        Category category = new Category();
        try {
            int categoryId = Integer.parseInt(idCategory);
            category = categoryBO.findCategory(categoryId);
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        }
        BookShelf bookShelf = new BookShelf();
        try {
            int bookShelfId = Integer.parseInt(idBookShelf);
            bookShelf = bookshelfBO.findBookShelf(bookShelfId);
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        }
        Authors authors = new Authors();
        try {
            int authorsId = Integer.parseInt(idAuthors);
            authors = authorsBO.findAuthors(authorsId);
        } catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        }

        book.setCategory(category);
        book.setBookShelf(bookShelf);
        book.setAuthors(authors);
        book.setAmount(amount);
       
        try {
            int result = bookBO.insertBook(book);
            if (result > 0) {
                response.sendRedirect(request.getContextPath() + "/ManageBook");
            } else {
                request.setAttribute("errorMessage", "Failed to add a book.");
                doGet(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", e.getMessage());
            doGet(request, response);
        }
    }
    private String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}
		return "";
	}
}