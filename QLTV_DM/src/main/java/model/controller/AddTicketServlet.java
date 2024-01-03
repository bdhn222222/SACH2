package model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

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

@WebServlet("/AddTicket")
public class AddTicketServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReaderBO readerBO = new ReaderBO();
    private BookBO bookBO = new BookBO();
    private TicketBO ticketBO = new TicketBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> bookList = null;
        ArrayList<Reader> readerList = null;
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
            readerList = readerBO.getAllReader();
            bookList = bookBO.getAllBook();
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("bookList", bookList);
        request.setAttribute("readerList", readerList);
        request.setAttribute("errorString", errorString);

        RequestDispatcher dispatcher = request.getRequestDispatcher("add_ticket.jsp");
        dispatcher.forward(request, response);
    }
}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idReader = request.getParameter("reader");
        String idBook = request.getParameter("book");
        String status = request.getParameter("status");
        String rentday = request.getParameter("rentday");
        String returnday = request.getParameter("returnday");
        String imreturnday = request.getParameter("imreturnday");
        System.out.print(rentday);

        if (status == null || (!status.equals("0") && !status.equals("1"))) {
            request.setAttribute("errorMessage", "Invalid status value.");
            doGet(request, response);
            return;
        }

        Reader reader = null;
        Book book = null;
        Ticket ticket = new Ticket();

        try {
            reader = readerBO.findReader(Integer.parseInt(idReader));
            book = bookBO.findBook(Integer.parseInt(idBook));

            ticket.setReader(reader);
            ticket.setBook(book);
            ticket.setStatus(status);

            ticket.setRentDay(rentday);
            ticket.setReturnDay(returnday);
            ticket.setImperativeReturnDay(imreturnday);

            int result = ticketBO.insertTicket(ticket);
            if (result > 0) {
                response.sendRedirect(request.getContextPath() + "/ManageTicket");
                return;
            } else {
                request.setAttribute("errorMessage", "Failed to add a ticket.");
            }
        } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", e.getMessage());
        }

        doGet(request, response);
    }
}
