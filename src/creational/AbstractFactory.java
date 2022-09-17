package creational;

/**
 * Abstract Factory
 *
 * 추상 팩터리 패턴
 */
public class AbstractFactory {

    public static void main(String[] args) {

        CarType carType = CarType.HYUNDAI;

        CarFactory factory = switch (carType) {
            case HYUNDAI -> new HyundaiCarFactory();
            case KIA -> new KiaCarFactory();
            case SAMSUNG -> new SamsungCarFactory();
        };

        Car car = factory.create();

        System.out.println("car.getPrice() = " + car.getPrice());
    }

    interface Car {
        int getPrice();
    }

    interface CarFactory {
        Car create();
    }

    enum CarType {
        HYUNDAI,
        SAMSUNG,
        KIA
    }

    static class HyundaiCarFactory implements CarFactory {
        @Override
        public Car create() {
            return new HyundaiCar();
        }
    }

    static class SamsungCarFactory implements CarFactory {
        @Override
        public Car create() {
            return new SamsungCar();
        }
    }

    static class KiaCarFactory implements CarFactory {
        @Override
        public Car create() {
            return new KiaCar();
        }
    }

    static class HyundaiCar implements Car {
        @Override
        public int getPrice() {
            return 20000000;
        }
    }

    static class SamsungCar implements Car {
        @Override
        public int getPrice() {
            return 19000000;
        }
    }

    static class KiaCar implements Car {
        @Override
        public int getPrice() {
            return 21000000;
        }
    }
}
