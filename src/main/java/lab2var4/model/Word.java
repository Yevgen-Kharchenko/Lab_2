package lab2var4.model;

import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Word extends Sentence {

    private static final String DELIMITER = " \n\t,.:;!?“”_$(1234567890)\"";

    public Set<String> separateToUniqueWords(List<Sentence> sentences, int length) {
        Set<String> word = new TreeSet<>();
        for (Sentence sentence : sentences) {
            StringTokenizer stringTokenizer = new StringTokenizer(sentence.getString(), DELIMITER);
            while (stringTokenizer.hasMoreTokens()) {
                String current = stringTokenizer.nextToken().trim();
                if (current.length() == length) {
                    word.add(current);
                }
            }
        }
        return word;
    }
}
