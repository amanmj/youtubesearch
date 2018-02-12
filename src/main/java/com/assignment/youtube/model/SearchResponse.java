package com.assignment.youtube.model;

import java.io.Serializable;
import java.util.List;

import com.google.api.services.youtube.model.SearchResult;

public class SearchResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8471823659606990245L;

	private String errorMessage;
	private String status;
	private List<SearchResult> searchResult;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<SearchResult> getSearchResult() {
		return searchResult;
	}
	public void setSearchResult(List<SearchResult> searchResult) {
		this.searchResult = searchResult;
	}
	
	
}
