/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.movie;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.movie.Movie;
import com.example.movie.MovieService;

@RestController
public class MovieController {

    MovieService movieService = new MovieService();

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId) {
        movieService.deleteMovie(movieId);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable("movieId") int movieId,@RequestBody Movie movie) {
        return movieService.updateMovie(movieId, movie);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieByMovieId(@PathVariable("movieId") int movieId) {
        return movieService.getMovieByMovieId(movieId);
    }
}