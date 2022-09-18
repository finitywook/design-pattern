package structural;

/**
 * Adapter
 *
 * 어댑터 패턴
 */
public class Adapter {

    public static void main(String[] args) {
        MotorCycle motorCycle = new HondaMotorCycle(10);
        Car car = new KiaCar(10, 2000);

        motorCycle.go();
        motorCycle.speedUp(10);
        motorCycle.speedUp(30);
        motorCycle.speedUp(70);
        motorCycle.speedDown(50);
        motorCycle.stop();

        demonstrate(car);

        MotorCycleAdapter adapter = new MotorCycleAdapter(motorCycle);

        demonstrate(adapter);
    }

    private static void demonstrate(Car car) {
        car.accelerator();
        car.speedUp(10);
        car.speedUp(30);
        car.speedUp(70);
        car.speedDown(50);
        car.brake();
    }

    interface MotorCycle {
        int speedUp(int speed);
        int speedDown(int speed);
        void go();
        void stop();
    }

    interface Car {
        int speedUp(int speed);
        int speedDown(int speed);
        void accelerator();
        void brake();
    }

    static class HondaMotorCycle implements MotorCycle {
        private int speed;
        private boolean isDrive;

        public HondaMotorCycle(int speed) {
            this.speed = speed;
            this.isDrive = false;
        }

        public int getSpeed() {
            return speed;
        }

        public boolean isDrive() {
            return isDrive;
        }

        @Override
        public int speedUp(int speed) {
            this.speed += speed;
            System.out.println("current motorcycle speed = " + speed);
            return this.speed;
        }

        @Override
        public int speedDown(int speed) {
            return speedUp(-speed);
        }

        @Override
        public void go() {
            this.isDrive = true;
            System.out.println("honda motorcycle go()");
            System.out.println("honda motorcycle speed = " + speed);
        }

        @Override
        public void stop() {
            this.isDrive = false;
            System.out.println("honda motorcycle stop()");
            System.out.println("honda motorcycle speed = " + speed);
        }
    }

    static class KiaCar implements Car {
        private int speed;
        private boolean isDrive;
        private int color;

        public KiaCar(int speed, int color) {
            this.speed = speed;
            this.isDrive = false;
            this.color = color;
        }

        public int getSpeed() {
            return speed;
        }

        public boolean isDrive() {
            return isDrive;
        }

        public int getColor() {
            return color;
        }

        @Override
        public int speedUp(int speed) {
            this.speed += speed;
            System.out.println("current car speed = " + speed);
            return this.speed;
        }

        @Override
        public int speedDown(int speed) {
            return speedUp(-speed);
        }

        @Override
        public void accelerator() {
            this.isDrive = true;
            System.out.println("kia car accelerator()");
            System.out.println("kia car speed = " + speed);
        }

        @Override
        public void brake() {
            this.isDrive = false;
            System.out.println("kia car brake()");
            System.out.println("kia car speed = " + speed);
        }
    }

    static class MotorCycleAdapter implements Car {
        private final MotorCycle cycle;

        public MotorCycleAdapter(MotorCycle cycle) {
            this.cycle = cycle;
        }

        @Override
        public int speedUp(int speed) {
            return cycle.speedUp(speed);
        }

        @Override
        public int speedDown(int speed) {
            return cycle.speedDown(speed);
        }

        @Override
        public void accelerator() {
            cycle.go();
        }

        @Override
        public void brake() {
            cycle.stop();
        }
    }
}
