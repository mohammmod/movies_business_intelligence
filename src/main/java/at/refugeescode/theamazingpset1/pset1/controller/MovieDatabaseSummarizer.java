package at.refugeescode.theamazingpset1.pset1.controller;

import at.refugeescode.theamazingpset1.pset1.controller.ActorsInfoGuy;
import at.refugeescode.theamazingpset1.pset1.controller.MovieInfoGuy;
import org.springframework.stereotype.Component;
import pset1.modal.Actor;
import pset1.modal.MovieSummarizer;
import at.refugeescode.theamazingpset1.pset1.parser.*;
//import at.refugeescode.theamazingpset1.pset1.parser.*;
import at.refugeescode.theamazingpset1.pset1.modal.Summary;

import java.util.List;
import java.util.Optional;

@Component
public class MovieDatabaseSummarizer {
    public Optional <Summary> summarize(){
        List<MovieSummarizer> reviews = ParserMovie.getMovieInfo();
        List<Actor> actorsInfo = ParserActors.getActorsInfo();

        List<String> topRatedmovie = MovieInfoGuy.getRatings(reviews);
        List<String> topMovieGeners = MovieInfoGuy.getMovieGenres(reviews);
        List<String> mostHirdActors = ActorsInfoGuy.getMostHirdActors(actorsInfo);
        String ratio = ActorsInfoGuy.getRatio(actorsInfo);

        Summary summary = new Summary();

        summary.setTopRatedMovie(topRatedmovie);
        summary.setActorName(mostHirdActors);
        summary.setMovieGenres(topMovieGeners);
        summary.setRatio(ratio);
        return Optional.of(summary);

    }
}



