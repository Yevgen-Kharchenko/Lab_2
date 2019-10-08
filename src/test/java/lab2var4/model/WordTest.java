package lab2var4.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class WordTest {

    private Word word;
    private List<Sentence> testList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        word = new Word();

        testList.add(new Sentence("I, have; many money$?"));
        testList.add(new Sentence("I \"have: many9 money?"));
        testList.add(new Sentence("I have\n many_ (money)?"));

    }


    @Test
    public void separateToUniqueWords() {
        Set<String> expectedSet = new TreeSet<>();
        expectedSet.add("have");
        expectedSet.add("many");
        Set<String> wordTest = word.separateToUniqueWords(testList, 4);
        assertEquals(expectedSet.toString(), wordTest.toString());
    }

    @Test
    public void separateToUniqueWordsShouldBeEmpty() {
        Set<String> expectedSet = new TreeSet<>();
        Set<String> wordTest = word.separateToUniqueWords(testList, 6);
        assertEquals(expectedSet.toString(), wordTest.toString());
    }
}
