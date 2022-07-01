package javapattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hbw
 */
public class Originator {

    private CareTaker careTaker = new CareTaker();

    private Integer state;

    public Integer getState() {

        return state;
    }

    public void setState(
            Integer state) {

        this.state = state;
        this.save();
    }

    private void save() {

        careTaker.addMemento(new Memento(this.state));
    }

    public void undo() {

        this.state = careTaker.unDo().getState();
    }

    public void redo() {

        this.state = careTaker.reDo().getState();
    }

    public void printState() {

        System.out.println("state: " + this.state);
    }

    public static class CareTaker {

        private List<Memento> mementos = new ArrayList<>();

        private Integer index = -1;

        public Memento unDo() {

            if (index > 0) {
                return mementos.get(--index);
            }

            return mementos.get(index);
        }

        public Memento reDo() {

            if (index < mementos.size() - 1) {

                return mementos.get(++index);
            }

            return mementos.get(index);
        }

        public void addMemento(
                Memento memento) {

            this.mementos.add(memento);
            this.index = this.mementos.size() - 1;
        }
    }

    private static class Memento {

        private Integer state;

        public Integer getState() {

            return state;
        }

        public void setState(
                Integer state) {

            this.state = state;
        }

        private Memento(
                Integer state) {

            this.state = state;
        }
    }
}
