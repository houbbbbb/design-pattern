package javapattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hbw
 */
public class ConcreteMediator
        implements Mediator {

    public ConcreteMediator() {}

    private List<Pane> panes = new ArrayList<>();

    @Override
    public void addPane(
            Pane pane) {

        panes.add(pane);
    }

    @Override
    public void option(
            Pane.PaneType paneType) {

        switch (paneType) {
            case LIST_PANE:
                System.out.println("列表进行了修改");
                resp();
                break;
            case TEXT_PANE:
                System.out.println("文本进行了修改");
                resp();
                break;
            case GRAPHIC_PANE:
                System.out.println("图形进行了修改");
                resp();
                break;
            default: throw new UnsupportedOperationException();
        }
    }

    private void resp() {

        panes.forEach(pane ->
            System.out.println(pane.getClass() + "做出了回应"));
    }
}
