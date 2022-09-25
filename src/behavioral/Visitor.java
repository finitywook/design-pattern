package behavioral;

/**
 * Visitor
 *
 * 방문자 패턴
 */
public class Visitor {

    public static void main(String[] args) {
        Car car = new HyundaiCar();

        car.drive();
        car.visit(new CarViewVisitor());

        car = new KiaCar();
        car.drive();
        car.drive();
        car.visit(new CarViewVisitor());
    }

    interface Car {
        int drive();
        int getFuel();
        void visit(ViewVisitor visitor);
    }

    static class HyundaiCar implements Car {
        private int fuel = 10;

        @Override
        public int drive() {
            return --fuel;
        }

        @Override
        public int getFuel() {
            return fuel;
        }

        @Override
        public void visit(ViewVisitor visitor) {
            visitor.visit(this);
        }
    }

    static class KiaCar implements Car {
        private int fuel = 10;

        @Override
        public int drive() {
            return --fuel;
        }

        @Override
        public int getFuel() {
            return fuel;
        }

        @Override
        public void visit(ViewVisitor visitor) {
            visitor.visit(this);
        }
    }

    interface ViewVisitor {
        void visit(HyundaiCar car);
        void visit(KiaCar car);
    }


    static class CarViewVisitor implements ViewVisitor {
        @Override
        public void visit(HyundaiCar car) {
            System.out.println("현재 현대차의 상태 : " + car.getFuel());
        }

        @Override
        public void visit(KiaCar car) {
            System.out.println("현재 기아차의 상태 : " + car.getFuel());
        }
    }
}
