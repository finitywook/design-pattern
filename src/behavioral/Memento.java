package behavioral;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Memento
 * 메멘토 패턴
 */
public class Memento {

    public static void main(String[] args) {
        Car car = new Car("K5", "RED");

        CarCaretaker caretaker = new CarCaretaker();

        caretaker.add(car.save());

        car.setColor("BLUE");
        caretaker.add(car.save());

        car.setModel("K3");
        caretaker.add(car.save());

        car.restore(caretaker.get());
        car.restore(caretaker.get());
        car.restore(caretaker.get());
    }

    /**
     * originator
     */
    static class Car {
        private String model;
        private String color;

        public Car(String model, String color) {
            this.model = model;
            this.color = color;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public void setModel(String model) {
            this.model = model;
            System.out.println("Car: Setting model to = " + model);
        }

        public void setColor(String color) {
            this.color = color;
            System.out.println("Car: Setting color to = " + color);
        }

        public CarMemento save() {
            return new CarMemento(model, color);
        }

        public void restore(CarMemento memento) {
            this.model = memento.getModel();
            this.color = memento.getColor();

            System.out.println("Car: Restore model to = " + model + ", color to = " + color);
        }
    }

    /**
     * memento
     */
    static class CarMemento {
        private final String model;
        private final String color;

        public CarMemento(String model, String color) {
            this.model = model;
            this.color = color;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }
    }


    /**
     * caretaker
     */
    static class CarCaretaker {
        private final Queue<CarMemento> mementos = new ArrayDeque<>();

        public void add(CarMemento memento) {
            this.mementos.add(memento);
        }

        public CarMemento get() {
            if(mementos.isEmpty()) {
                throw new ArrayIndexOutOfBoundsException();
            }

            return this.mementos.poll();
        }
    }
}
