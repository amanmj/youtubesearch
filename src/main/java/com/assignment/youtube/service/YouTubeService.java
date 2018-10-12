package com.assignment.youtube.service;

import com.assignment.youtube.model.SearchResponse;

public interface YouTubeService {
	
	/**
	 * fetch you tube video detail.
	 * @param video keyword
	 * @return
	 */
	SearchResponse fetchVideoData(String keyword, Long maxNumber);

}
