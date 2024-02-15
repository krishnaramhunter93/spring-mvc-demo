package com.mvc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mvc.controller.MovieController;
import com.mvc.model.Movie;

public class FindAllMovieMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("movie.xml");
		MovieController movieController = (MovieController) applicationContext.getBean("moviecontroller");
		
		List<Movie> movieList =  movieController.findAllMovie();
		System.out.println("All movies are : "+movieList);

	}

}
