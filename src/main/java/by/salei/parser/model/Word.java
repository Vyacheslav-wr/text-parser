package by.salei.parser.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Word implements Component<Character>{

    private List<Character> symbols = new ArrayList<>();
    Logger LOGGER = LoggerFactory.getLogger(Word.class);

    public List<Character> getSymbols() {
        return symbols;
    }

    public Word() {
    }

    public Word(ArrayList<Character> symbols) {
        this.symbols = symbols;
    }

    @Override
    public void add(Character symbol) {
        LOGGER.info("MODEL: add symbol to symbols list");
        symbols.add(symbol);
    }

    @Override
    public void delete(Character symbol) {
        LOGGER.info("MODEL: delete symbol from list");
        symbols.remove(symbol);
    }

    @Override
    public Character getElement(Integer index) {
        return symbols.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Character symbol : symbols){
            stringBuilder.append(symbol);
        }
        return stringBuilder.toString();
    }
}
