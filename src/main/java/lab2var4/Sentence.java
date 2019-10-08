package lab2var4;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sentence {
    private String string;

    public Sentence() {
        this.string = "";
    }

    public Sentence(String string) {
        this.string = string;
    }

    public String toString() {
        return string;
    }

    public List<Sentence> separator (String contents) {
        StringTokenizer stringTokenizer = new StringTokenizer(contents, "\n:.!?", true);
        String last;
        String current = "";
        List<Sentence> sentences = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            last = current;
            current = stringTokenizer.nextToken().trim();

            if (current.equals("?")) {
                Sentence sentence = new Sentence(last + current);
                sentences.add(sentence);
            }
        }
    return sentences;
    }

}
