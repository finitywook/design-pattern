package behavioral;

/**
 * Commend
 *
 * 커맨드 패턴
 */
public class Commend {

    public static void main(String[] args) {
        Navigator navigator = new Navigator();

        NavigatorOnCommend onCommend = new NavigatorOnCommend(navigator);
        NavigatorOffCommend offCommend = new NavigatorOffCommend(navigator);

        Car car = new Car();

        car.setBootable(onCommend);
        car.talk();

        car.setBootable(offCommend);
        car.talk();
    }

    static class Car {
        private Bootable bootable;

        public void setBootable(Bootable bootable) {
            this.bootable = bootable;
        }

        public void talk() {
            bootable.boot();
        }
    }

    interface Bootable {
        void boot();
    }

    static class Navigator {
        public void powerOn() {
            System.out.println("네이게이션 실행");
        }

        public void powerOff() {
            System.out.println("네이게이션 종료");
        }
    }

    static class NavigatorOnCommend implements Bootable {
        private final Navigator navigator;

        public NavigatorOnCommend(Navigator navigator) {
            this.navigator = navigator;
        }

        @Override
        public void boot() {
            navigator.powerOn();
        }
    }

    static class NavigatorOffCommend implements Bootable {
        private final Navigator navigator;

        public NavigatorOffCommend(Navigator navigator) {
            this.navigator = navigator;
        }

        @Override
        public void boot() {
            navigator.powerOff();
        }
    }
}
