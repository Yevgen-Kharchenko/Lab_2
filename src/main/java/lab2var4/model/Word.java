package lab2var4.model;

import lab2var4.model.Sentence;

import java.util.*;

public class Word extends Sentence {
    public Set<String> separatorUniqueWord(List<Sentence> sentences, int length) {
        Set<String> word = new TreeSet<>();
        for (Sentence sentence : sentences) {
            StringTokenizer stringTokenizer = new StringTokenizer(sentence.getString(), " \n\t,.:;!?“”_$(1234567890)\"");
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
