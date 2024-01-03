package model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Book;
import model.bean.Reader;
import model.bean.Ticket;
import model.bean.User;
import model.bo.BookBO;
import model.bo.ReaderBO;
import model.bo.TicketBO;

@WebServlet("/ManageTicket")
public class ManageTicketServlet extends HttpServlet {
    private ReaderBO readerBO = new ReaderBO();
    private BookBO bookBO = new BookBO();
    private TicketBO ticketBO = new TicketBO();
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reader> readerList = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        List<Ticket> ticketList = new ArrayList<>();
        String errorString = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		if (user == null) {
			errorString = "You need login first!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else {
        try {
        	ticketList = ticketBO.getAllTicket();
            readerList = readerBO.getAllReader();
            bookList = bookBO.getAllBook();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("bookList", bookList);
        request.setAttribute("readerList", readerList);
        request.setAttribute("ticketList", ticketList);
        request.getSession().setAttribute("Check", "ManageTicket");

        // Forward to /WEB-INF/views/manage_ticket.jsp
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/manage_ticket.jsp");
        dispatcher.forward(request, response);
    }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}