package com.mvc.controller;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mvc.model.Movie;

import lombok.Data;

@Data
public class MovieController {
	
	/*
	 * MovieController - we perform all CRUD operations(like save get update ...)  
	 * Jdbctemplate - this has methods which perform all CRUD operations(to execute all queries)
	 * datasource - represents database connections properties
	 */
	
	private JdbcTemplate jdbcTemplate;
	
	public void saveMovie(Movie movie) {
		//insert into movie_feb.movie(movie_id,movie_name,years,duration,rating) values(1,"shwjuwl",1998,"120mins",4);
		String sqlQuery = "insert into movie(movie_id,movie_name,years,duration,rating) values(?,?,?,?,?)";// ? acts as a placeholder to the values
		// pass the values from movie to the object array
		Object[] inputData = {movie.getMovieId(), movie.getMovieName(), movie.getYear(),movie.getDuration(),movie.getRating()};
		// execute the query
		jdbcTemplate.update(sqlQuery,inputData);
		System.out.println("Movie saved sucessfully!");
	}
	
	public Movie findMovieById(int inputMovieId) {
		//select movie_id,movie_name,years,duration,rating from movie_feb.movie where movie_id=3;
		String sqlQuery = "select movie_id,movie_name,years,duration,rating from movie where movie_id=?";
		Object[] inputId = {inputMovieId};
		Movie movieFromDatabase = jdbcTemplate.queryForObject(sqlQuery, inputId, new BeanPropertyRowMapper<Movie>(Movie.class));
		if(movieFromDatabase!=null) {
			return movieFromDatabase;
		}
		return null;
	}
	
	public List<Movie> findAllMovie() {
		// select movie_id,movie_name,years,duration,rating from movie_feb.movie;
		String sqlQuery = "select movie_id,movie_name,years,duration,rating from movie";
		List<Movie> movieListFromDatabase = jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<Movie>(Movie.class));
		if(movieListFromDatabase.isEmpty()) {
			return null;
		}
		return movieListFromDatabase;
	}
	
	
}
