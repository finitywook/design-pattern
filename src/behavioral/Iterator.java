package behavioral;

/**
 * Iterator
 *
 * 이터레이터
 */
public class Iterator {

    public static void main(String[] args) {
        Garage garage = new Garage(10);

        Car k5 = new Car("K5", "RED");
        Car k3 = new Car("K3", "BLUE");
        Car k7 = new Car("K7", "RED");

        garage.addCar(k5);
        garage.addCar(k3);
        garage.addCar(k7);

        java.util.Iterator iterator = garage.createIterator();

        while (iterator.hasNext()) {
            Car car = (Car) iterator.next();

            System.out.println("car.model = " + car.model + ", car.color = " + car.color);
        }
    }

    static class Car {
        private final String model;
        private final String color;

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
    }

    interface Aggregate {
        java.util.Iterator createIterator();
    }

    static class Garage implements Aggregate {
        private final Car[] cars;
        private int last;

        @Override
        public java.util.Iterator createIterator() {
            return new GarageIterator(this);
        }

        public Garage(int size) {
            this.cars = new Car[size];
        }

        public Car getCar(int index) {
            return this.cars[index];
        }

        public int getLength() {
            return last;
        }

        public void addCar(Car car) {
            if(last < cars.length) {
                this.cars[last++] = car;
            } else {
                throw new IllegalArgumentException("차고지 꽉 참");
            }
        }
    }

    static class GarageIterator implements java.util.Iterator<Car> {
        private final Garage garage;
        private int index = 0;

        public GarageIterator(Garage garage) {
            this.garage = garage;
        }

        @Override
        public boolean hasNext() {
            return index < garage.getLength();
        }

        @Override
        public Car next() {
            return garage.getCar(index++);
        }
    }
}
