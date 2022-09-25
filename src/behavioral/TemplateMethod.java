package behavioral;

/**
 * Template Method
 *
 * 템플릿 메서드 패턴
 */
public class TemplateMethod {

    public static void main(String[] args) {
        K5 k5 = new K5();
        k5.autoDrive("서울시 구로구 오류동");

        Avante avante = new Avante();
        avante.autoDrive("경기도 부천시");
    }

    static abstract class Car {
        public void autoDrive(String dest) {

            System.out.println("도착지 [" + dest + "] 로 주행을 시작합니다.");
            move();
            System.out.println("도착지 [" + dest + "] 에 도착하였습니다.");
        }
        protected abstract void move();
    }

    static class K5 extends Car {
        @Override
        protected void move() {
            System.out.println("K5가 움직입니다.");
        }
    }

    static class Avante extends Car {
        @Override
        protected void move() {
            System.out.println("아반떼가 움직입니다.");
        }
    }
}
