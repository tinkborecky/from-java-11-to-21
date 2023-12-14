package example_01_vars;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * JDK11 (without lambda support in JDK 10)
 *
 * <p>In Java, var is used to declare a variable without specifying its type. The Java compiler
 * automatically determines the type based on the value assigned to the variable. This makes the
 * code cleaner and easier to read.
 *
 * <p>Note that var can only be used to declare local variables (i.e., variables declared inside a
 * method or a block), and the variable must be initialized at the time of declaration. It cannot be
 * used for method parameters, constructor parameters, method return types, fields, catch formals,
 * or any other kind of variable declaration.
 */
class VarExample {

    @Test
    void oldStyle() {
        String greeting = "Hello dark, sad world!";
        System.out.println(greeting);

        List<String> names = List.of("John", "Jane", "Tom", "Emily", "Alex");
        System.out.println(names);

        List<String> upperCaseNames =
                names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseNames);

        Map<String, Integer> map = Map.of("John", 25, "Jane", 30, "Tom", 35);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Age: " + entry.getValue());
        }
    }

    @Test
    void newStyle() {
        var greeting = "Hello new shiny world!";
        System.out.println(greeting);

        var names = List.of("John", "Jane", "Tom", "Emily", "Alex");
        System.out.println(names);

        var upperCaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseNames);

        var map = Map.of("John", 25, "Jane", 30, "Tom", 35);
        for (var entry : map.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Age: " + entry.getValue());
        }
    }
}
