package ar.com.espumito.blogs.web;

import org.apache.struts.action.ActionForm;

public class NavigateSearchForm extends ActionForm {
	private String pageSize;

	private String searchCriteria;

	public NavigateSearchForm()
	{
		super();
	}
	
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

}
