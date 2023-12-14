package example_08_jdk21_improvements;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

class JDK21Improvements {

    /**
     * String Templates - extensible and safe String interpolation
     */
    @Test
    void stringTemplates() {
        var name = "Duke";
        var info = STR. "My name is \{ name }" ;
        System.out.println(info);
    }

    /**
     * It is common in some other programming languages (such as Scala and Python)
     * that we can skip naming a variable that we will not use in the future.
     * Now, since Java 21, we can use the unnamed/unused variables in Java as well.
     */
    @Test
    void unnamedPatternsAndVariables() {
        try {
            int number = Integer.parseInt("2");
        } catch (NumberFormatException _) { // ignore the exception object
            throw new IllegalStateException();
        }

        var _ = new Customer("", ""); // ignore the return value

        Object o = new Customer("John", "Chmielna 71");
        if (o instanceof Customer(String name, _)) {
            System.out.println("Customer name=" + name); // work with "name", ignore second parameter
        }
    }

    /**
     * Record Patterns for switch and instanceof to deconstruct complex nested structures
     */
    @Test
    void recordPatterns() {
        record Point2D(int x, int y) {
        }
        record ColoredPoint(Point2D point, Color color) {
        }

        Object o = new ColoredPoint(new Point2D(2, 2), Color.BLUE);

        if (o instanceof ColoredPoint(Point2D(int x, _), Color color)) {
            System.out.println("x=" + x);
            System.out.println("color=" + color);
        }

        switch (o) {
            case String s -> System.out.println(s.toLowerCase());
            case ColoredPoint(_, Color color) -> System.out.println(color);
            default -> {
            }
        }
    }

    /**
     * Pattern Matching for switch supporting type patterns and guarded patterns
     */
    @Test
    void patternMatchingForSwitch() {
        Object o = Integer.parseInt("2");
        switch (o) {
            case String s -> System.out.println(s.toLowerCase());
            case Integer i when i > 3 -> System.out.println(i * i);
            case Integer i -> System.out.println(i);
            default -> {
            }
        }

        switch (o) {
            case Integer i when i > 10 -> System.out.println("Integer is greater than 10");
            case String s when !s.isEmpty() -> System.out.println("String!");
            default -> System.out.println("Invalid Input");
        }
    }

    /**
     * <a href="https://belief-driven-design.com/looking-at-java-21-sequenced-collections-46c96/">more details</a>
     */
    @Test
    void sequencedCollections() {
        var names = List.of("John", "Jane", "Tom", "Emily", "Alex");
        System.out.println("List: " + names);
        System.out.println("List reversed: " + names.reversed());
        System.out.println("First element: " + names.getFirst());
        System.out.println("Last element: " + names.getLast());
    }

    record Customer(String name, String address) {
    }
}
