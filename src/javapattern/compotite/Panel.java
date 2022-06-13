package javapattern.compotite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hbw
 */
public class Panel
        implements
        Component,
        ComponentManager {

    private List<Component> components = new ArrayList<>();

    @Override
    public void opt() {

        System.out.println("面板操作");

        components.forEach(Component::opt);
    }

    @Override
    public void add(
            Component component) {

        components.add(component);
    }

    @Override
    public void remove(
            Component component) {

        components.remove(component);
    }

    @Override
    public void remove(
            Integer i) {

        components.remove(i);
    }

    @Override
    public Component getChild(
            Integer i) {

        return components.get(i);
    }
}
