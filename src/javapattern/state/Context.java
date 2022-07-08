package javapattern.state;

/**
 * @author hbw
 */
public class Context {

    private StateEnum stateEnum;

    public void setState(
            StateEnum stateEnum) {

        this.stateEnum = stateEnum;
    }

    public void click() {

        switch (this.stateEnum) {
            case CLOSED:
            case CLOSING:
                StateEnum.OPENING.handle();
                break;
            case OPENING:
            case STAY_OPEN:
                StateEnum.CLOSING.handle();
                break;
            case OPEN:
                StateEnum.STAY_OPEN.handle();
                break;
            default:
                break;
        }
    }

    public void complete() {

        switch (this.stateEnum) {

            case CLOSING:
                StateEnum.CLOSED.handle();
                break;
            case OPENING:
                StateEnum.OPEN.handle();
                break;
            default:
                break;
        }
    }

    public void timeout() {

        switch (this.stateEnum) {

            case OPEN:
                StateEnum.CLOSING.handle();
                break;
            default:
                break;
        }
    }
}
