package com.beans;

public class Book {
	
	// POJO
	
	private String id;
	private String name;
	private String authors;
	private String status;
	
	public Book() {
		super();
		// alt+shif+s    c
	}
	
	// alt+shif+s    r
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	// alt+shif+s    s
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", authors=" + authors + ", status=" + status + "]";
	}
	
	
	

}
