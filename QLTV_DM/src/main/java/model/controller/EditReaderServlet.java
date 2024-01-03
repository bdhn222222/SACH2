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
import model.bean.Reader;
import model.bean.User;
import model.bo.ReaderBO;

@WebServlet("/EditReader")
public class EditReaderServlet extends HttpServlet {
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
			String idReaderStr = request.getParameter("idReader");
			System.out.print(idReaderStr);

        if (idReaderStr != null && !idReaderStr.isEmpty()) {
            try {
                Integer idReader = Integer.parseInt(request.getParameter("idReader"));
                ReaderBO readerBO = new ReaderBO();
                Reader reader = readerBO.findReader(idReader);

                if (reader != null) {
                    request.setAttribute("reader", reader);
                    request.getRequestDispatcher("/edit_reader.jsp").forward(request, response);
                } else {
                    response.getWriter().println("Reader not found!");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idReaderStr = request.getParameter("idReader");
        String nameReader = request.getParameter("nameReader");
        String identity = request.getParameter("identity");
        String telReader = request.getParameter("telReader");

        if (idReaderStr != null && !idReaderStr.isEmpty()) {
            try {
                int idReader = Integer.parseInt(idReaderStr);
                Reader reader = new Reader();
                reader.setIdReader(idReader);
                reader.setNameReader(nameReader);
                reader.setIdentity(identity);
                reader.setTelReader(telReader);

                ReaderBO readerBO = new ReaderBO();
                int result = readerBO.updateReader(reader);

                if (result != 0) {
                    response.sendRedirect(request.getContextPath() + "/ManageReader");
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
