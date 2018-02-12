package com.assignment.youtube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.youtube.service.YouTubeService;
import com.assignment.youtube.util.YouTubeUtil;

/**
 * boot starts spring-boot program.
 * @author Krati Mittal
 *
 * 12-Feb-2018
 */
@SpringBootApplication
public class YouTubeApplication implements CommandLineRunner{

	@Autowired
	private YouTubeService youTubeService;
	
	public static void main(String[] args) {
		SpringApplication.run(YouTubeApplication.class, args);
	}

	/**
	 * business program. This program prints youtube video data.
	 */
	@Override
	public void run(String... args) throws Exception {
		String keyword="java";
		long maxNo=50;
		if(args!=null && args.length>1){
			keyword=args[0];
			try {
				maxNo=Long.parseLong(args[1]);
				if(maxNo<=0){
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("ERROR: please provide positive numeric value for RESULT-COUNT parameter!");
			}
			
		}
		
		YouTubeUtil.prettyPrint(youTubeService.fetchVideoData(keyword, maxNo));

		
	}
}
