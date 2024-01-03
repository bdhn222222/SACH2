package model.bo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Reader;
import model.dao.ConnectDatabase;
import model.dao.ReaderDAO;

public class ReaderBO {
    private ReaderDAO readerDAO;

    public ReaderBO() {
        readerDAO = new ReaderDAO();
    }

    public Reader findReader(Integer idReader) throws SQLException, ClassNotFoundException {
        return readerDAO.findReader(idReader);
    }
    public Reader findReaderIdentity(Integer idReader) throws SQLException, ClassNotFoundException {
        return readerDAO.findReader(idReader);
    }
    public int insertReader(Reader reader) throws SQLException, ClassNotFoundException {
        return readerDAO.insertReader(reader);
    }

    public ArrayList<Reader> getAllReader() throws SQLException, ClassNotFoundException {
        return readerDAO.getAllReader();
    }
    public ArrayList<Reader> getListSearchReader(String nameReaderSearch) throws SQLException, ClassNotFoundException{
    	return readerDAO.getListSearchReader(nameReaderSearch);
	}
    public int updateReader(Reader reader) throws SQLException, ClassNotFoundException {
        return readerDAO.updateReader(reader);
    }

    public boolean deleteReader(int idReader) throws SQLException, ClassNotFoundException {
    	int result = readerDAO.deleteReader(idReader);
		if (result != 0)
			return true;
		return false;
	}

    

    public boolean deleteAllReader() throws ClassNotFoundException, SQLException {
		int result = readerDAO.deleteAllReader();
		if (result != 0)
			return true;
		return false;
	}
    

    public boolean canReaderBorrow(String idReader) throws ClassNotFoundException, SQLException {
        return readerDAO.canReaderBorrow(idReader);
    }
}
