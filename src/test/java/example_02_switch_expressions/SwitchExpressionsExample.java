package example_02_switch_expressions;

import org.junit.jupiter.api.Test;

/**
 * JDK14 (preview JDK12)
 *
 * <p>They allow the switch statement to be used as either a statement or an expression. Switch
 * expressions can return a value.
 *
 * <p>The yield keyword in Java is used with switch expressions. The yield statement allows you to
 * return a value from a block in a switch expression. It can only be used within a switch
 * expression, not in other contexts.
 */
class SwitchExpressionsExample {

    @Test
    void oldStyleWithoutBreaks() {
        Fruit fruit = Fruit.APPLE;
        switch (fruit) {
            case APPLE, PEAR:
                System.out.println("Common fruit");
            case ORANGE, AVOCADO:
                System.out.println("Exotic fruit");
            default:
                System.out.println("Undefined fruit");
        }
    }

    @Test
    void oldStyleWithBreaks() {
        Fruit fruit = Fruit.APPLE;
        switch (fruit) {
            case APPLE, PEAR:
                System.out.println("Common fruit");
                break;
            case ORANGE, AVOCADO:
                System.out.println("Exotic fruit");
                break;
            default:
                System.out.println("Undefined fruit");
        }
    }

    @Test
    void newStyle_usingSwitchExpressions() {
        Fruit fruit = Fruit.APPLE;
        switch (fruit) {
            case APPLE, PEAR -> System.out.println("Common fruit");
            case ORANGE, AVOCADO -> System.out.println("Exotic fruit");
            default -> System.out.println("Undefined fruit");
        }
    }

    @Test
    void newStyle_usingSwitchExpressions_withYield() {
        Fruit fruit = Fruit.APPLE;
        var value =
                switch (fruit) {
                    case APPLE -> {
                        System.out.println("The given fruit was: " + fruit);
                        yield fruit.toString().length();
                    }
                    case ORANGE, AVOCADO -> 7;
                    default -> 6;
                };
        System.out.println(value);
    }

    enum Fruit {
        APPLE,
        PEAR,
        ORANGE,
        AVOCADO
    }
}
