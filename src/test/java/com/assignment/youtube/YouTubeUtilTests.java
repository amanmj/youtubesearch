package com.assignment.youtube;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.youtube.util.YouTubeUtil;
import com.google.api.services.youtube.YouTube;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YouTubeUtilTests {

	@Test
	public void buildYouTubeApi() {
		YouTube youTube = YouTubeUtil.buildYouTubeApi();
		Assert.assertNotNull(youTube);
	}

}
