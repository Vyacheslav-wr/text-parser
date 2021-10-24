package by.salei.parser.model;

import java.util.ArrayList;

public class Composite implements Component<Component>{

    private ArrayList<Component> components = new ArrayList<>();

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public Composite() {
    }

    public Composite(ArrayList<Component> components) {
        this.components = components;
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void delete(Component component) {
        components.remove(component);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for(Component component : components){
            stringBuffer.append(component);
        }
        return stringBuffer.toString();
    }
}
