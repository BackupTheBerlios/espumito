package ar.com.espumito.blogs.web;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ar.com.espumito.blogs.model.BlogModel;
import ar.com.espumito.blogs.vo.BlogEntryVO;
import ar.com.espumito.blogs.vo.CommentVO;

public class AddCommentAction extends BlogSpecificAction {

	public ActionForward step1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BlogSpecificRequest r = (BlogSpecificRequest) request;
		AddCommentForm f = (AddCommentForm) form;
		Long id = null;
		try {
			id = new Long(Long.parseLong(f.getEntryId()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		BlogEntryVO vo = r.getBlogModel().getEntry(id);
		f.setEntryId(id.toString());
		f.setTitle("RE: " + vo.getTitle());
		return mapping.findForward("showForm");
	}

	public ActionForward step2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BlogSpecificRequest r = (BlogSpecificRequest) request;
		AddCommentForm f = (AddCommentForm) form;
		Long id = new Long(Long.parseLong(f.getEntryId()));
		CommentVO comment = new CommentVO();
		comment.setAuthor(f.getAuthor());
		comment.setAuthorEmail(f.getEmail());
		comment.setText(f.getText());
		comment.setTitle(f.getTitle());
		BlogModel model = r.getBlogModel();
		model.addComment(model.getEntry(id), comment);
		Properties parameters = new Properties();
		parameters.put(Symbols.PARAM_BLOG_ENTRY_ID, id.toString());
		return RequestUtils.getRedirectAfterPostForward(mapping, "displayBlogEntry", parameters);
	}
}
