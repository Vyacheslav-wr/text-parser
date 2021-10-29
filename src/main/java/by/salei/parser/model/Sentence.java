package by.salei.parser.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Sentence implements Component<Word>{

    private List<Word> words = new ArrayList<>();
    private final Pattern pattern = Pattern.compile("\\n");
    Logger LOGGER = LoggerFactory.getLogger(Sentence.class);

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
        LOGGER.info("MODEL: add word to word list");
        words.add(word);
    }

    @Override
    public void delete(Word word) {
        LOGGER.info("MODEL: delete word from word list");
        words.remove(word);
    }

    @Override
    public Word getElement(Integer index) {
        return words.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Word word : words){
            stringBuilder.append(word);
            if(!pattern.matcher(word.toString()).matches()){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
