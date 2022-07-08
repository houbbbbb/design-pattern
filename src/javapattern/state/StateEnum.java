package javapattern.state;

/**
 * @author hbw
 */

public enum StateEnum
        implements State {

    /**
     * 关闭
     */
    CLOSED {

        @Override
        public void handle() {

            ClosedState.getInstance()
                    .handle();
        }
    },

    /**
     * 关闭中
     */
    CLOSING {

        @Override
        public void handle() {

            ClosingState.getInstance()
                    .handle();
        }
    },

    /**
     * 打开中
     */
    OPENING {

        @Override
        public void handle() {

            OpeningState.getInstance()
                    .handle();
        }
    },

    /**
     * 打开
     */
    OPEN {

        @Override
        public void handle() {

            OpenState.getInstance()
                    .handle();
        }
    },

    /**
     * 保持打开
     */
    STAY_OPEN {

        @Override
        public void handle() {

            StayOpenState.getInstance()
                    .handle();
        }
    }
}
