package ar.com.espumito.blogs.model;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import ar.com.espumito.blogs.vo.BlogEntryVO;
import ar.com.espumito.blogs.vo.BlogVO;
import ar.com.espumito.blogs.vo.CommentVO;

public class DefaultBlogModel implements BlogModel {
	private static int id = 0;

	private BlogVO blog;

	public DefaultBlogModel() {
	}

	public DefaultBlogModel(BlogVO blog) {

		this.blog = blog;
	}

	public String getAuthor() {
		return blog.getAuthor();
	}

	public String getName() {
		return blog.getName();
	}

	public BlogEntryVO getLastEntry() {
		return blog.getLastEntry();
	}

	public BlogEntryVO addEntry(BlogEntryVO entry) {
		entry.setPublicationDate(new Date());
		entry.setId(new Long(++id));
		blog.addEntry(entry);
		return entry;
	}

	public void addComment(BlogEntryVO entry, CommentVO comment) {
		comment.setPublicationDate(new Date());
		entry.addComment(comment);
	}

	public BlogEntryVO getEntry(Long entryId) {
		BlogEntryVO entry = null;
		Iterator i = blog.getEntries().iterator();
		while (i.hasNext() && entry == null) {
			BlogEntryVO thisEntry = (BlogEntryVO) i.next();
			if (thisEntry.getId().equals(entryId))
				entry = thisEntry;
		}
		return entry;
	}

	public Set getAllEntries() {
		return blog.getEntries();
	}

	public String getTitle() {
		return blog.getTitle();
	}

}
