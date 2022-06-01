package javapattern.abstractfactory;

/**
 * @author 86136
 */
public class WinMobileControllerFactory
        implements ControllerFactory {

    @Override
    public InterfaceController createInterfaceController() {

        return new WinMobileInterfaceController();
    }

    @Override
    public OperationController createOperationController() {

        return new WinMobileOperationController();
    }
}
