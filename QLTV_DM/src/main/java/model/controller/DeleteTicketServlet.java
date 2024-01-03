package model.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.User;
import model.bo.BookBO;

import java.io.IOException;
import java.sql.SQLException;
import model.bo.TicketBO;
import model.bean.Ticket;

/**
 * Servlet implementation class DeleteTicketServlet
 */
@WebServlet("/DeleteTicket")
public class DeleteTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TicketBO ticketBO = new TicketBO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		boolean result;
		try {
			Integer ticketID = Integer.parseInt(idTicket);
			result = ticketBO.deleteTicket(ticketID);
			System.out.println("Ket qua"+result);
			if (result == true) {
				request.setAttribute("errorString", "Đã xóa thành công");
			} else {
				System.out.println("DeleteAuthorsServlet - doGet() called");
				request.setAttribute("errorString", "Lỗi cơ sở dữ liệu");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		RequestDispatchesr dispatcher = request.getServletContext().getRequestDispatcher("/ManageAuthors");
//		dispatcher.forward(request, response);
		response.sendRedirect("ManageTicket");
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
