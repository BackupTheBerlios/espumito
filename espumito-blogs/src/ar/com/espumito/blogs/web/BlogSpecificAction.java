package ar.com.espumito.blogs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author MGSTRAUS
 */
public class BlogSpecificAction extends DispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (requiresBlog()
				&& ((BlogSpecificRequest) request).isBlogModelAvailable())
			return super.execute(mapping, form, request, response);
		else
		{
			System.out.println("No se encontro el blog en la session");
			return mapping.findForward(Symbols.FWD_NO_BLOG_SELECTED);
		}
	}

	protected boolean requiresBlog() {
		return true;
	}

}
