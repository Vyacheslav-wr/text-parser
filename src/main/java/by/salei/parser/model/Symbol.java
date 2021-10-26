package by.salei.parser.model;

public class Symbol implements Component<Symbol>{

    private char symbol;
    private boolean punctuationMark;

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isPunctuationMark() {
        return punctuationMark;
    }

    public void setPunctuationMark(boolean punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    public Symbol() {
    }

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(Symbol symbol) {
        //Do nothing
    }

    @Override
    public void delete(Symbol symbol) {
        //Do nothing
    }

    @Override
    public Symbol getElement(Integer index) {
        return null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(symbol);
        return sb.toString();
    }
}
