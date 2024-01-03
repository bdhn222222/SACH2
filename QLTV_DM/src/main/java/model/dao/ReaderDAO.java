package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Reader;
import model.bean.Reader;
import model.bo.BookBO;

public class ReaderDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	Statement stm = null;
	
	public Reader findReader(Integer idReader) throws SQLException, ClassNotFoundException{
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from reader where idReader = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idReader);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			Integer idReader1 = rs.getInt("idReader");
			String nameReader = rs.getString("nameReader");
			String identity = rs.getString("identity");
			String telReader = rs.getString("telReader");
			Reader reader = new Reader(idReader1, nameReader, identity, telReader);
			return reader;
		}
		return null;
	}
	public Reader findReaderidentity(Integer idReader) throws SQLException, ClassNotFoundException{
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select identity from reader where idReader = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idReader);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			Integer idReader1 = rs.getInt("idReader");
			String nameReader = rs.getString("nameReader");
			String identity = rs.getString("identity");
			String telReader = rs.getString("telReader");
			Reader reader = new Reader(idReader1, nameReader, identity, telReader);
			return reader;
		}
		return null;
	}
	public int insertReader(Reader reader) throws SQLException, ClassNotFoundException{
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		try {
			stm = conn.createStatement();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String sql = "insert into reader (nameReader, identity, telReader) values (?,?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		int result =0;
		pstm.setString(1, reader.getNameReader());
		pstm.setString(2, reader.getIdentity());
		pstm.setString(3, reader.getTelReader());
		result = pstm.executeUpdate();
		return result;
	}
	public ArrayList<Reader> getAllReader() throws SQLException, ClassNotFoundException{
		if(conn == null)
		conn = ConnectDatabase.getMySQLConnection();
		ArrayList<Reader> list = new ArrayList<Reader>();
		String sql = "select * from reader";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int idReader = rs.getInt("idReader");
			String nameReader = rs.getString("nameReader");
			String identity = rs.getString("identity");
			String telReader = rs.getString("telReader");
			Reader reader = new Reader();
			reader.setIdReader(idReader);
			reader.setNameReader(nameReader);
			reader.setIdentity(identity);
			reader.setTelReader(telReader);
			list.add(reader);
		}
		return list;
	}
	public int updateReader(Reader reader) throws SQLException, ClassNotFoundException{
		int rs = 0;
		if(conn == null) {
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Update reader set nameReader =?, identity =?, telReader =? where idReader=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, reader.getNameReader());
		pstm.setString(2, reader.getIdentity());
		pstm.setString(3, reader.getTelReader());
		pstm.setInt(4,reader.getIdReader());
		rs = pstm.executeUpdate();
		}
		return rs;
	}
	public int deleteReader(int idReader) throws SQLException, ClassNotFoundException{
		int result =0;
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "delete From reader where idReader= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idReader);
		result = pstm.executeUpdate();
		return result;
	}
	public int deleteAllReader() throws SQLException, ClassNotFoundException{
		int result = 0;
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "delete From reader";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		result = pstm.executeUpdate();
		return result;
	}
	public ArrayList<Reader> getListSearchReader(String nameReaderSearch) throws SQLException, ClassNotFoundException{
		if (conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		ArrayList<Reader> list = new ArrayList<Reader>();
		String sql = "Select * from reader where name like ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, "%"+nameReaderSearch+"%");
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int idReader = rs.getInt("idReader");
			String nameReader = rs.getString("nameReader");
			String identity = rs.getString("identity");
			String telReader = rs.getString("telReader");
			Reader reader = new Reader();
			reader.setIdReader(idReader);
			reader.setNameReader(nameReader);
			reader.setIdentity(identity);
			reader.setTelReader(telReader);
			list.add(reader);
		}
		return list;
	}
	public int countTicketsForReader(String idReader) throws ClassNotFoundException, SQLException {
	    int count = 0;

	    if (conn == null)
	        conn = ConnectDatabase.getMySQLConnection();

	    String count1 = "SELECT COUNT(*) AS totalTickets FROM ticket WHERE idReader = ?";
	    try (PreparedStatement countStmt = conn.prepareStatement(count1)) {
	        countStmt.setString(1, idReader);
	        ResultSet resultSet = countStmt.executeQuery();
	        if (resultSet.next()) {
	            count = resultSet.getInt("totalTickets");
	        }
	    }

	    return count;
	}
	public boolean canReaderBorrow(String idReader) throws ClassNotFoundException, SQLException {
	    int maxBorrowLimit = 5; // Giới hạn mượn sách

	    int currentBorrowCount = countTicketsForReader(idReader);

	    return currentBorrowCount < maxBorrowLimit;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ReaderDAO readerDAO = new ReaderDAO();
		readerDAO.findReader(1);
		System.out.println(readerDAO);
	}
	
}




















