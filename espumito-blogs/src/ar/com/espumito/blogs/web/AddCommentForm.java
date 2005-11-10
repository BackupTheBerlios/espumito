package ar.com.espumito.blogs.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import ar.com.espumito.util.StringUtil;

public class AddCommentForm extends ActionForm {
	private String entryId;

	private String title;

	private String author;

	private String email;

	private String text;

	public AddCommentForm() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String name) {
		this.author = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		setTitle("");
		setAuthor("");
		setEmail("");
		setText("");
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (StringUtil.isBlank(text))
			errors.add("text", new ActionMessage(Symbols.ERR_COMMENT_TEXT_MISSING));
		return errors;
	}
	
	
}
