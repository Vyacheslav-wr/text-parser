package by.salei.parser.comparator;

import by.salei.parser.model.Sentence;
import by.salei.parser.model.Word;

import java.util.Comparator;

public class SentenceComparator implements Comparator<Sentence> {

    @Override
    public int compare(Sentence o1, Sentence o2) {
        int size1 = o1.getWords().size();
        int size2 = o2.getWords().size();
        for(Word word : o1.getWords()){
            if(word.getSymbols().get(0).isPunctuationMark()){
                size1--;
            }
        }
        for(Word word : o2.getWords()){
            if(word.getSymbols().get(0).isPunctuationMark()){
                size2--;
            }
        }
        if(size1 > size2){
            return 1;
        }
        if(size1 < size2){

            return -1;
        }
        return 0;
    }
}
