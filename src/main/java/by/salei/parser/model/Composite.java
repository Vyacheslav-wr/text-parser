package by.salei.parser.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Composite implements Component<Component>{

    private ArrayList<Component> components = new ArrayList<>();
    public ArrayList<Component> getComponents() {
        return components;
    }
    private final Logger LOGGER = LoggerFactory.getLogger(Composite.class);

    public Composite() {
    }

    public Composite(ArrayList<Component> components) {
        this.components = components;
    }

    @Override
    public void add(Component component) {
        LOGGER.info("MODEL: add component components list");
        components.add(component);
    }

    @Override
    public void delete(Component component) {
        LOGGER.info("MODEL: delete component from components list");
        components.remove(component);
    }

    @Override
    public Component getElement(Integer index) {
        return components.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Component component : components){
            stringBuilder.append(component);
        }
        return stringBuilder.toString();
    }
}
