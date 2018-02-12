package com.assignment.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.youtube.model.SearchResponse;
import com.assignment.youtube.service.YouTubeService;

@RestController
@RequestMapping("/search/")
public class YouTubeSearchController {

	@Autowired
	private YouTubeService youTubeService;

	@GetMapping(value = "/youTubeData")
	@ResponseBody
	public SearchResponse youTubeVideo(@RequestParam String keyword, @RequestParam Long maxNo) {
		if (StringUtils.isEmpty(keyword)) {
			keyword = "java";
		}
		SearchResponse response=new SearchResponse();
		if (maxNo <= 0) {
			System.out.println("ERROR: please provide positive numeric value for RESULT-COUNT parameter!");
			response.setErrorMessage("ERROR: please provide positive numeric value for RESULT-COUNT parameter!");
			response.setStatus("failure");
			return response;
		}
		return youTubeService.fetchVideoData(keyword, maxNo);
	}
}
