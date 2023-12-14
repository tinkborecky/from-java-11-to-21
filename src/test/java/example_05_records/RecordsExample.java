package example_05_records;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Objects;

/**
 * JDK16 (preview JDK14)
 *
 * <p>Records allows you to create immutable data classes. Currently, you need to e.g. create a
 * GrapeClass using the autogenerate functions of your IDE to generate constructor, getters,
 * hashCode, equals and toString or you can use Lombok for this purpose. In the end, you end up with
 * some boilerplate code, or you end up with a dependency on Lombok in your project.
 */
class RecordsExample {

    @Test
    void grapeOldPojo() {
        GrapeOldPojo grape1 = new GrapeOldPojo(Color.BLUE, 1);
        GrapeOldPojo grape2 = new GrapeOldPojo(Color.WHITE, 2);
        System.out.println("Grape 1 is " + grape1);
        System.out.println("Grape 2 is " + grape2);
        System.out.println("Grape 1 equals grape 2? " + grape1.equals(grape2));
        GrapeOldPojo grape1Copy = new GrapeOldPojo(grape1.getColor(), grape1.getNbrOfPits());
        System.out.println("Grape 1 equals its copy? " + grape1.equals(grape1Copy));
    }

    @Test
    void grapeLombokPojo() {
        GrapeLombokPojo grape1 = new GrapeLombokPojo(Color.BLUE, 1);
        GrapeLombokPojo grape2 = new GrapeLombokPojo(Color.WHITE, 2);
        System.out.println("Grape 1 is " + grape1);
        System.out.println("Grape 2 is " + grape2);
        System.out.println("Grape 1 equals grape 2? " + grape1.equals(grape2));
        GrapeLombokPojo grape1Copy = new GrapeLombokPojo(grape1.getColor(), grape1.getNbrOfPits());
        System.out.println("Grape 1 equals its copy? " + grape1.equals(grape1Copy));
    }

    @Test
    void grapeRecord() {
        GrapeRecord grape1 = new GrapeRecord(Color.BLUE, 1);
        GrapeRecord grape2 = new GrapeRecord(Color.WHITE, 2);
        System.out.println("Grape 1 is " + grape1);
        System.out.println("Grape 2 is " + grape2);
        System.out.println("Grape 1 equals grape 2? " + grape1.equals(grape2));
        GrapeRecord grape1Copy = new GrapeRecord(grape1.color(), grape1.nbrOfPits());
        System.out.println("Grape 1 equals its copy? " + grape1.equals(grape1Copy));
    }
}

class GrapeOldPojo {

    private final Color color;
    private final int nbrOfPits;

    public GrapeOldPojo(Color color, int nbrOfPits) {
        this.color = color;
        this.nbrOfPits = nbrOfPits;
    }

    public Color getColor() {
        return color;
    }

    public int getNbrOfPits() {
        return nbrOfPits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrapeOldPojo that = (GrapeOldPojo) o;
        return nbrOfPits == that.nbrOfPits && color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, nbrOfPits);
    }

    @Override
    public String toString() {
        return "GrapeClass{" + "color=" + color + ", nbrOfPits=" + nbrOfPits + '}';
    }
}

@Data
@RequiredArgsConstructor
class GrapeLombokPojo {
    private final Color color;
    private final int nbrOfPits;
}

record GrapeRecord(Color color, int nbrOfPits) {
}
