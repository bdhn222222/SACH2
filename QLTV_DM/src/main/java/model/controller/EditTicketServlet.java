package model.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Authors;
import model.bean.Book;
import model.bean.BookShelf;
import model.bean.Category;
import model.bean.Reader;
import model.bean.Ticket;
import model.bean.User;
import model.bo.AuthorsBO;
import model.bo.BookBO;
import model.bo.CategoryBO;
import model.bo.ReaderBO;
import model.bo.TicketBO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class EditTicketServlet
 */
@WebServlet("/EditTicket")
public class EditTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReaderBO readerBO = new ReaderBO();
    private BookBO bookBO = new BookBO();
    private TicketBO ticketBO = new TicketBO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errorString = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		if (user == null) {
			errorString = "You need login first!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else {
		String idTicket = request.getParameter("idTicket");
		System.out.print(idTicket);
		List<Reader> readerList = null;
        List<Book> bookList = null; 
        ArrayList<Ticket> ticketList = null;

        if (idTicket != null && !idTicket.isEmpty()) {
        	try {
                Integer ticketID = Integer.parseInt(idTicket);
                Ticket ticket = ticketBO.findTicket(ticketID);
                ticketList = ticketBO.getAllTicket();
                bookList = bookBO.getAllBook();
                readerList = readerBO.getAllReader();

                if (ticket != null) {
                    request.setAttribute("ticket", ticket);
                    request.setAttribute("errorString", errorString);
                    request.setAttribute("ticketList", ticketList);
                    request.setAttribute("readerList", readerList);
                    request.setAttribute("bookList", bookList);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/edit_ticket.jsp");
                    dispatcher.forward(request, response);
                } else {
                    errorString = "Ticket not found!";
                    request.setAttribute("errorString", errorString);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                errorString = "An error occurred while processing your request.";
                request.setAttribute("errorString", errorString);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        }
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String idTicket = request.getParameter("idTicket");
        String idBook = request.getParameter("book");
        String idReader = request.getParameter("reader");
        String status = request.getParameter("status");
        String rentday = request.getParameter("rentday");
        String returnday = request.getParameter("returnday");
        String imperativeReturnDay = request.getParameter("imperativeReturnDay");
        

        if (idTicket != null && !idTicket.isEmpty()) {
            try {
                Integer ticketID = Integer.parseInt(idTicket);
                Ticket ticket = new Ticket();
                Book book = new Book();
                Reader reader = new Reader();

                try {
                    int bookId = Integer.parseInt(idBook);
                    book = bookBO.findBook(bookId);
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                    request.setAttribute("errorMessage", "Failed to find category.");
                    doGet(request, response);
                    return;
                }

                try {
                    int readerID = Integer.parseInt(idReader);
                    reader = readerBO.findReader(readerID);
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                    request.setAttribute("errorMessage", "Failed to find book shelf.");
                    doGet(request, response);
                    return;
                }

                ticket.setIdTicket(ticketID);
                ticket.setBook(book);
                ticket.setReader(reader);
                ticket.setStatus(status);
                ticket.setRentDay(rentday);
                ticket.setReturnDay(returnday);
                ticket.setImperativeReturnDay(imperativeReturnDay);

                TicketBO ticketBO = new TicketBO();
                   int result = ticketBO.updateTicket(ticket);
                   
                   if (result != 0) {
                       response.sendRedirect(request.getContextPath() + "/ManageTicket");
                   } else {
                       response.getWriter().println("Update failed!");
                   }
               } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
            	    e.printStackTrace();
                    response.getWriter().println("An error occurred while processing your request.");
            	}
           } else {
               response.getWriter().println("Invalid reader ID!");
           }
       }

}
