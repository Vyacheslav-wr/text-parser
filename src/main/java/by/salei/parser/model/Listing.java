package by.salei.parser.model;

import java.util.ArrayList;
import java.util.List;

public class Listing implements Component<Sentence>{

    private List<Sentence> sentences = new ArrayList<>();

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Listing() {
    }

    public Listing(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" ");
        for(Sentence sentence : sentences){
            stringBuffer.append(sentence);
        }
        return stringBuffer.toString();
    }

    @Override
    public void add(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public void delete(Sentence sentence) {
        sentences.remove(sentence);
    }
}
