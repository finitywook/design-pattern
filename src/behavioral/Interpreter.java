package behavioral;

/**
 * Interpreter
 *
 * 인터프리터 패턴
 */
public class Interpreter {

    public static void main(String[] args) {
        TerminalExpression ryu = new TerminalExpression("Ryu");
        TerminalExpression wook = new TerminalExpression("Wook");

        OrExpression expression1 = new OrExpression(ryu, wook);
        AndExpression expression2 = new AndExpression(ryu, wook);

        System.out.println("expression1.interpreter(\"Wook\") = " + expression1.interpreter("Wook"));
        System.out.println("expression2.interpreter(\"Wook\") = " + expression2.interpreter("Wook"));
        System.out.println("expression2.interpreter(\"Ryu Han-Wook\") = " + expression2.interpreter("Ryu Han-Wook"));
    }

    interface Expression {
        boolean interpreter(String context);
    }

    static class TerminalExpression implements Expression {
        private final String data;

        public TerminalExpression(String data) {
            this.data = data;
        }

        @Override
        public boolean interpreter(String context) {
            return context.contains(data);
        }
    }

    static class AndExpression implements Expression {
        private final Expression expression1;
        private final Expression expression2;

        public AndExpression(Expression expression1, Expression expression2) {
            this.expression1 = expression1;
            this.expression2 = expression2;
        }

        @Override
        public boolean interpreter(String context) {
            return expression1.interpreter(context) && expression2.interpreter(context);
        }
    }

    static class OrExpression implements Expression {
        private final Expression expression1;
        private final Expression expression2;

        public OrExpression(Expression expression1, Expression expression2) {
            this.expression1 = expression1;
            this.expression2 = expression2;
        }

        @Override
        public boolean interpreter(String context) {
            return expression1.interpreter(context) || expression2.interpreter(context);
        }
    }
}
