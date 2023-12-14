package example_04_npe_descriptions;

import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * JDK15 (Enabled with -XX:+ShowCodeDetailsInExceptionMessages in JDK 14)
 *
 * <p>Starting from JDK 14, the NullPointerExceptions in Java have been enhanced to provide
 * descriptive messages that can help in understanding the cause of the exception.
 */
class NpeDescriptionExample {

    @Test
    void npeHelpfulDescriptions_example1() {
        Person person = new Person();
        System.out.println(person.getAddress().getStreet());
    }

    @Test
    void npeHelpfulDescriptions_example2() {
        Person person = new Person();
        Address address = new Address();
        address.setStreet("Chmielna");
        person.setAddress(address);

        System.out.println(person.getAddress().getStreet());
        System.out.println(person.getAddress().getCity().getName());
    }

    @Data
    class Person {
        private Address address;
    }

    @Data
    class Address {
        private String street;
        private City city;
    }

    @Data
    class City {
        private String postalCode;
        private String name;
    }
}
