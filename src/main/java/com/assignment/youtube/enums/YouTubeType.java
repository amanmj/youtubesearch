package com.assignment.youtube.enums;

/**
 * Loyalty category of users.
 * @author Arjun Agarwal
 *
 * 03-Dec-2017
 */
public enum YouTubeType {
	VIDEO("video");

	private String name;

	public YouTubeType(String name) {
		this.name=name	
	}

	public String getName() {
		return name;
	}

	public void setName(String type) {
		this.name = type;
	}
	
}
