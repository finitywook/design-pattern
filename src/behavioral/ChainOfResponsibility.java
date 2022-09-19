package behavioral;

/**
 * Chain Of Responsibility
 *
 * 책임 연쇄
 */
public class ChainOfResponsibility {

    public static void main(String[] args) {
        Motor motor = new Motor();
        Navigator navigator = new Navigator();
        Car car = new Car();

        motor.setNextChain(navigator);
        navigator.setNextChain(car);

        motor.chain();
    }

    interface Chain {
        void chain();
        void setNextChain(Chain chain);
    }

    interface Part {
        void boot();
    }

    static class Motor implements Chain, Part {
        private Chain chain;

        @Override
        public void chain() {
            boot();

            if(chain != null) {
                chain.chain();
            }
        }

        @Override
        public void setNextChain(Chain chain) {
            this.chain = chain;
        }

        @Override
        public void boot() {
            System.out.println("motor boot success!");
        }
    }

    static class Navigator implements Chain, Part {
        private Chain chain;

        @Override
        public void chain() {
            boot();

            if(chain != null) {
                chain.chain();
            }
        }

        @Override
        public void setNextChain(Chain chain) {
            this.chain = chain;
        }

        @Override
        public void boot() {
            System.out.println("navigator boot success!");
        }
    }

    static class Car implements Chain, Part {
        private Chain chain;

        @Override
        public void chain() {
            boot();

            if(chain != null) {
                chain.chain();
            }
        }

        @Override
        public void setNextChain(Chain chain) {
            this.chain = chain;
        }

        @Override
        public void boot() {
            System.out.println("car boot success!");
        }
    }
}
