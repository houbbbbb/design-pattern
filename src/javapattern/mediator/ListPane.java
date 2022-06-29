package javapattern.mediator;

/**
 * @author hbw
 */
public class ListPane
        implements Pane {

    private final Mediator mediator;

    public ListPane(
            Mediator mediator) {

        this.mediator = mediator;
    }

    @Override
    public void trigger() {

        mediator.option(PaneType.LIST_PANE);
    }
}
