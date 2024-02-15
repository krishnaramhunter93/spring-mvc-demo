package com.mvc.model;

import lombok.Data;

@Data // this will add getters and setters for the fields of the class
public class Movie {
	private int movieId;
	private String movieName;
	private int year;
	private String duration;
	private int rating;
}
