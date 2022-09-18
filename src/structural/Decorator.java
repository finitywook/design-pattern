package structural;

/**
 * Decorator
 *
 * 데코레이터 패턴
 */
public class Decorator {

    public static void main(String[] args) {
        Navigator navigator = new LeftDecorator(
                new RightDecorator(
                        new LeftDecorator(
                                new LeftDecorator(
                                        new SearchNavigator()
                                )
                        )
                )
        );

        navigator.route();
    }

    interface Navigator {
        void route();
    }

    static class SearchNavigator implements Navigator {
        @Override
        public void route() {
            System.out.println("도착지 도착");
        }
    }

    static abstract class NavigatorDecorator implements Navigator {
        private final Navigator decorator;

        public NavigatorDecorator(Navigator decorator) {
            this.decorator = decorator;
        }

        @Override
        public void route() {
            decorator.route();
        }
    }

    static class LeftDecorator extends NavigatorDecorator {
        public LeftDecorator(Navigator decorator) {
            super(decorator);
        }

        @Override
        public void route() {
            left();
            super.route();
        }

        private void left() {
            System.out.println("좌회전");
        }
    }

    static class RightDecorator extends NavigatorDecorator {
        public RightDecorator(Navigator decorator) {
            super(decorator);
        }

        @Override
        public void route() {
            right();
            super.route();
        }

        private void right() {
            System.out.println("우회전");
        }
    }
}
