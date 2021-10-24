package by.salei.parser.model;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Component<Word>{

    private List<Word> words = new ArrayList<>();

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
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for(Word word : words){
            stringBuffer.append(word);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

    @Override
    public void add(Word word) {
        words.add(word);
    }

    @Override
    public void delete(Word word) {
        words.remove(word);
    }
}
