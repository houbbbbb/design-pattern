package javapattern.mediator;

/**
 * @author hbw
 */
public class GraphicPane
        implements Pane {

    private Mediator mediator;

    public GraphicPane(
            Mediator mediator) {

        this.mediator = mediator;
    }


    @Override
    public void trigger() {

        mediator.option(PaneType.GRAPHIC_PANE);
    }
}
