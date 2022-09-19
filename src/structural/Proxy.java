package structural;

/**
 * Proxy
 *
 * 프록시 패턴
 */
public class Proxy {

    public static void main(String[] args) {
        Bootable k5 = new CarProxy("K5", 32000);
        k5.printStatus();
        k5.boot();
    }

    interface Bootable {
        int getDriveDistance();
        void printStatus();
        void boot();
    }

    static class Car implements Bootable {
        private final String name;
        private final int driveDistance;

        public Car(String name, int driveDistance) {
            this.name = name;
            this.driveDistance = driveDistance;

            bootParts();
        }

        @Override
        public int getDriveDistance() {
            return this.driveDistance;
        }

        @Override
        public void printStatus() {
            System.out.println("===================== [Status] =====================");
            System.out.println("Name = " + name + ", driveDistance = " + driveDistance);
            System.out.println("===================== [Status] =====================");
        }

        @Override
        public void boot() {
            System.out.println("Car " + name + " boot success!");
        }

        private void bootParts() {
            System.out.println(name + " 부품 구동 중");
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                }
                System.out.println(".");
            }
            System.out.println("success!");
        }
    }

    static class CarProxy implements Bootable {
        private final String name;
        private final int driveDistance;

        private Car car;

        public CarProxy(String name, int driveDistance) {
            this.name = name;
            this.driveDistance = driveDistance;
        }

        @Override
        public int getDriveDistance() {
            if(car != null) {
                return car.getDriveDistance();
            }

            return this.driveDistance;
        }

        @Override
        public void printStatus() {
            if(car != null) {
                car.printStatus();
            }

            System.out.println("===================== [Status] =====================");
            System.out.println("Name = " + name + ", driveDistance = " + driveDistance);
            System.out.println("===================== [Status] =====================");
        }

        @Override
        public void boot() {
            realize();
            car.boot();
        }

        private synchronized void realize() {
            if(car == null) {
                car = new Car(name, driveDistance);
            }
        }
    }
}
