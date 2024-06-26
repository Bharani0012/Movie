package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.repository.MovieRepository;

@Service
public class MovieJpaService implements MovieRepository {

	@Autowired
	private MovieJpaRepository moviejparepository;

	@Override
	public ArrayList<Movie> getMovies() {
		List<Movie> movieList = moviejparepository.findAll();
		ArrayList<Movie> movies = new ArrayList<>(movieList);
		return movies;
	}

	@Override
	public Movie getMovieById(int movieId) {

		try {
			Movie movie = moviejparepository.findById(movieId).get();
			return movie;

		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Movie addMovie(Movie movie) {
		moviejparepository.save(movie);
		return movie;
	}

	@Override
	public Movie updateMovie(Movie movie, int movieId) {
		try {
			Movie newMovie = moviejparepository.findById(movieId).get();
			if (movie.getMovieName() != null) {
				newMovie.setMovieName(movie.getMovieName());
			}
			if (movie.getLeadActor() != null) {
				newMovie.setLeadActor(movie.getLeadActor());
			}
			moviejparepository.save(newMovie);
			return newMovie;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteMovie(int movieId) {
		try {

			moviejparepository.deleteById(movieId);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
