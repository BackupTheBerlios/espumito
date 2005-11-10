package ar.com.espumito.blogs.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import ar.com.espumito.util.StringUtil;

public class CreateBlogForm extends ActionForm {
	private String name;
	private String title;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (StringUtil.isBlank(name))
			errors.add("name", new ActionMessage(Symbols.ERR_BLOG_NAME_MISSING));
		if (StringUtil.isBlank(title))
			errors.add("title", new ActionMessage(Symbols.ERR_BLOG_TITLE_MISSING));
		return errors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
