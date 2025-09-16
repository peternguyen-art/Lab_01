import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    Person p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp(){
        p1 = new Person("00000A", "Bob", "Tester 1", "Mr.", 1995);
        p2 = new Person("00000B", "Sally", "Tester 2", "Mr.", 1996);
        p3 = new Person("00000C", "Fred", "Tester 3", "Mr.", 1997);
        p4 = new Person("00000D", "Peter", "Nguyen", "Mr.", 1998);
        p5 = new  Person("00000F", "Dumble", "Tester 5", "Mr.", 1999);
        p6 = new Person("00000E", "Noa", "Tester 6", "Mr.", 2000);
    }

    @Test
    void testConstructor() {
        assertEquals("00000A", p1.getID());
        assertEquals("Bob", p1.getFirstName());
        assertEquals("Tester 1", p1.getLastName());
        assertEquals("Mr.", p1.getTitle());
        assertEquals(1995, p1.getYOB());
    }

    @Test
    void setID() {
        p1.setID("99999X");
        assertEquals("99999X", p1.getID());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Peter");
        assertEquals("Peter", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("TesterX");
        assertEquals("TesterX", p1.getLastName());
    }

    @Test
    void setTitle() {
        p1.setTitle("Dr.");
        assertEquals("Dr.", p1.getTitle());
    }

    @Test
    void setYOB() {
        p1.setYOB(2001);
        assertEquals(2001, p1.getYOB());
    }

    @Test
    void fullName() {
        assertEquals("Bob Tester 1", p1.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mr. Bob Tester 1", p1.formalName());
    }

    @Test
    void getAge() {
        int currentAge = p1.getAge();
        assertEquals(30, currentAge);
    }

    @Test
    void toCSV() {
        assertEquals("00000A, Bob, Tester 1, Mr., 1995", p1.toCSV());
    }

    @Test
    void toJSON() {
        String expected = "{" +
                "\"ID\": \"00000A\"," +
                "\"firstName\": \"Bob\"," +
                "\"lastName\": \"Tester 1\"," +
                "\"title\": \"Mr.\"," +
                "\"YOB\": 1995" +
                "}";
        assertEquals(expected, p1.toJSON());
    }

    @Test
    void toXML() {
        String expected = "<Person>" +
                "<ID>00000A</ID>" +
                "<firstName>Bob</firstName>" +
                "<lastName>Tester 1</lastName>" +
                "<title>Mr.</title>" +
                "<YOB>1995</YOB>" +
                "</Person>";
        assertEquals(expected, p1.toXML());
    }

    @Test
    void testToString() {
        String expected = "Person{ID='00000A', firstName='Bob', lastName='Tester 1', title='Mr.', YOB=1995}";
        assertEquals(expected, p1.toString());
    }

    @Test
    void testEquals() {
        Person sameAsP1 = new Person("00000A", "Bob", "Tester 1", "Mr.", 1995);
        Person different = new Person("12345", "Jane", "Smith", "Dr.", 2001);

        assertEquals(p1, sameAsP1);
        assertNotEquals(p1, different);
    }

    @Test
    void testHashCode() {
        Person sameAsP1 = new Person("00000A", "Bob", "Tester 1", "Mr.", 1995);
        assertEquals(p1.hashCode(), sameAsP1.hashCode());
    }
}
