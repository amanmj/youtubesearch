package com.assignment.youtube;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.youtube.model.SearchResponse;
import com.assignment.youtube.service.YouTubeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YouTubeServiceTests {

	@Autowired
	private YouTubeService youTubeService;
	
	@Test
	public void fetchVideoData(){
		SearchResponse inputList=youTubeService.fetchVideoData("java", 2L);
		Assert.assertNotNull(inputList.getSearchResult());
		Assert.assertEquals(2, inputList.getSearchResult().size());
		
	}	
	

}
