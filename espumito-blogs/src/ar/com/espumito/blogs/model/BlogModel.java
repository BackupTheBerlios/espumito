package ar.com.espumito.blogs.model;

import java.util.Set;

import ar.com.espumito.blogs.vo.BlogEntryVO;
import ar.com.espumito.blogs.vo.CommentVO;

public interface BlogModel {
	public String getAuthor();

	public String getName();
	
	public String getTitle();

	public BlogEntryVO getLastEntry();

	public BlogEntryVO getEntry(Long entryId);

	public BlogEntryVO addEntry(BlogEntryVO entry);

	public void addComment(BlogEntryVO entry, CommentVO comment);

	public Set getAllEntries();
}
