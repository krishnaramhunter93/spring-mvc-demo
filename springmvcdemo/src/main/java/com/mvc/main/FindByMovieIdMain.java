package com.mvc.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mvc.controller.MovieController;
import com.mvc.model.Movie;

public class FindByMovieIdMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("movie.xml");
		MovieController movieController = (MovieController) applicationContext.getBean("moviecontroller");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the movie id to search : ");
		int id = sc.nextInt();
		
		Movie movie =movieController.findMovieById(id);
		System.out.println(movie);

	}

}
