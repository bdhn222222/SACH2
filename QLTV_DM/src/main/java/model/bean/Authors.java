package model.bean;

public class Authors {
	private int idAuthors;
	private String nameAuthors;
	public Authors() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Authors(int idAuthors, String nameAuthors) {
		super();
		this.idAuthors = idAuthors;
		this.nameAuthors = nameAuthors;
	}
	public int getIdAuthors() {
		return idAuthors;
	}
	public void setIdAuthors(int idAuthors) {
		this.idAuthors = idAuthors;
	}
	public String getNameAuthors() {
		return nameAuthors;
	}
	public void setNameAuthors(String nameAuthors) {
		this.nameAuthors = nameAuthors;
	}
	
}
