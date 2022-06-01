package javapattern.abstractfactory;

/**
 * @author 86136
 */
public class AndroidControllerFactory
        implements ControllerFactory {

    @Override
    public InterfaceController createInterfaceController() {

        return new AndroidInterfaceController();
    }

    @Override
    public OperationController createOperationController() {

        return new AndroidOperationController();
    }
}
