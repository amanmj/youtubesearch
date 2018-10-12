package com.assignment.youtube.service.impl;

import java.io.IOException;

import com.assignment.youtube.util.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.assignment.youtube.enums.YouTubeType;
import com.assignment.youtube.model.SearchResponse;
import com.assignment.youtube.service.YouTubeService;
import com.assignment.youtube.util.YouTubeUtil;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;

@Service
public class YouTubeServiceImpl implements YouTubeService {
	
	@Value("${youtube.apikey}")
	private String apiKey;

	@Override
	public SearchResponse fetchVideoData(String keyword, Long maxNo) {
		SearchResponse response=new SearchResponse();
    	try {
            // This object is used to make YouTube Data API requests. The last
            // argument is required, but since we don't need anything
            // initialized when the HttpRequest is initialized, we override
            // the interface and provide a no-op function.
    		YouTube youtube = YouTubeUtil.buildYouTubeApi();

            // Prompt the user to enter a query term.

            // Define the API request for retrieving search results.
            YouTube.Search.List search = youtube.search().list("id,snippet");

            // Set your developer key from the {{ Google Cloud Console }} for
            // non-authenticated requests. See:
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
            response.setSearchResult(searchResponse.getItems());
            response.setStatus(Constants.SUCCESS);
            return response;
           
        } catch (GoogleJsonResponseException e) {
        	response.setErrorMessage(e.getDetails().getMessage());
        	response.setStatus(Constants.FAILURE);
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
            return response;
            
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    	response.setErrorMessage("unable to fetch data!!");
    	response.setStatus(Constants.FAILURE);
    	
    	return response;
	}
}
