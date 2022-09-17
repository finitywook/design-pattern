package creational;

/**
 * Builder
 *
 * 빌더 패턴
 */
public class Builder {

    public static void main(String[] args) {
        Car car = Car.builder()
                .name("K5")
                .color(255)
                .build();

        System.out.println("car.getName() = " + car.getName());
        System.out.println("car.getColor() = " + car.getColor());

        Car avante = CarDirector.getAvante();

        System.out.println("avante.getName() = " + avante.getName());
        System.out.println("avante.getColor() = " + avante.getColor());

        Car genesis = CarDirector.getGenesis();

        System.out.println("genesis.getName() = " + genesis.getName());
        System.out.println("genesis.getColor() = " + genesis.getColor());
    }

    static class CarDirector {
        public static Car getAvante() {
            return Car.builder()
                    .name("Avante")
                    .color(300)
                    .build();
        }

        public static Car getGenesis() {
            return Car.builder()
                    .name("Genesis")
                    .color(6320)
                    .build();
        }
    }

    static class Car {
        private final String name;
        private final int color;

        public Car(String name, int color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public int getColor() {
            return color;
        }

        public static CarBuilder builder() {
            return new CarBuilder();
        }

        static class CarBuilder {
            private String name;
            private int color;

            public CarBuilder() {
            }

            public CarBuilder name(String name) {
                this.name = name;
                return this;
            }

            public CarBuilder color(int color) {
                this.color = color;
                return this;
            }

            public Car build() {
                return new Car(name, color);
            }
        }
    }
}
