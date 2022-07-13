package javapattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hbw
 */
public class Members {

    private List<Element> elements = new ArrayList<>();

    public void addElement(
            Element element) {

        elements.add(element);
    }

    public void accept(
            Visitor visitor) {

        elements.forEach(element -> element
                .accept(visitor));
    }
}
