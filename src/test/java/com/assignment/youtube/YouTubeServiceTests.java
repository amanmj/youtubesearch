package com.assignment.youtube;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.youtube.service.YouTubeService;
import com.google.api.services.youtube.model.SearchResult;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YouTubeServiceTests {

	@Autowired
	private YouTubeService youTubeService;
	
	@Test
	public void fetchVideoData(){
		List<SearchResult> inputList=youTubeService.fetchVideoData("java", 2L);
		Assert.assertNotNull(inputList);
		Assert.assertEquals(2, inputList.size());
		
	}	
	

}
