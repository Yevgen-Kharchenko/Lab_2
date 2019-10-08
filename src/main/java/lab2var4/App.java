package lab2var4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class App {


    private String contents;
    private int lengthWord;
    private ArrayList<Sentence> sentences;

    private UserInteractionService userInteractionService;

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.setUserInteractionService(new UserInteractionService());

        app.setParameters();
        app.separationIntoSentences(new Sentence());
    }


    private void setParameters() throws IOException {
        int fileNumber = userInteractionService.getUserInput("Select the file to scan 1/2", 2);
        contents = userInteractionService.readUsingFiles(fileNumber);
        userInteractionService.showMessage("Your text is:");
        userInteractionService.showMessage("");
        userInteractionService.showMessage(contents);
        lengthWord = userInteractionService.getUserInput("Enter a word length for the search (1-15)", 15);
        System.out.println(lengthWord);

    }

    private void separationIntoSentences(Sentence sentence) {
        ArrayList<Sentence> sentences = (ArrayList<Sentence>) sentence.separator(contents);
        userInteractionService.showMessage("You have " + sentences.size() + " question sentence:");
        userInteractionService.showMessage("");
        for (Sentence s : sentences) {
            userInteractionService.showMessage(""+s);
        }
    }

    private void setUserInteractionService(UserInteractionService userInteractionService) {
        this.userInteractionService = userInteractionService;
    }
}
