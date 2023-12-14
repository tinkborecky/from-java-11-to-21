package example_03_text_blocks;

import org.junit.jupiter.api.Test;

/**
 * JDK15 (preview JDK13)
 *
 * <p>Text blocks are delimited by three double quote characters """ at the start and at the end.
 * All the content between the delimiters is part of the string literal, including newlines and
 * leading spaces.
 */
class TextBlocksExample {

    @Test
    void oldStyle() {
        String text =
                "{\n"
                        + "  \"name\": \"John Doe\",\n"
                        + "  \"age\": 45,\n"
                        + "  \"address\": \"Doe Street, 23, Java Town\"\n"
                        + "}";
        System.out.println(text);
    }

    @Test
    void newStyle() {
        String text =
                """
                        {
                          "name": "John Doe",
                          "age": 45,
                          "address": "Doe Street, 23, Java Town"
                        }
                        """;
        System.out.println(text);
    }
}
