package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.bean.Authors;
import model.bean.Book;
import model.bean.BookShelf;
import model.bean.Category;
import model.bean.Reader;
import model.bean.Ticket;
import model.bo.BookBO;
import model.bo.BookShelfBO;
import model.bo.CategoryBO;
import model.bo.ReaderBO;

public class TicketDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	Statement stmStatement = null;
	Book book = new Book();
	BookBO bookBO = new BookBO();
	CategoryBO categoryBO = new CategoryBO();
	BookShelfBO bookShelfBO = new BookShelfBO();
	ReaderBO readerBO = new ReaderBO();
	

	public List<Ticket> searchTicketsByBookName(String bookNameSearch) throws ClassNotFoundException, SQLException {
	    if(conn == null)
	        conn = ConnectDatabase.getMySQLConnection();
	    
	    String sql = "SELECT t.* FROM ticket t INNER JOIN Book b ON t.idBook = b.idBook WHERE b.nameBook LIKE ?";
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, "%" + bookNameSearch + "%");
	    ResultSet rs = pstm.executeQuery();
	    List<Ticket> tickets = new ArrayList<>();
	    
	    while(rs.next()) {
	        Integer idTicket = rs.getInt("idTicket");
	        Integer idBook = rs.getInt("idBook");
	        Integer idReader = rs.getInt("idReader");
	        String status = rs.getString("status");
	        String rentday = rs.getString("rentday");
	        String returnday = rs.getString("returnday");
	        String imperativeReturnDay = rs.getString("imperativeReturnDay");
	        Book book = null;
	        try {
	            book = bookBO.findBook(idBook);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        Reader reader = null;
	        try {
	            reader = readerBO.findReader(idReader);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        Ticket ticket = new Ticket();
	        ticket.setIdTicket(idTicket);
	        ticket.setBook(book);
	        ticket.setReader(reader);
	        ticket.setStatus(status);
	        ticket.setRentDay(rentday);
	        ticket.setReturnDay(returnday);
	        ticket.setImperativeReturnDay(imperativeReturnDay);
	        tickets.add(ticket);
	    }
	    
	    return tickets;
	}
	
	public List<Ticket> searchTicketsByReaderName(String readerNameSearch) throws ClassNotFoundException, SQLException {
	    if(conn == null)
	        conn = ConnectDatabase.getMySQLConnection();
	    
	    String sql = "SELECT t.* FROM ticket t INNER JOIN [Reader] r ON t.idReader = r.idReader WHERE r.nameReader = ?";
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1,  "%" + readerNameSearch + "%");
	    ResultSet rs = pstm.executeQuery();
	    
	    List<Ticket> tickets = new ArrayList<>();
	    
	    while(rs.next()) {
	    	Integer idTicket1 = rs.getInt("idTicket");
	        Integer idBook = rs.getInt("idBook");
	        Integer idReader = rs.getInt("idReader");
	        String status = rs.getString("status");
	        String rentday = rs.getString("rentday");
	        String returnday = rs.getString("returnday");
	        String imperativeReturnDay = rs.getString("imperativeReturnDay");
	        Book book = null;
	        try {
	            book = bookBO.findBook(idBook);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        Reader reader = null;
	        try {
	            reader = readerBO.findReader(idReader);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        Ticket ticket = new Ticket();
	        ticket.setIdTicket(idTicket1);
	        ticket.setBook(book);
	        ticket.setReader(reader);
	        ticket.setStatus(status);
	        ticket.setRentDay(rentday);
	        ticket.setReturnDay(returnday);
	        ticket.setImperativeReturnDay(imperativeReturnDay);
	        tickets.add(ticket);
	    }
	    
	    return tickets;
	}
	public Ticket findTicket(Integer idTicket) throws ClassNotFoundException, SQLException {
	    if(conn == null)
	        conn = ConnectDatabase.getMySQLConnection();
	    
	    String sql = "select * from ticket where idTicket  = ?";
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setInt(1, idTicket);
	    ResultSet rs = pstm.executeQuery();
	    
	    
	    while(rs.next()) {
	        Integer idTicket1 = rs.getInt("idTicket");
	        Integer idBook = rs.getInt("idBook");
	        Integer idReader = rs.getInt("idReader");
	        String status = rs.getString("status");
	        String rentday = rs.getString("rentday");
	        String returnday = rs.getString("returnday");
	        String imperativeReturnDay = rs.getString("imperativeReturnDay");

	        Book book = null;
	        try {
	            book = bookBO.findBook(idBook);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        Reader reader = null;
	        try {
	            reader = readerBO.findReader(idReader);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        Ticket ticket = new Ticket();
	        ticket.setIdTicket(idTicket1);
	        ticket.setBook(book);
	        ticket.setReader(reader);
	        ticket.setStatus(status);
	        ticket.setRentDay(rentday);
	        ticket.setReturnDay(returnday);
	        ticket.setImperativeReturnDay(imperativeReturnDay);
	        return ticket;
	    }
	    
	    return null;
	}
	public int insertTicket(Ticket ticket) throws ClassNotFoundException, SQLException{
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "insert into ticket (idBook, idReader, status, rentDay, returnDay, imperativeReturnDay) values (?,?,?,?,?,?)";
		int result = 0;
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, ticket.getBook().getIdBook());
		pstm.setInt(2, ticket.getReader().getIdReader());
		pstm.setString(3, ticket.getStatus());
		pstm.setString(4, ticket.getReturnDay()); 
	    pstm.setString(5, ticket.getRentDay());
	    pstm.setString(6, ticket.getImperativeReturnDay());
	    result = pstm.executeUpdate();
		return result;
	}
	public ArrayList<Ticket> getAllTicket() throws SQLException, ClassNotFoundException {
	    ArrayList<Ticket> list = new ArrayList<>();
	    if (conn == null)
	        conn = ConnectDatabase.getMySQLConnection();

	    String sql = "SELECT * FROM ticket";
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();

	    while (rs.next()) {
	    	Integer idTicket = rs.getInt("idTicket");
	        Integer idBook = rs.getInt("idBook");
	        Integer idReader = rs.getInt("idReader");
	        String status = rs.getString("status");
	        String rentday = rs.getString("rentday");
	        String returnday = rs.getString("returnday");
	        String imperativeReturnDay = rs.getString("imperativeReturnDay");
	        Book book = new Book();
			try {
				book = bookBO.findBook(idBook);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Reader reader = new Reader();
			try {
				reader = readerBO.findReader(idReader);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        Ticket ticket = new Ticket();
	        ticket.setIdTicket(idTicket);
	        ticket.setBook(book);
	        ticket.setReader(reader);
	        ticket.setStatus(status);
	        ticket.setRentDay(rentday);
	        ticket.setReturnDay(returnday);
	        ticket.setImperativeReturnDay(imperativeReturnDay);

	        list.add(ticket);
	    }
	    return list;
	}
	public int updateTicket(Ticket ticket) throws ClassNotFoundException, SQLException {
	    if(conn == null)
	        conn = ConnectDatabase.getMySQLConnection();

	    String sql = "UPDATE ticket SET idBook = ?, idReader = ?, returnDay = ?, rentDay = ?, imperativeReturnDay = ?, status = ? WHERE idTicket = ?";
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setInt(1, ticket.getBook().getIdBook());
	    pstm.setInt(2, ticket.getReader().getIdReader());
	    pstm.setString(3, ticket.getReturnDay());
	    pstm.setString(4, ticket.getRentDay());
	    pstm.setString(5, ticket.getImperativeReturnDay());
	    pstm.setString(6, ticket.getStatus());
	    pstm.setInt(7, ticket.getIdTicket());

	    return pstm.executeUpdate();
	}
	public int deleteTicket(int idTicket) throws ClassNotFoundException, SQLException {
	    if(conn == null)
	        conn = ConnectDatabase.getMySQLConnection();
	    try {
		    String sql = "delete from ticket where idTicket = ?";
		    PreparedStatement pstm = conn.prepareStatement(sql);
		    pstm.setInt(1, idTicket);
		    return pstm.executeUpdate();
	    } catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
	    	return 0;
		}
	}
	public int deleteAllTicket() throws ClassNotFoundException, SQLException {
	    if(conn == null)
	        conn = ConnectDatabase.getMySQLConnection();

	    String sql = "DELETE FROM ticket";
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    return pstm.executeUpdate();
	}
	public int updateStatus1(String idTicket) throws SQLException, ClassNotFoundException {
		
		int result = 0;
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "update ticket set status=1  where idTicket=? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, idTicket);
		result = pstm.executeUpdate();
		return result;
	}
public int updateStatus0(String idTicket) throws SQLException, ClassNotFoundException {
		
		int result = 0;
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "update ticket set status=0  where idTicket=? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, idTicket);
		result = pstm.executeUpdate();
		return result;
	}

	public boolean increaseAmountIfStatusIsZero(String idTicket) throws ClassNotFoundException, SQLException {
	    if (conn == null)
	        conn = ConnectDatabase.getMySQLConnection();

	    conn.setAutoCommit(false); // Bắt đầu giao dịch

	    try {
	        String updateTicketQuery = "UPDATE ticket SET status = 0 WHERE idTicket = ?";
	        PreparedStatement updateTicketStmt = conn.prepareStatement(updateTicketQuery);
	        updateTicketStmt.setString(1, idTicket);
	        int updatedRows = updateTicketStmt.executeUpdate();

	        if (updatedRows > 0) {
	            String getBookIdQuery = "SELECT idBook FROM ticket WHERE idTicket = ?";
	            PreparedStatement getBookIdStmt = conn.prepareStatement(getBookIdQuery);
	            getBookIdStmt.setString(1, idTicket);
	            ResultSet bookIdResultSet = getBookIdStmt.executeQuery();

	            if (bookIdResultSet.next()) {
	                String idBook = bookIdResultSet.getString("idBook");

	                String updateBookQuery = "UPDATE [Book] SET amount = amount + 1 WHERE idBook = ?";
	                PreparedStatement updateBookStmt = conn.prepareStatement(updateBookQuery);
	                updateBookStmt.setString(1, idBook);
	                updateBookStmt.executeUpdate();

	                conn.commit(); // Thực hiện giao dịch
	                return true; // Nếu cập nhật thành công cả hai bảng
	            }
	        }
	        conn.rollback(); // Quay lại trạng thái ban đầu nếu không thực hiện được cập nhật
	        return false; // Trả về false nếu không thể cập nhật được dữ liệu
	    } catch (SQLException e) {
	        conn.rollback(); // Quay lại trạng thái ban đầu nếu có lỗi xảy ra
	        e.printStackTrace();
	        return false; // Trả về false nếu có lỗi xảy ra
	    } finally {
	        conn.setAutoCommit(true); // Kết thúc giao dịch, trả về trạng thái mặc định
	    }
	}

	public boolean decreaseAmountIfStatusIsOne(String idTicket) throws ClassNotFoundException, SQLException {
	    if (conn == null)
	        conn = ConnectDatabase.getMySQLConnection();

	    conn.setAutoCommit(false); // Bắt đầu giao dịch

	    try {
	        String updateTicketQuery = "UPDATE ticket SET status = 1 WHERE idTicket = ?";
	        PreparedStatement updateTicketStmt = conn.prepareStatement(updateTicketQuery);
	        updateTicketStmt.setString(1, idTicket);
	        int updatedRows = updateTicketStmt.executeUpdate();

	        if (updatedRows > 0) {
	            String getBookIdQuery = "SELECT idBook FROM ticket WHERE idTicket = ?";
	            PreparedStatement getBookIdStmt = conn.prepareStatement(getBookIdQuery);
	            getBookIdStmt.setString(1, idTicket);
	            ResultSet bookIdResultSet = getBookIdStmt.executeQuery();

	            if (bookIdResultSet.next()) {
	                String idBook = bookIdResultSet.getString("idBook");

	                String updateBookQuery = "UPDATE [Book] SET amount = amount - 1 WHERE idBook = ?";
	                PreparedStatement updateBookStmt = conn.prepareStatement(updateBookQuery);
	                updateBookStmt.setString(1, idBook);
	                updateBookStmt.executeUpdate();

	                conn.commit(); 
	                return true; 
	            }
	        }
	        conn.rollback(); 
	        return false; 
	    } catch (SQLException e) {
	        conn.rollback(); 
	        e.printStackTrace();
	        return false; 
	    } finally {
	        conn.setAutoCommit(true);
	    }
	}
	public ArrayList<Ticket> getTicketbyReader(int idReader) throws SQLException, ClassNotFoundException {
	    ArrayList<Ticket> list = new ArrayList<>();
	    try {
	        if (conn == null)
	            conn = ConnectDatabase.getMySQLConnection();
	        
	        String sql = "SELECT * FROM ticket WHERE idReader = ?";
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, idReader);
	        ResultSet rs = pstm.executeQuery();
	        
	        while (rs.next()) {
		    	Integer idTicket = rs.getInt("idTicket");
		        Integer idBook = rs.getInt("idBook");
		        Integer idReader1 = rs.getInt("idReader");
		        String status = rs.getString("status");
		        String rentday = rs.getString("rentday");
		        String returnday = rs.getString("returnday");
		        String imperativeReturnDay = rs.getString("imperativeReturnDay");
		        Book book = new Book();
				try {
					book = bookBO.findBook(idBook);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Reader reader = new Reader();
				try {
					reader = readerBO.findReader(idReader1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        Ticket ticket = new Ticket();
		        ticket.setIdTicket(idTicket);
		        ticket.setBook(book);
		        ticket.setReader(reader);
		        ticket.setStatus(status);
		        ticket.setRentDay(rentday);
		        ticket.setReturnDay(returnday);
		        ticket.setImperativeReturnDay(imperativeReturnDay);

		        list.add(ticket);
	        }
	        }catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
	    
		}
	public ArrayList<Ticket> getTicketbyBook(int idBook) throws SQLException, ClassNotFoundException {
	    ArrayList<Ticket> list = new ArrayList<>();
	    try {
	        if (conn == null)
	            conn = ConnectDatabase.getMySQLConnection();
	        
	        String sql = "SELECT * FROM ticket WHERE idBook = ?";
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, idBook);
	        ResultSet rs = pstm.executeQuery();
	        
	        while (rs.next()) {
		    	Integer idTicket = rs.getInt("idTicket");
		        Integer idBook1 = rs.getInt("idBook");
		        Integer idReader1 = rs.getInt("idReader");
		        String status = rs.getString("status");
		        String rentday = rs.getString("rentday");
		        String returnday = rs.getString("returnday");
		        String imperativeReturnDay = rs.getString("imperativeReturnDay");
		        Book book = new Book();
				try {
					book = bookBO.findBook(idBook1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Reader reader = new Reader();
				try {
					reader = readerBO.findReader(idReader1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        Ticket ticket = new Ticket();
		        ticket.setIdTicket(idTicket);
		        ticket.setBook(book);
		        ticket.setReader(reader);
		        ticket.setStatus(status);
		        ticket.setRentDay(rentday);
		        ticket.setReturnDay(returnday);
		        ticket.setImperativeReturnDay(imperativeReturnDay);

		        list.add(ticket);
	        }
	        }catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
	    
		}
	public ArrayList<Ticket> getTicketbyRent_ReturnDay(int idTicket) throws SQLException, ClassNotFoundException {
	    ArrayList<Ticket> list = new ArrayList<>();
	    try {
	        if (conn == null)
	            conn = ConnectDatabase.getMySQLConnection();
	        
	        String sql = "select * from ticket where idTicket = ?  and (rentday - returnday) < 0;";
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, idTicket);
	        ResultSet rs = pstm.executeQuery();
	        
	        while (rs.next()) {
		    	Integer idTicket1 = rs.getInt("idTicket");
		        Integer idBook1 = rs.getInt("idBook");
		        Integer idReader1 = rs.getInt("idReader");
		        String status = rs.getString("status");
		        String rentday = rs.getString("rentday");
		        String returnday = rs.getString("returnday");
		        String imperativeReturnDay = rs.getString("imperativeReturnDay");
		        Book book = new Book();
				try {
					book = bookBO.findBook(idBook1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Reader reader = new Reader();
				try {
					reader = readerBO.findReader(idReader1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        Ticket ticket = new Ticket();
		        ticket.setIdTicket(idTicket1);
		        ticket.setBook(book);
		        ticket.setReader(reader);
		        ticket.setStatus(status);
		        ticket.setRentDay(rentday);
		        ticket.setReturnDay(returnday);
		        ticket.setImperativeReturnDay(imperativeReturnDay);

		        list.add(ticket);
	        }
	        }catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
	    
		}
	public ArrayList<Ticket> getTicketbyReturn_ImreturnDay(int idTicket) throws SQLException, ClassNotFoundException {
	    ArrayList<Ticket> list = new ArrayList<>();
	    try {
	        if (conn == null)
	            conn = ConnectDatabase.getMySQLConnection();
	        
	        String sql = "select * from ticket where idTicket = ?  and (returnday - imperativeday) < 0;";
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, idTicket);
	        ResultSet rs = pstm.executeQuery();
	        
	        while (rs.next()) {
		    	Integer idTicket1 = rs.getInt("idTicket");
		        Integer idBook1 = rs.getInt("idBook");
		        Integer idReader1 = rs.getInt("idReader");
		        String status = rs.getString("status");
		        String rentday = rs.getString("rentday");
		        String returnday = rs.getString("returnday");
		        String imperativeReturnDay = rs.getString("imperativeReturnDay");
		        Book book = new Book();
				try {
					book = bookBO.findBook(idBook1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Reader reader = new Reader();
				try {
					reader = readerBO.findReader(idReader1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        Ticket ticket = new Ticket();
		        ticket.setIdTicket(idTicket1);
		        ticket.setBook(book);
		        ticket.setReader(reader);
		        ticket.setStatus(status);
		        ticket.setRentDay(rentday);
		        ticket.setReturnDay(returnday);
		        ticket.setImperativeReturnDay(imperativeReturnDay);

		        list.add(ticket);
	        }
	        }catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
	    
		}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TicketDAO ticketDAO = new TicketDAO();
		ticketDAO.getTicketbyBook(4);
		System.out.println(ticketDAO);
	}
	

}



















