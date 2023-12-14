package example_07_sealed_classes;

/**
 * JDK17 (preview JDK15)
 *
 * <p>Sealed classes and interfaces, introduced as a preview feature in Java 15 and standardized in
 * Java 17, allow you to restrict which other classes or interfaces may extend or implement them.
 */
public class SealedClassesExample {

    class OldShape {
    }

    final class OldCircle extends OldShape {
    }

    final class OldRectangle extends OldShape {
    }

    final class OldTriangle extends OldShape {
    }

    /**
     * ==================================================
     */
    sealed class Shape permits Circle, Rectangle {
    }

    final class Circle extends Shape {
    }

    non-sealed class Rectangle extends Shape {
    }

    //  final class Triangle extends Shape {}

    final class Square extends Rectangle {
    }
}
