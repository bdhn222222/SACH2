package model.bean;

public class Ticket {
	private Integer idTicket;
	private Reader Reader;
	private Book Book;
	private String status;
	private String rentDay;
	private String returnDay;
	private String imperativeReturnDay;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(Integer idTicket, model.bean.Reader reader, model.bean.Book book, String status, String rentDay,
			String returnDay, String imperativeReturnDay) {
		super();
		this.idTicket = idTicket;
		Reader = reader;
		Book = book;
		this.status = status;
		this.rentDay = rentDay;
		this.returnDay = returnDay;
		this.imperativeReturnDay = imperativeReturnDay;
	}
	public Integer getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}
	public Reader getReader() {
		return Reader;
	}
	public void setReader(Reader reader) {
		Reader = reader;
	}
	public Book getBook() {
		return Book;
	}
	public void setBook(Book book) {
		Book = book;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRentDay() {
		return rentDay;
	}
	public void setRentDay(String rentDay) {
		this.rentDay = rentDay;
	}
	public String getReturnDay() {
		return returnDay;
	}
	public void setReturnDay(String returnDay) {
		this.returnDay = returnDay;
	}
	public String getImperativeReturnDay() {
		return imperativeReturnDay;
	}
	public void setImperativeReturnDay(String imperativeReturnDay) {
		this.imperativeReturnDay = imperativeReturnDay;
	}
	
	
	
}
