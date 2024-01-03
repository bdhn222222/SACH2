package model.bo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Book;
import model.bean.Ticket;
import model.dao.TicketDAO;

public class TicketBO {
    private TicketDAO ticketDAO;

    public TicketBO() {
        ticketDAO = new TicketDAO();
    }

    public List<Ticket> searchTicketsByBookName(String bookNameSearch) throws ClassNotFoundException, SQLException {
        return ticketDAO.searchTicketsByBookName(bookNameSearch);
    }

    public List<Ticket> searchTicketsByReaderName(String readerNameSearch) throws ClassNotFoundException, SQLException {
        return ticketDAO.searchTicketsByReaderName(readerNameSearch);
    }

    public Ticket findTicket(Integer idTicket) throws ClassNotFoundException, SQLException {
        return ticketDAO.findTicket(idTicket);
    }

    public int insertTicket(Ticket ticket) throws ClassNotFoundException, SQLException {
        return ticketDAO.insertTicket(ticket);
    }

    public ArrayList<Ticket> getAllTicket() throws SQLException, ClassNotFoundException {
        return ticketDAO.getAllTicket();
    }

    public int updateTicket(Ticket ticket) throws ClassNotFoundException, SQLException {
        return ticketDAO.updateTicket(ticket);
    }

    public boolean deleteTicket (Integer ticket) throws SQLException, ClassNotFoundException{
		int result = ticketDAO.deleteTicket(ticket);
		if (result != 0)
			return true;
		return false;
	}
    public ArrayList<Ticket> getTicketbyReader(Integer idReader) throws SQLException, ClassNotFoundException{
		return ticketDAO.getTicketbyReader(idReader);
	}
	public ArrayList<Ticket> getTicketbyBook(Integer idBook) throws SQLException, ClassNotFoundException{
		return ticketDAO.getTicketbyBook(idBook);
	}
	public ArrayList<Ticket>getTicketbyRent_ReturnDay(Integer ticket) throws SQLException, ClassNotFoundException{
		return ticketDAO.getTicketbyRent_ReturnDay(ticket);
	}
	public ArrayList<Ticket>getTicketbyReturn_ImreturnDay(Integer ticket) throws SQLException, ClassNotFoundException{
		return ticketDAO.getTicketbyReturn_ImreturnDay(ticket);
	}
    public int deleteAllTicket() throws ClassNotFoundException, SQLException {
        return ticketDAO.deleteAllTicket();
    }

    public int updateStatus1(String idTicket) throws SQLException, ClassNotFoundException {
        return ticketDAO.updateStatus1(idTicket);
    }

    public int updateStatus0(String idTicket) throws SQLException, ClassNotFoundException {
        return ticketDAO.updateStatus0(idTicket);
    }

    public boolean increaseAmountIfStatusIsZero(String idTicket) throws ClassNotFoundException, SQLException {
        return ticketDAO.increaseAmountIfStatusIsZero(idTicket);
    }

    public boolean decreaseAmountIfStatusIsOne(String idTicket) throws ClassNotFoundException, SQLException {
        return ticketDAO.decreaseAmountIfStatusIsOne(idTicket);
    }
}
