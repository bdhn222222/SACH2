package model.bean;

public class Reader {
	private Integer idReader;
	private String nameReader;
	private String identity;
	private String telReader;
	public Integer getIdReader() {
		return idReader;
	}
	public void setIdReader(Integer idReader) {
		this.idReader = idReader;
	}
	public String getNameReader() {
		return nameReader;
	}
	public void setNameReader(String nameReader) {
		this.nameReader = nameReader;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getTelReader() {
		return telReader;
	}
	public void setTelReader(String telReader) {
		this.telReader = telReader;
	}
	public Reader(Integer idReader, String nameReader, String identity, String telReader) {
		super();
		this.idReader = idReader;
		this.nameReader = nameReader;
		this.identity = identity;
		this.telReader = telReader;
	}
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}
}
