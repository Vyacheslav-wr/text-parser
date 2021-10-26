package by.salei.parser.model;

import java.util.ArrayList;
import java.util.List;

public class Word implements Component<Symbol>{

    private List<Symbol> symbols = new ArrayList<>();

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(ArrayList<Symbol> symbols) {
        this.symbols = symbols;
    }

    public Word() {
    }

    public Word(ArrayList<Symbol> symbols) {
        this.symbols = symbols;
    }

    @Override
    public void add(Symbol symbol) {
        symbols.add(symbol);
    }

    @Override
    public void delete(Symbol symbol) {
        symbols.remove(symbol);
    }

    @Override
    public Symbol getElement(Integer index) {
        return symbols.get(index);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for(Symbol symbol : symbols){
            stringBuffer.append(symbol);
        }
        return stringBuffer.toString();
    }
}
