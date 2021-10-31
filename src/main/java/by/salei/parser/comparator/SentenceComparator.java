package by.salei.parser.comparator;

import by.salei.parser.model.Sentence;
import by.salei.parser.model.Word;

import java.util.Comparator;
import java.util.regex.Pattern;

public class SentenceComparator implements Comparator<Sentence> {

    private final Pattern pattern = Pattern.compile("[,:'()-]");

    @Override
    public int compare(Sentence o1, Sentence o2) {
        int size1 = evaluateSize(o1);
        int size2 = evaluateSize(o2);

        if(size1 > size2){
            return 1;
        }
        if(size1 < size2){

            return -1;
        }
        return 0;
    }

    private int evaluateSize(Sentence sentence){
        StringBuilder sb = new StringBuilder();
        int size = sentence.getWords().size();

        for(Word word : sentence.getWords()){
            sb.append(word.getSymbols().get(0));
            if(pattern.matcher(sb.toString()).matches()){
                size--;
            }
        }
        return size;
    }
}
