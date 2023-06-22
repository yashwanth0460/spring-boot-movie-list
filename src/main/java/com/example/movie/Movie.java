// Write your code here
package com.example.movie;

public class Movie {
    private int movieId;
    private String movieName;
    private String leadActor;

    public Movie(int movieId,String movieName,String leadActor) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.leadActor = leadActor;
    }

    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getLeadActor() {
        return leadActor;
    }
    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }
    
}