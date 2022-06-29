package javapattern.mediator;

/**
 * @author hbw
 */
public class TextPane
        implements Pane {

    private final Mediator mediator;

    public TextPane(
            Mediator mediator) {

        this.mediator = mediator;
    }

    @Override
    public void trigger() {

        mediator.option(PaneType.TEXT_PANE);
    }
}
