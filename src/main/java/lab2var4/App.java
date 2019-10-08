package lab2var4;

import lab2var4.model.Sentence;
import lab2var4.model.Word;
import lab2var4.service.UserInteractionService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;


public class App {


    private String contents;
    private int lengthWord;
    private ArrayList<Sentence> sentences;


    private UserInteractionService userInteractionService;
    private Word word;

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.setUserInteractionService(new UserInteractionService());
        app.setWord(new Word());

        app.setParameters();
        app.separationIntoSentences(new Sentence());
        app.separationIntoWord();
    }


    private void setParameters() throws IOException {
        int fileNumber = userInteractionService.getUserInput("Select the file to scan 1/2", 2);
        contents = userInteractionService.readUsingFiles(fileNumber);

        userInteractionService.showMessage("Your text is:");

        userInteractionService.outputResult(contents);
        lengthWord = userInteractionService.getUserInput("Enter a word length for the search (1-15)", 15);
        System.out.println(lengthWord);

    }

    private void separationIntoSentences(Sentence sentence) {
        sentences = (ArrayList<Sentence>) sentence.separator(contents);
        if (sentences.isEmpty()) {
            userInteractionService.showMessage("You have not question sentences");
        } else {
            userInteractionService.showMessage("You have " + sentences.size() + " question sentences:");
            for (Sentence s : sentences) {
                userInteractionService.outputResult("" + s);
            }
        }
    }

    private void separationIntoWord() {
        TreeSet<String> uniqueWord = (TreeSet<String>) word.separatorUniqueWord(sentences, lengthWord);
        if (sentences.isEmpty() || uniqueWord.isEmpty()) {

            userInteractionService.showMessage("There are no words of the specified length");
        } else {

            userInteractionService.showMessage("Your have " + uniqueWord.size() + " words with the length of " + lengthWord + " characters:");

            for (String w : uniqueWord) {
                userInteractionService.outputResult(w);
            }
        }
    }

    private void setUserInteractionService(UserInteractionService userInteractionService) {
        this.userInteractionService = userInteractionService;
    }

    private void setWord(Word word) {
        this.word = word;
    }
}
