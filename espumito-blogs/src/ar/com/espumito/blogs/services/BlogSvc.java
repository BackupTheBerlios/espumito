package ar.com.espumito.blogs.services;

import java.util.Set;

import ar.com.espumito.blogs.vo.BlogVO;
import ar.org.blah.j2ee.FinderException;

/**
 * @author MGSTRAUS
 * 
 */
public interface BlogSvc {
	public Set getBlogs();

	public BlogVO getBlog(String id) throws FinderException;
	
	public BlogVO addBlog(BlogVO blog);
}
