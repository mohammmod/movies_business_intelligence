package pset1.modal;

import java.util.List;

public class MovieSummarizer {
    private Double getRating;
    private String moviename;
    private List<String> movieGenres;


    public Double getRating() {
        return getRating;
    }

    public void setRating(Double getRating) {
        this.getRating = getRating;
    }


    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public List<String> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(List<String> movieGenres) {
        this.movieGenres = movieGenres;
    }
}