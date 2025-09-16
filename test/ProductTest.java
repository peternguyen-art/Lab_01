import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    Product p1, p2, p3, p4;

    @BeforeEach
    void setUp() {
        p1 = new Product("Banana", "Yellow", "00000A", 3.25);
        p2 = new Product("Apple", "Red", "00000B", 2.50);
        p3 = new Product("Orange", "Orange", "00000C", 1.75);
        p4 = new Product("Blueberry", "Blue", "00000D", 4.00);
    }

    @Test
    void testConstructor() {
        assertEquals("Banana", p1.getName());
        assertEquals("Yellow", p1.getDescription());
        assertEquals("00000A", p1.getID());
        assertEquals(3.25, p1.getCost());
    }

    @Test
    void setName() {
        p1.setName("Mango");
        assertEquals("Mango", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Sweet Yellow");
        assertEquals("Sweet Yellow", p1.getDescription());
    }

    @Test
    void setID() {
        p1.setID("99999Z");
        assertEquals("99999Z", p1.getID());
    }

    @Test
    void setCost() {
        p1.setCost(5.50);
        assertEquals(5.50, p1.getCost());
    }

    @Test
    void toJSON() {
        String expected = "{" +
                "\"ID\": \"00000A\"," +
                "\"name\": \"Banana\"," +
                "\"description\": \"Yellow\"," +
                "\"price\": \"3.25\"," +
                "}";
        assertEquals(expected, p1.toJSON());
    }

    @Test
    void toXML() {
        String expected = "<Person>" +
                "<ID>00000A</ID>" +
                "<name>Banana</name>" +
                "<description>Yellow</description>" +
                "<price>3.25</price>" +
                "</Person>";
        assertEquals(expected, p1.toXML());
    }

    @Test
    void testEquals() {
        Product sameAsP1 = new Product("Banana", "Yellow", "00000A", 3.25);
        Product different = new Product("Apple", "Red", "00000B", 2.50);

        assertEquals(p1, sameAsP1);
        assertNotEquals(p1, different);
    }

    @Test
    void testHashCode() {
        Product sameAsP1 = new Product("Banana", "Yellow", "00000A", 3.25);
        assertEquals(p1.hashCode(), sameAsP1.hashCode());
    }
}
