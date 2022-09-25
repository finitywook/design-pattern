package behavioral;

/**
 * State
 *
 * 상태 패턴
 */
public class State {

    public static void main(String[] args) {
        Car car = new Car();

        car.work();
        car.setCarState(new Startup());

        car.work();
        car.setCarState(new Shutdown());
    }

    static class Car {
        private CarState carState;

        public Car() {
            this.carState = new Shutdown();
        }

        public void setCarState(CarState carState) {
            this.carState = carState;
        }

        public void work() {
            carState.work();
        }
    }

    interface CarState {
        void work();
    }

    static class Startup implements CarState {
        @Override
        public void work() {
            System.out.println("종료합니다.");
        }
    }

    static class Shutdown implements CarState {
        @Override
        public void work() {
            System.out.println("시동을 겁니다.");
        }
    }
}
