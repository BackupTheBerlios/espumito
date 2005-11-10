package ar.com.espumito.blogs.client;

import java.util.Set;

import ar.com.espumito.blogs.services.BlogSvc;
import ar.com.espumito.blogs.services.MockBlogSvcImpl;
import ar.com.espumito.blogs.vo.BlogVO;
import ar.org.blah.j2ee.FinderException;

public class BlogBDlg implements BlogSvc {
	private static MockBlogSvcImpl mock = new MockBlogSvcImpl();

	private BlogSvc service = null;

	public BlogBDlg() {
		service = getService();
	}

	private BlogSvc getService() {
		return mock;
	}

	public BlogVO getBlog(String id) throws FinderException {
		return service.getBlog(id);
	}

	public Set getBlogs() {
		return service.getBlogs();
	}

	public BlogVO addBlog(BlogVO blog) {
		return service.addBlog(blog);
	}
	
}
