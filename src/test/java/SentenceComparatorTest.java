
import by.salei.parser.comparator.SentenceComparator;
import by.salei.parser.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SentenceComparatorTest {

    @Test
    public void compareTest(){
        Sentence sentence = new Sentence();
        ArrayList<Character> chare  =  new ArrayList(Arrays.asList("w", "o", "r", "d"));
        Word word = new Word(chare);
        Sentence sentence1 = new Sentence();
        ArrayList<Character> chares  =  new ArrayList(Arrays.asList("w", "o", "r", "d"));
        Word word1 = new Word(chare);
        SentenceComparator sc = new SentenceComparator();

        sentence.add(word);
        sentence1.add(word);
        sentence1.add(word1);
        Assertions.assertEquals(-1,sc.compare(sentence,sentence1));
    }
}
