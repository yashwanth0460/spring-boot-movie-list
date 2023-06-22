/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.movie;

import com.example.movie.Movie;
import com.example.movie.MovieRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;

// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    // Write your code here
    int uniqueMovieId = 6;

    @Override
    public Movie addMovie(Movie movie) {
        movie.setMovieId(uniqueMovieId);
        movieList.put(uniqueMovieId,movie);
        uniqueMovieId += 1;
        return movie;
    }

    @Override
    public ArrayList<Movie> getMovies() {
        Collection<Movie> movieCollection = movieList.values();
        ArrayList<Movie> movies = new ArrayList<>(movieCollection);
        return movies;
    }

    @Override
    public Movie getMovieByMovieId(int movieId) {
        Movie movie = movieList.get(movieId);

        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return movie;
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        Movie existingMovie = movieList.get(movieId);
        if (existingMovie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (movie.getMovieName() != null) {
            existingMovie.setMovieName(movie.getMovieName());
        }

        if (movie.getLeadActor() != null) {
            existingMovie.setLeadActor(movie.getLeadActor());
        }

        return existingMovie;
    }

    @Override
    public void deleteMovie(int movieId) {
        Movie movie = movieList.get(movieId);

        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            movieList.remove(movieId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
