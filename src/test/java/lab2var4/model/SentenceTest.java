package lab2var4.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SentenceTest {

    private Sentence sentence;
    private final String TEXT = "go? went. gone? have, has! had!";
    private final String TEXT2 = "go went. gone have, has! had!";

    @Before
    public void setUp() throws Exception {
        sentence = new Sentence();
    }

    @Test
    public void separate() {
        List<String> expectedList = Arrays.asList("go?", "gone?");

        List<Sentence> sentences = sentence.separate(TEXT);
        assertEquals(expectedList.toString(), sentences.toString());
    }

    @Test
    public void separateEmptyText() {
        List<String> expectedList = Arrays.asList();

        List<Sentence> sentences = sentence.separate(TEXT2);
        System.out.println(sentences);
        assertEquals(expectedList.toString(), sentences.toString());
    }
}