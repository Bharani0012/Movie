package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;

@RestController
public class MovieController {

    @Autowired
    private MovieJpaService moviejpaservice;

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
        return moviejpaservice.getMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId) {
        return moviejpaservice.getMovieById(movieId);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return moviejpaservice.addMovie(movie);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable("movieId") int movieId){
        return moviejpaservice.updateMovie(movie, movieId);
    }

    @DeleteMapping("movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId){
        moviejpaservice.deleteMovie(movieId);
    }

}
