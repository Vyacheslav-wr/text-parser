package by.salei.parser.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Sentence implements Component<Word>{

    private List<Word> words = new ArrayList<>();
    private final Pattern pattern = Pattern.compile("\\n");

    public List<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public Sentence() {
    }

    public Sentence(ArrayList<Word> words) {
        this.words = words;
    }

    @Override
    public void add(Word word) {
        words.add(word);
    }

    @Override
    public void delete(Word word) {
        words.remove(word);
    }

    @Override
    public Word getElement(Integer index) {
        return words.get(index);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for(Word word : words){
            stringBuffer.append(word);
            if(!pattern.matcher(word.toString()).matches()){
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }
}
