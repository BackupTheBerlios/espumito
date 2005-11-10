package ar.com.espumito.blogs.vo;

import java.util.HashSet;
import java.util.Set;

public class BlogVO {
	private String author;

	private Set entries = new HashSet();

	private String id;

	private BlogEntryVO lastEntry;

	private String name;
	
	private String title;

	public void addEntry(BlogEntryVO entry) {
		entries.add(entry);
		// FIXME: poner esto donde corresponde.
		lastEntry = entry;
	}

	public String getAuthor() {
		return author;
	}

	public Set getEntries() {
		return entries;
	}

	public int getEntryCount() {
		return entries.size();
	}

	public String getId() {
		return id;
	}

	public BlogEntryVO getLastEntry() {
		return lastEntry;
	}

	public String getName() {
		return name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
