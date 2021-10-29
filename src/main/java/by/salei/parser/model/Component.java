package by.salei.parser.model;

public interface Component <T>{
    void add(T element);
    void delete(T element);
    T getElement(Integer index);
}
