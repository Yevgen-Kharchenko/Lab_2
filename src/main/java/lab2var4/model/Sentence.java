package lab2var4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sentence {

    private static final String DELIMITER = "\n:.!?\"“”";
    private static final String MARK = "?";

    String getString() {
        return string;
    }

    private String string = "";

    public Sentence() {

    }

    Sentence(String string) {
        this.string = string;
    }

    public String toString() {
        return string;
    }

    public List<Sentence> separate(String contents) {
        StringTokenizer stringTokenizer = new StringTokenizer(contents, DELIMITER, true);
        String last;
        String current = "";
        List<Sentence> sentences = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            last = current;
            current = stringTokenizer.nextToken().trim();

            if (current.equals(MARK)) {
                Sentence sentence = new Sentence(last + current);
                sentences.add(sentence);
            }
        }
        return sentences;
    }
}
