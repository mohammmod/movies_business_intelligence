package at.refugeescode.theamazingpset1.pset1.parser;

import pset1.modal.MovieSummarizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class ParserMovie {
    public static List<MovieSummarizer> getMovieInfo() {
        String path = "C:/Users/Mohammad/Desktop/SpringShit/pset1/src/main/java/at/refugeescode/theamazingpset1/pset1/data/movies.csv";
        
        try {
            //read the lines of the string with given bath .
            List<String> lines = Files.readAllLines(Paths.get(path));
            //make the first river .            
            return lines.stream()
                    //skiping the first line
                    .skip(1)
                    //split the lines by ;
                    .map(line -> line.split(";"))
                    //make sure to though the broken lines
                    .filter(line -> line.length == 24)
                    .map(createMovie())
                    //collect every thing to List .
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static Function<String[], MovieSummarizer> createMovie() {
        return columns -> {
            MovieSummarizer moive = new MovieSummarizer();
            moive.setMoviename(columns[20]);
            moive.setRating(Double.parseDouble(columns[22]));
            moive.setMovieGenres(toFeedback(columns[3]));
            return moive;
        };
    }

    private static List<String> toFeedback(String column) {
        String objects = column.replaceAll("\\[", "").replaceAll("]", "");
        objects = objects.replaceAll("\\{", "").replaceAll("}", "");
        objects = objects.replaceAll("'", "");
        String[] words = objects.split(", ");
        return Stream.of(words)
                .skip(1)
                .map(word -> word.split(":"))
                .map(word -> word[1])
                .collect(Collectors.toList());
    }
}



