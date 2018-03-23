package at.refugeescode.theamazingpset1.pset1.parser;

import pset1.modal.Actor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParserActors {
    public static List<Actor> getActorsInfo() {
        String pathActors = "C:/Users/Mohammad/Desktop/SpringShit/pset1/src/main/java/at/refugeescode/theamazingpset1/pset1/data/actors.csv";

       // String pathActors = "at/refugeescode/theamazingpset1/pset1/data

        try {
        List<String> lines = Files.readAllLines(Paths.get(pathActors));
        List<Actor> actors = lines.stream()
                .skip(1)
                .map(line -> line.split(";"))
                .map(line -> line[0])
                .map(actor -> actor.replaceAll("'name':", ""))
                .map(actor -> actor.replaceAll("'gender':", ""))
                //adding one line here
                .map(actor -> actor.replaceAll("'",""))
                .map(line -> line.split("},"))
                .flatMap(strings -> Arrays.stream(strings))
                .map(line -> line.split(","))
                .filter(clomen -> clomen.length >= 5)
                .map(s -> creatActor(s))
                .collect(Collectors.toList());
        return actors;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}

    private static Actor creatActor(String[] p) {
        Actor actor = new Actor();
        actor.setName(p[5]);
        actor.setGender(getGender(p[3]));
        return actor;

    }

    private  static String getGender(String s) {
        if (s.contains("1") || s.contains("0")) {
            return "female";
        }
        if (s.contains("2")) {
            return "male";
        }
        return "male";
    }

}
