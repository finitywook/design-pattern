package creational;

/**
 * Prototype
 *
 * 프로토타입 패턴
 */
public class Prototype {

    private static final long LOOP_COUNT = 10000000000L;

    public static void main(String[] args) {
        Car car = new Car("K5", 500); // 이미 존재하는 비슷한 객체..

        for(long i = 0; i < LOOP_COUNT - 1; i++) {
            car.clone();
        }
    }

    static class Car implements Cloneable {
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

        @Override
        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
