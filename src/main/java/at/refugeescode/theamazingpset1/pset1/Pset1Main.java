package at.refugeescode.theamazingpset1.pset1;

import at.refugeescode.theamazingpset1.pset1.controller.MovieDatabaseSummarizer;
import at.refugeescode.theamazingpset1.pset1.modal.Summary;
import at.refugeescode.theamazingpset1.pset1.view.SummaryDisplayer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//import at.refugeescode.theamazingpset1.pset1.view.SummaryDisplayer;

import java.util.Optional;

@Configuration
public class Pset1Main {

    @Bean
    public ApplicationRunner getInformations(MovieDatabaseSummarizer summarizer, SummaryDisplayer displayer){
        //MovieDatabaseSummarizer summarizer = new MovieDatabaseSummarizer();
        //SummaryDisplayer displayer = new SummaryDisplayer();

        return argv -> {
            Optional<Summary> summary = summarizer.summarize();
            if (summary.isPresent()) {
                displayer.display(summary.get());
            } else {
                displayer.display();
            }
        };
    }
}
