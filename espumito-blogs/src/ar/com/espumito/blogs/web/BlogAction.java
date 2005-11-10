package ar.com.espumito.blogs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import ar.com.espumito.blogs.client.BlogBDlg;
import ar.com.espumito.blogs.services.BlogSvc;
import ar.com.espumito.blogs.vo.BlogVO;

public class BlogAction extends MappingDispatchAction {

	public BlogAction() {
		super();
	}

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BlogIdForm f = (BlogIdForm) form;
		BlogSvc blogSvc = new BlogBDlg();
		BlogVO blog = blogSvc.getBlog(f.getBlogId());
		request.setAttribute(Symbols.ATTR_BLOG, blog);
		return mapping.findForward("viewBlog");
	}


}
