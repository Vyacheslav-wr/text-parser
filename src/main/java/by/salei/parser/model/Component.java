package by.salei.parser.model;

public interface Component <T extends Component>{
    void add(T element);
    void delete(T element);
    T getElement(Integer index);
}
