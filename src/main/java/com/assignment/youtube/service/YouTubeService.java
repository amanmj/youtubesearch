package com.assignment.youtube.service;

import com.assignment.youtube.model.SearchResponse;

/**
 * Youtube service to fetch video data.
 */
public interface YouTubeService {
	
	/**
	 * fetch you tube video detail.
	 * @param video keyword
	 * @return
	 */
	public SearchResponse fetchVideoData(String keyword, Long maxNo);

}
