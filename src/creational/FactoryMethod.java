package creational;

public class FactoryMethod {

    public static void main(String[] args) {
        final Car hyundaiCar = CarFactory.create(CarType.HYUNDAI);
        final Car kiaCar = CarFactory.create(CarType.KIA);
        final Car samsungCar = CarFactory.create(CarType.SAMSUNG);

        System.out.println("hyundaiCar.getPrice() = " + hyundaiCar.getPrice());
        System.out.println("kiaCar.getPrice() = " + kiaCar.getPrice());
        System.out.println("samsungCar.getPrice() = " + samsungCar.getPrice());
    }

    static class CarFactory {
        public static Car create(CarType carType) {
            return switch (carType) {
                case HYUNDAI -> new HyundaiCar();
                case SAMSUNG -> new SamsungCar();
                case KIA -> new KiaCar();
            };
        }
    }

    enum CarType {
        HYUNDAI,
        SAMSUNG,
        KIA
    }

    static abstract class Car {
          public abstract int getPrice();
    }

    static class HyundaiCar extends Car {
        @Override
        public int getPrice() {
            return 20000000;
        }
    }

    static class SamsungCar extends Car {
        @Override
        public int getPrice() {
            return 19000000;
        }
    }

    static class KiaCar extends Car {
        @Override
        public int getPrice() {
            return 21000000;
        }
    }
}
