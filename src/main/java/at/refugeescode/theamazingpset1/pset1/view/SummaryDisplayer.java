package at.refugeescode.theamazingpset1.pset1.view;

import org.springframework.stereotype.Component;
import at.refugeescode.theamazingpset1.pset1.modal.Summary;

@Component
public class SummaryDisplayer {
    public void display(Summary summary) {
        System.out.println("=============\n");
            System.out.println("Top rated movies:\n");
            summary.getTopRatedMovie()
                    .forEach(ratedMovie -> System.out.println(ratedMovie));

            System.out.println(" ------ ");
            System.out.println("most hired actros:\n");
            summary.getActorName()
                    .forEach(actor -> System.out.println(actor.trim()));
            System.out.println("------- ");
            System.out.println("Top movie generous:\n");
            summary.getMovieGenres()
                    .forEach(movieGenrous -> System.out.println(movieGenrous.trim()));
            System.out.println("------- ");
            System.out.println("Actors male-female ratio:\n");
        System.out.println(summary.getRatio());
        System.out.println("=============\n");

    }


    public void display() {
        System.out.println("The info that you tring to reach right now is reachable");
    }
}
