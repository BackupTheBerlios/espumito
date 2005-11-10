package ar.com.espumito.blogs.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import ar.com.espumito.util.StringUtil;

public class BlogIdForm extends ActionForm {
	private String blogId;
	
	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public BlogIdForm() {
		super();
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		if (StringUtil.isBlank(blogId))
		{
			ActionErrors errors = new ActionErrors();
			errors.add("blogId", new ActionMessage(Symbols.ERR_MISSING_BLOG_ID));
			return errors;
		}
		else
			return null;
	}
	
	

}
