package structural;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight
 *
 * 플라이웨이트 패턴
 */
public class Flyweight {

    public static final int LOOP_COUNT = 1000;

    public static void main(String[] args) {
        String[] models = {"K5", "K3", "K7"};
        String[] colors = {"red", "blue", "green"};
        int[] maxSpeeds = {200, 150, 260};

        for(int i = 0; i < LOOP_COUNT; i++) {
            if(CarFactory.getCar(models[(int) (Math.random() * 3)]) instanceof HyundaiCar car) {
                car.setDetails(colors[(int) (Math.random() * 3)], maxSpeeds[(int) (Math.random() * 3)]);
                car.print();
            }
        }
    }

    interface Car {
        void print();
    }

    static class CarFactory {
        private static final Map<String, Car> store = new HashMap<>();

        public static Car getCar(String model) {
            Car car = store.get(model);

            if(car == null) {
                car = new HyundaiCar(model);
                store.put(model, car);
                System.out.println("create!");
            }

            return car;
        }
    }

    static class HyundaiCar implements Car {
        private final String model;
        private String color;
        private int maxSpeed;

        public HyundaiCar(String model) {
            this.model = model;
        }

        public void setDetails(String color, int maxSpeed) {
            this.color = color;
            this.maxSpeed = maxSpeed;
        }

        @Override
        public void print() {
            System.out.println("Model = "+model+", Color = "+color+", MaxSpeed = " + maxSpeed);
        }
    }
}
