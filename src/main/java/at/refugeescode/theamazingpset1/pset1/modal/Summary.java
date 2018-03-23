package at.refugeescode.theamazingpset1.pset1.modal;

import java.util.List;

public class Summary {
    private List<String> topRatedMovie;
    private List<String> movieGenres;
    private List<String> actorName;
    private String ratio;


    public List<String> getTopRatedMovie() {
        return topRatedMovie;
    }

    public void setTopRatedMovie(List<String> topRatedMovie) {
        this.topRatedMovie = topRatedMovie;
    }

    public List<String> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(List<String> movieGenres) {
        this.movieGenres = movieGenres;
    }


    public List<String> getActorName() {
        return actorName;
    }

    public void setActorName(List<String> actorName) {
        this.actorName = actorName;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }
}
