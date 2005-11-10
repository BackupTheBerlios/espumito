package ar.com.espumito.blogs.web;

import org.apache.struts.action.ActionForm;

public class DisplayBlogForm extends ActionForm {
	private String blogId;
	
	public DisplayBlogForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

}
