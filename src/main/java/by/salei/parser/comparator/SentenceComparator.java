package by.salei.parser.comparator;

import by.salei.parser.model.Sentence;
import by.salei.parser.model.Word;

import java.util.Comparator;
import java.util.regex.Pattern;

public class SentenceComparator implements Comparator<Sentence> {

    private final Pattern pattern = Pattern.compile("[,:'()-]");

    @Override
    public int compare(Sentence o1, Sentence o2) {
        int size1 = o1.getWords().size();
        int size2 = o2.getWords().size();
        StringBuilder sb= new StringBuilder();

        for(Word word : o1.getWords()){
            sb.append(word.getSymbols().get(0));
            if(pattern.matcher(sb.toString()).matches()){
                size1--;
            }
        }
        for(Word word : o2.getWords()){
            if(pattern.matcher(sb.toString()).matches()){
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
