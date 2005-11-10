package ar.com.espumito.blogs.services;

import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import ar.com.espumito.blogs.vo.BlogEntryVO;
import ar.com.espumito.blogs.vo.BlogVO;
import ar.org.blah.j2ee.FinderException;

public class MockBlogSvcImpl implements BlogSvc {
	private Map blogs = new Hashtable();

	public MockBlogSvcImpl() {
		long entry = 0;
		BlogVO blog = new BlogVO();
		blog.setId("guybrush");
		blog.setAuthor("guybrush");
		blog.setName("Paseando por Meleé Island");
		BlogEntryVO entry1 = new BlogEntryVO();
		entry1.setId(new Long(++entry));
		entry1.setPublicationDate(new Date());
		entry1.setText("Hola a todos!");
		entry1.setTitle("HOLA");
		blog.addEntry(entry1);
		BlogEntryVO entry2 = new BlogEntryVO();
		entry2.setId(new Long(++entry));
		entry2.setPublicationDate(new Date());
		entry2.setText("Otra entrada de bloh!");
		entry2.setTitle("Otro");
		blog.addEntry(entry2);
		addBlog(blog);

		blog = new BlogVO();
		blog.setId("swordmaster");
		blog.setAuthor("swordmaster");
		blog.setName("Yo soy cola, tú pegamento.");
		addBlog(blog);

		blog = new BlogVO();
		blog.setId("franchella");
		blog.setAuthor("franchella");
		blog.setName("¡¡Lechonaaaaas!!");
		addBlog(blog);
	}

	public Set getBlogs() {
		return new HashSet(blogs.values());
	}

	public BlogVO getBlog(String id) throws FinderException {
		BlogVO blog = (BlogVO) blogs.get(id);
		if (blog != null)
			return blog;
		else
			throw new FinderException("No se encontro el blog " + id);
	}

	public BlogVO addBlog(BlogVO blog) {
		blogs.put(blog.getId(), blog);
		return blog;
	}

}
