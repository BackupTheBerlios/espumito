package ar.com.espumito.blogs.vo;

import java.util.Date;

public class CommentVO {
	public String author;

	public String authorEmail;

	public Long id;

	public Date publicationDate;
	
	public String text;
	
	public String title;

	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentVO(String author, String email, Long id, Date date) {
		super();
		// TODO Auto-generated constructor stub
		this.author = author;
		authorEmail = email;
		this.id = id;
		publicationDate = date;
	}

	public String getAuthor() {
		return author;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public Long getId() {
		return id;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public String getText() {
		return text;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
