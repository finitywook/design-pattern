package behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Mediator
 *
 * 중재자 패턴
 */
public class Mediator {

    public static void main(String[] args) {
        ConcreteCarMediator mediator = new ConcreteCarMediator();

        HyundaiCar avente = new HyundaiCar("Avente");
        HyundaiCar sonata = new HyundaiCar("Sonata");
        KiaCar k5 = new KiaCar("K5");
        KiaCar k3 = new KiaCar("K3");

        avente.setMediator(mediator);
        sonata.setMediator(mediator);
        k5.setMediator(mediator);
        k3.setMediator(mediator);

        mediator.addCar(avente);
        mediator.addCar(sonata);
        mediator.addCar(k5);
        mediator.addCar(k3);

        avente.boot();
    }

    interface CarMediator {
        void addCar(Car car);
        void mediate(Car car);
    }

    static class ConcreteCarMediator implements CarMediator {
        private final List<Car> cars;

        public ConcreteCarMediator() {
            this.cars = new ArrayList<>();
        }

        @Override
        public void addCar(Car car) {
            this.cars.add(car);
        }

        @Override
        public void mediate(Car car) {
            cars.forEach(Car::move);
        }
    }

    static abstract class Car {
        private CarMediator mediator;
        protected String name;

        public Car(String name) {
            this.name = name;
        }

        public void setMediator(CarMediator mediator) {
            this.mediator = mediator;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void boot() {
            System.out.println(this.name + " boot!\n");
            mediator.mediate(this);
        }

        public abstract void move();
    }

    static class HyundaiCar extends Car {
        public HyundaiCar(String name) {
            super(name);
        }

        @Override
        public void move() {
            System.out.println(this.name + " move!");
        }
    }

    static class KiaCar extends Car {
        public KiaCar(String name) {
            super(name);
        }

        @Override
        public void move() {
            System.out.println(this.name + " break down...");
        }
    }

}
