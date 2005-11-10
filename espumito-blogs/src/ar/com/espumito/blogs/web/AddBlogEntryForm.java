package ar.com.espumito.blogs.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddBlogEntryForm extends ActionForm {
	private String text;

	private String title;

	public AddBlogEntryForm() {
		super();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (text == null || text.trim().equals("")) {
			errors.add("text", new ActionMessage("must.specify.entry.text"));
		}
		if (title == null || title.trim().equals("")) {
			errors.add("title", new ActionMessage("must.specify.entry.title"));
		}
		return errors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
