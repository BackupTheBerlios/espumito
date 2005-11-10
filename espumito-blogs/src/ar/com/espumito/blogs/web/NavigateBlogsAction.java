package ar.com.espumito.blogs.web;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import ar.com.espumito.blogs.client.BlogBDlg;
import ar.com.espumito.blogs.services.BlogSvc;
import ar.com.espumito.core.model.DefaultPaginationModel;

public class NavigateBlogsAction extends DispatchAction {

	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try
		{
		BlogSvc service = new BlogBDlg();
		List blogs = new Vector(service.getBlogs());
		request.getSession().setAttribute(Symbols.ATTR_BLOG_COLLECTION,
				new DefaultPaginationModel(blogs, 5));
		return mapping.findForward("displayBlogs");

		}
		catch (Throwable e)
		{
			// TODO: SACAR ESTO
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	protected ActionForward next(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;
	}

	protected ActionForward previous(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;
	}

	protected ActionForward goTo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;
	}

}
