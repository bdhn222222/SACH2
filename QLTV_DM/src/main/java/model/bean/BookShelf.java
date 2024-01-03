package model.bean;

public class BookShelf {
	private int idBookShelf;
	private String nameBookShelf;
	public BookShelf() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookShelf(Integer idBookShelf, String nameBookShelf) {
		super();
		this.idBookShelf = idBookShelf;
		this.nameBookShelf = nameBookShelf;
	}
	public Integer getIdBookShelf() {
		return idBookShelf;
	}
	public void setIdBookShelf(Integer idBookShelf) {
		this.idBookShelf = idBookShelf;
	}
	public String getNameBookShelf() {
		return nameBookShelf;
	}
	public void setNameBookShelf(String nameBookShelf) {
		this.nameBookShelf = nameBookShelf;
	}
}
