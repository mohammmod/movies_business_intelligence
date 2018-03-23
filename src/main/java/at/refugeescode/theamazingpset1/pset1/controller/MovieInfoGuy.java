package at.refugeescode.theamazingpset1.pset1.controller;

import pset1.modal.MovieSummarizer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieInfoGuy {
    public static List<String> getRatings(List<MovieSummarizer> reviews) {
        return reviews.stream()
                .sorted((e1, e2) -> e2.getRating().compareTo(e1.getRating()))
                .limit(5)
                .map(e -> e.getMoviename() + " (" + e.getRating() + ")")
                .collect(Collectors.toList());
    }

    public static List<String> getMovieGenres(List<MovieSummarizer> reviews) {
        Map<String, Long> mostFemousMovieGenres = reviews.stream()
                .map(review -> review.getMovieGenres())
                .flatMap(feedback -> feedback.stream())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        return mostFemousMovieGenres.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(2)
                .map(e -> e.getKey() + " (" + e.getValue()+")")
                .collect(Collectors.toList());
    }
}
