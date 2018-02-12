package com.assignment.youtube.service;

import java.util.List;

import com.google.api.services.youtube.model.SearchResult;

public interface YouTubeService {
	
	/**
	 * fetch you tube video detail.
	 * @param video keyword
	 * @return
	 */
	public List<SearchResult> fetchVideoData(String keyword, Long maxNo);

}
