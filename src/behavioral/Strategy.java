package behavioral;

/**
 * Strategy
 *
 * 전략 패턴
 */
public class Strategy {

    public static void main(String[] args) {
        People people = new People();

        people.goToWork(new Bus());
        people.goToWork(new Car());
        people.goToWork(new Motorcycle());
    }

    static class People {
        public void goToWork(MoveStrategy strategy) {
            System.out.println("출근...");

            strategy.move();
        }
    }

    interface MoveStrategy {
        void move();
    }

    static class Car implements MoveStrategy {
        @Override
        public void move() {
            System.out.println("차타고 갑니다.");
        }
    }

    static class Motorcycle implements MoveStrategy {
        @Override
        public void move() {
            System.out.println("오토바이타고 갑니다.");
        }
    }

    static class Bus implements MoveStrategy {
        @Override
        public void move() {
            System.out.println("버스타고 갑니다.");
        }
    }
}
