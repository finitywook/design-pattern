package behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer
 *
 * 옵서버 패턴
 */
public class Observer {

    public static void main(String[] args) {
        HyundaiCar car = createCar();

        car.ready();

        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {}

        car.emergency();
    }

    private static HyundaiCar createCar() {
        Motor motor = new Motor();
        Wiper wiper = new Wiper();
        Navigator navigator = new Navigator();
        Hud hud = new Hud();

        HyundaiCar car = new HyundaiCar();

        car.subscribe(motor);
        car.subscribe(wiper);
        car.subscribe(navigator);
        car.subscribe(hud);

        return car;
    }

    //
    interface Car {
        void subscribe(Part part);
        void unsubscribe(Part part);
        void startup();
        void shutdown();
    }

    interface Part {
        void startup();
        void shutdown();
    }

    static class HyundaiCar implements Car {

        private final List<Part> parts = new ArrayList<>();

        public void ready() {
            System.out.println("차량이 준비중입니다.");

            for(int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("" + (5 - i));
                } catch (Exception e) {}
            }

            startup();
        }

        public void emergency() {
            System.out.println("차량에 문제가 발생하여 긴급 중지합니다.");
            shutdown();
        }

        @Override
        public void subscribe(Part part) {
            parts.add(part);
        }

        @Override
        public void unsubscribe(Part part) {
            parts.remove(part);
        }

        @Override
        public void startup() {
            System.out.println("부품 시동 시작");
            parts.forEach(Part::startup);
            System.out.println("부품 시동 완료");

            System.out.println("차량 시동 성공");
        }

        @Override
        public void shutdown() {
            System.out.println("부품 중지 시작");
            parts.forEach(Part::shutdown);
            System.out.println("부품 중지 완료");

            System.out.println("차량 중지 성공");
        }
    }

    static class Motor implements Part {
        @Override
        public void startup() {
            System.out.println("모터 가동 완료.");
        }

        @Override
        public void shutdown() {
            System.out.println("모터 중단 완료.");
        }
    }

    static class Wiper implements Part {
        @Override
        public void startup() {
            System.out.println("와이퍼 가동 완료.");
        }

        @Override
        public void shutdown() {
            System.out.println("와이퍼 중단 완료.");
        }
    }

    static class Navigator implements Part {
        @Override
        public void startup() {
            System.out.println("내비 가동 완료.");
        }

        @Override
        public void shutdown() {
            System.out.println("내비 중단 완료.");
        }
    }

    static class Hud implements Part {
        @Override
        public void startup() {
            System.out.println("HUD 가동 완료.");
        }

        @Override
        public void shutdown() {
            System.out.println("HUD 중단 완료.");
        }
    }
}
