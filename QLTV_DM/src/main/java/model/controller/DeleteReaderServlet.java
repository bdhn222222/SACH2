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
import model.bean.Reader;
import model.bean.Ticket;
import model.bean.User;
import model.bo.ReaderBO;
import model.bo.TicketBO;

@WebServlet("/DeleteReader")
public class DeleteReaderServlet extends HttpServlet {
    ReaderBO readerBO = new ReaderBO();
    TicketBO ticketBO = new TicketBO();

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

        int idReader = Integer.parseInt(request.getParameter("idReader"));
        try {
            List<Ticket> list = ticketBO.getTicketbyReader(idReader);

            if (list != null && !list.isEmpty()) {
                String errorString = "Reader has associated Ticket, cannot be deleted!";
                request.setAttribute("errorString", errorString);
            } else {
                boolean result= readerBO.deleteReader(idReader);
                if (result) {
                    String successString = "Deleted successfully";
                    request.setAttribute("successString", successString);
                } else {
                    String errorString = " Reader has associated Ticket, cannot be deleted!";
                    request.setAttribute("errorString", errorString);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            String errorString = "Error: " + e.getMessage();
            request.setAttribute("errorString", errorString);
        }

        // Redirect back to the ManageReader servlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ManageReader");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

