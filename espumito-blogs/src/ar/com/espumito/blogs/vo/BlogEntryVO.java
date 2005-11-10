package ar.com.espumito.blogs.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BlogEntryVO {
	private Set comments = new HashSet();
	private Long id;
	private Date publicationDate;
	private String text;
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BlogEntryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlogEntryVO(Long id, Date date) {
		super();
		// TODO Auto-generated constructor stub
		this.id = id;
		publicationDate = date;
	}
	public BlogEntryVO(Set comments, Long id, Date date) {
		super();
		// TODO Auto-generated constructor stub
		this.comments = comments;
		this.id = id;
		publicationDate = date;
	}
	public void addComment(CommentVO comment)
	{
		comments.add(comment);
	}
	public Set getComments() {
		return comments;
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
	public void setId(Long id) {
		this.id = id;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public void setText(String text) {
		this.text = text;
	}
}
