package structural;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite
 *
 * 컴퍼지트 패턴
 */
public class Composite {

    public static void main(String[] args) {
        HyundaiFrame frame = new HyundaiFrame();
        HyundaiMotor motor = new HyundaiMotor();
        HyundaiColor color = new HyundaiColor();

        HyundaiCar hyundaiCar = new HyundaiCar();
        hyundaiCar.addComponent(frame);
        hyundaiCar.addComponent(motor);
        hyundaiCar.addComponent(color);

        System.out.println("hyundaiCar.getPrice() = " + hyundaiCar.getPrice());
    }

    interface Car {
        int getPrice();
    }

    static class HyundaiCar implements Car {
        private final List<Car> components = new ArrayList<>();

        @Override
        public int getPrice() {
            return components.stream()
                    .mapToInt(Car::getPrice)
                    .sum();
        }

        public void addComponent(Car component) {
            this.components.add(component);
        }
    }

    static class HyundaiFrame implements Car {
        @Override
        public int getPrice() {
            return 300000;
        }
    }

    static class HyundaiMotor implements Car {
        @Override
        public int getPrice() {
            return 9000000;
        }
    }

    static class HyundaiColor implements Car {
        @Override
        public int getPrice() {
            return 100000;
        }
    }
}
