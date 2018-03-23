package at.refugeescode.theamazingpset1.pset1.controller;

import pset1.modal.Actor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ActorsInfoGuy {
    public static String getRatio(List<Actor> actors) {
        String ActorsRato = actors.stream()
                .map(actor -> actor.getGender())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(stringLongEntry -> stringLongEntry.getKey() + " : ("+ ((stringLongEntry.getValue()*100)/actors.size()) + "%"+ ")")
                .collect(Collectors.joining(" "));
        return ActorsRato;
    }
    public static List<String> getMostHirdActors(List<Actor> actorsInfo) {
        return actorsInfo.stream()
                .collect(Collectors.groupingBy(name -> name.getName(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(e -> e.getKey() + " (" + e.getValue()+")")
                .limit(5)
                .collect(Collectors.toList());
    }

}
