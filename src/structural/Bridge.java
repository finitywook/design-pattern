package structural;

/**
 * Bridge
 *
 * 브리지 패턴
 */
public class Bridge {

    public static void main(String[] args) {
        Color blue = new BlueColor();
        RedColor red = new RedColor();

        Car kiaBlue = new KiaCar(blue);
        Car kiaRed = new KiaCar(red);

        kiaBlue.information();
        kiaRed.information();

        Car hyundaiBlue = new HyundaiCar(blue);
        Car hyundaiRed = new HyundaiCar(red);

        hyundaiBlue.information();
        hyundaiRed.information();
    }

    static abstract class Car {
        protected Color color;

        public Car(Color color) {
            this.color = color;
        }

        public abstract void information();
    }

    static class HyundaiCar extends Car {
        public HyundaiCar(Color color) {
            super(color);
        }

        @Override
        public void information() {
            System.out.println("Hyundai Avante[Color:" + color.fill() + "]");
        }
    }

    static class KiaCar extends Car {
        public KiaCar(Color color) {
            super(color);
        }

        @Override
        public void information() {
            System.out.println("Kia K5[Color:" + color.fill() + "]");
        }
    }

    interface Color {
        String fill();
    }

    static class BlueColor implements Color {
        @Override
        public String fill() {
            return "blue";
        }
    }

    static class RedColor implements Color {
        @Override
        public String fill() {
            return "red";
        }
    }
}
