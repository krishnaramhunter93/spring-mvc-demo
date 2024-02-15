package com.mvc.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mvc.controller.MovieController;
import com.mvc.model.Movie;

public class SaveMovieMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("movie.xml");
		MovieController movieController = (MovieController) applicationContext.getBean("moviecontroller");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the movie ID : ");
		int movieId = sc.nextInt();
		System.out.println("Enter the movieName : ");
		String movieName = sc.next();
		System.out.println("Enter the year : ");
		int year = sc.nextInt();
		System.out.println("Enter the duration : ");
		String duration = sc.next();
		System.out.println("Enter the rating : ");
		int rating = sc.nextInt();
		
		Movie inputMovie = new Movie();
		inputMovie.setMovieId(movieId);
		inputMovie.setMovieName(movieName);
		inputMovie.setYear(year);
		inputMovie.setDuration(duration);
		inputMovie.setRating(rating);
		
		movieController.saveMovie(inputMovie);
		
		
	}

}
