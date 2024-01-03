package model.bean;

public class Book {
	private Integer idBook;
	private String nameBook;
	private String image;
	private Integer amount;
	private Category Category;
	private Authors Authors;
	private BookShelf BookShelf;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Integer idBook, String nameBook,String image, Integer amount, model.bean.Category category,
			model.bean.Authors authors, model.bean.BookShelf bookShelf ) {
		super();
		this.idBook = idBook;
		this.nameBook = nameBook;
		this.amount = amount;
		this.image = image;
		Category = category;
		Authors = authors;
		BookShelf = bookShelf;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getIdBook() {
		return idBook;
	}
	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Category getCategory() {
		return Category;
	}
	public void setCategory(Category category) {
		Category = category;
	}
	public Authors getAuthors() {
		return Authors;
	}
	public void setAuthors(Authors authors) {
		Authors = authors;
	}
	public BookShelf getBookShelf() {
		return BookShelf;
	}
	public void setBookShelf(BookShelf bookShelf) {
		BookShelf = bookShelf;
	}
	
}
