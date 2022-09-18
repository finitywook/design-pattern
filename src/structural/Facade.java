package structural;

/**
 * Facade
 *
 * 퍼사드 패턴
 */
public class Facade {

    public static void main(String[] args) {
        System.out.println("시동 시작!");

        CarFacade car = new CarFacade();

        car.boot();

        System.out.println("시동 완료!");
    }

    static class CarFacade {
        public void boot() {
            Motor motor = new Motor();
            Engine engine = new Engine();
            Navigator navigator = new Navigator();

            motor.start();
            engine.startup();
            navigator.boot();
        }
    }

    static class Motor {
        public void start() {
            System.out.println("모터 시작!");
        }
    }

    static class Engine {
        public void startup() {
            System.out.println("엔진 가동!");
        }
    }

    static class Navigator {
        public void boot() {
            System.out.println("네비게이션 시작!");
        }
    }
}
