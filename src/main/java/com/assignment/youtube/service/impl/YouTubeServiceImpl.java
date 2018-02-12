package com.assignment.youtube.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.assignment.youtube.enums.YouTubeType;
import com.assignment.youtube.service.YouTubeService;
import com.assignment.youtube.util.YouTubeUtil;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

@Service
public class YouTubeServiceImpl implements YouTubeService {
	
	@Value("${youtube.apikey}")
	private String apiKey;

	@Override
	public List<SearchResult> fetchVideoData(String keyword, Long maxNo) {
		List<SearchResult> searchResultList = null;
    	try {
            // This object is used to make YouTube Data API requests. The last
            // argument is required, but since we don't need anything
            // initialized when the HttpRequest is initialized, we override
            // the interface and provide a no-op function.
    		YouTube youtube = YouTubeUtil.buildYouTubeApi();

            // Prompt the user to enter a query term.
           // String queryTerm = getInputQuery();

            // Define the API request for retrieving search results.
            YouTube.Search.List search = youtube.search().list("id,snippet");

            // Set your developer key from the {{ Google Cloud Console }} for
            // non-authenticated requests. See:
            // {{ https://cloud.google.com/console }}
           // String apiKey = "AIzaSyBKak7V9d__R1KqmLJLbPk6Q2xWDrJK0FY";
            search.setKey(apiKey);
            search.setQ(keyword);

            // Restrict the search results to only include videos. See:
            // https://developers.google.com/youtube/v3/docs/search/list#type
            search.setType(YouTubeType.VIDEO.getName());

            // To increase efficiency, only retrieve the fields that the
            // application uses.
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
            search.setMaxResults(maxNo);

            // Call the API and print results.
            SearchListResponse searchResponse = search.execute();
            searchResultList = searchResponse.getItems();
           
        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    	
    	
    	return searchResultList;
	}

	

}
