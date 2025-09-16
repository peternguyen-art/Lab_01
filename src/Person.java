import java.util.Calendar;
import java.util.Objects;

public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    /**
     * Constructs a new Person object.
     *
     * @param ID        The unique identifier for the person.
     * @param firstName The first name of the person.
     * @param lastName  The last name of the person.
     * @param title     The title of the person (e.g., Mr., Mrs., Dr.).
     * @param YOB       The year of birth of the person.
     */
    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    // Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    /**
     * Returns the full name of the person (first name followed by last name).
     *
     * @return The full name string.
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns the formal name of the person (title, first name, and last name).
     *
     * @return The formal name string.
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Calculates and returns the age of the person based on the current year.
     *
     * @return The age of the person.
     */
    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - YOB;
    }


    /**
     * Returns a comma-separated value (CSV) string representation of the Person object.
     *
     * @return The CSV string.
     */
    public String toCSV() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    /**
     * Returns a JSON string representation of the Person object.
     *
     * @return The JSON string.
     */
    public String toJSON() {
        return "{" +
                "\"ID\": \"" + this.ID + "\"," +
                "\"firstName\": \"" + this.firstName + "\"," +
                "\"lastName\": \"" + this.lastName + "\"," +
                "\"title\": \"" + this.title + "\"," +
                "\"YOB\": " + this.YOB +
                "}";
    }

    /**
     * Returns an XML string representation of the Person object.
     *
     * @return The XML string.
     */
    public String toXML() {
        return "<Person>" +
                "<ID>" + this.ID + "</ID>" +
                "<firstName>" + this.firstName + "</firstName>" +
                "<lastName>" + this.lastName + "</lastName>" +
                "<title>" + this.title + "</title>" +
                "<YOB>" + this.YOB + "</YOB>" +
                "</Person>";
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB &&
                ID.equals(person.ID) &&
                firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                title.equals(person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, title, YOB);
    }
}