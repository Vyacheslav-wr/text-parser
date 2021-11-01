package by.salei.parser.comparator;

import by.salei.parser.model.Sentence;
import by.salei.parser.model.Word;

import java.util.Comparator;
import java.util.regex.Pattern;

public class SentenceComparator implements Comparator<Sentence> {

    @Override
    public int compare(Sentence o1, Sentence o2) {
        int size1 = o1.getWords().size();
        int size2 = o2.getWords().size();

        if(size1 > size2){
            return 1;
        }
        if(size1 < size2){
            return -1;
        }
        return 0;
    }
}
