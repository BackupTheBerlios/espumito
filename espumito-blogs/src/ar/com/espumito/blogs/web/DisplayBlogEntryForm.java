package ar.com.espumito.blogs.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DisplayBlogEntryForm extends ActionForm {
	public String entryId;

	public DisplayBlogEntryForm() {
		super();
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String id) {
		this.entryId = id;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		if (entryId == null || entryId.trim().equals("")) {
			ActionErrors errors = new ActionErrors();
			errors.add("entryId", new ActionMessage("missing.entry.id"));
			return errors;
		}
		return null;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		entryId = "";
	}

}
