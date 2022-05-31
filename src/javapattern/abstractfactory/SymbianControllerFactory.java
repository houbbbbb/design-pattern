package javapattern.abstractfactory;

/**
 * @author 86136
 */
public class SymbianControllerFactory
        implements ControllerFactory {

    @Override
    public InterfaceController createInterfaceController() {

        return new SymbianInterfaceController();
    }

    @Override
    public OperationController createOperationController() {

        return new SymbianOperationController();
    }
}
