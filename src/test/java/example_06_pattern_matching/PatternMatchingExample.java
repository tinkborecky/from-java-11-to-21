package example_06_pattern_matching;

import org.junit.jupiter.api.Test;

/**
 * JDK16 (preview JDK14)
 *
 * <p>Pattern matching for the instanceof operator was introduced as a preview feature in Java 14
 * and became a standard feature in Java 16. It allows you to test whether an object is an instance
 * of a particular type, and if so, to automatically cast it to that type within the scope of the
 * conditional block.
 */
class PatternMatchingExample {

    @Test
    void oldStyle() {
        Object o = new Point(2, 1);
        if (o instanceof Point) {
            Point point = (Point) o;
            System.out.println("x=" + point.x() + ", y=" + point.y());
        }
    }

    @Test
    void newStyle() {
        Object o = new Point(2, 1);
        if (o instanceof Point point) {
            System.out.println("x=" + point.x() + ", y=" + point.y());
        }
    }

    @Test
    void newStyle_withConditions() {
        Object o = new Point(2, 1);
        if (o instanceof Point point && point.x() == 2) {
            System.out.println("x=" + point.x() + ", y=" + point.y());
        }
    }

    @Test
    void newStyle_withThrowException() {
        Object o = new Point(2, 1);
        if (!(o instanceof Point point)) {
            throw new RuntimeException();
        }
        System.out.println("x=" + point.x() + ", y=" + point.y());
    }

    record Point(int x, int y) {
    }
}
