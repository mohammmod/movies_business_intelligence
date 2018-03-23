package at.refugeescode.theamazingpset1.pset1.controller;

import at.refugeescode.theamazingpset1.pset1.modal.Summary;
import at.refugeescode.theamazingpset1.pset1.parser.ParserActors;
import at.refugeescode.theamazingpset1.pset1.parser.ParserMovie;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MovieDatabaseSummarizerTest {

    private Summary summary = new Summary();
    List<pset1.modal.MovieSummarizer> movieInfo = ParserMovie.getMovieInfo();
    List<pset1.modal.Actor> actorsInfo = ParserActors.getActorsInfo();
    @Test
    void testRating() {
        List<String> movieRating = MovieInfoGuy.getRatings(movieInfo);
        int size = movieRating.size();
        assertEquals(size, 5);
        movieRating.stream()
                .forEach(onefilm -> Assert.assertThat(onefilm, containsString("10.0")));
        Assert.assertThat(movieRating.get(0), is("Reckless (10.0)"));
        Assert.assertThat(movieRating.get(4), is("Other Voices Other Rooms (10.0)"));
    }
    @Test
    void testGenres(){
        List<String> movieGenres = MovieInfoGuy.getMovieGenres(movieInfo);
        int size = movieGenres.size();
        assertEquals(size,2);
        Assert.assertThat(movieGenres.get(0).trim(),is("Drama (14495)"));
        Assert.assertThat(movieGenres.get(1).trim(), is("Comedy (8955)"));

    }
    @Test
    void testMostHiredActors(){
        List<String> mostHirdActors = ActorsInfoGuy.getMostHirdActors(actorsInfo);
        int size = mostHirdActors.size();
        assertEquals(size,5);
        Assert.assertThat(mostHirdActors.get(0).trim(),is("Bess Flowers (82)"));
        Assert.assertThat(mostHirdActors.get(4).trim(), is("Eric Roberts (52)"));

    }
    @Test
    void testActorsRatio(){
        String mostHirdActors = ActorsInfoGuy.getRatio(actorsInfo);
        Assert.assertThat(mostHirdActors.trim(),is("female : (64%) male : (35%)"));
        //Assert.assertThat(mostHirdActors.trim(), is("Eric Roberts (52)"));

    }


}

