package by.salei.parser.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Listing implements Component<Sentence>{

    private List<Sentence> sentences = new ArrayList<>();
    public List<Sentence> getSentences() {
        return sentences;
    }
    private final Logger LOGGER = LoggerFactory.getLogger(Listing.class);

    public Listing() {
    }

    public Listing(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public void add(Sentence sentence) {
        LOGGER.info("MODEL: add sentence to sentences list");
        sentences.add(sentence);
    }

    @Override
    public void delete(Sentence sentence) {
        LOGGER.info("MODEL: delete sentence from sentences list");
        sentences.remove(sentence);
    }

    @Override
    public Sentence getElement(Integer index) {
        return sentences.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Sentence sentence : sentences){
            stringBuilder.append(sentence);
        }
        return stringBuilder.toString();
    }

}
