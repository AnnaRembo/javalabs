import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.ershova.lab11.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anna
 */
public class PersonTest {
    private static Person person;
    private static List<Person> personListUnsort;
    private static List<Person> personListSort;

    @BeforeClass
    public static void createPerson() {
        person = new Person("TestName", "TestSurname", 10);

        personListUnsort = new ArrayList<>();
        personListUnsort.add(new Person("Bb", "Cc", 10));
        personListUnsort.add(new Person("Ba", "Cc", 20));
        personListUnsort.add(new Person("Ba", "Ac", 20));
        personListUnsort.add(new Person("Aa", "Aa", 10));
        personListUnsort.add(new Person("Aa", "Aa", 15));

        personListSort = new ArrayList<>();
        personListSort.add(new Person("Aa", "Aa", 10));
        personListSort.add(new Person("Aa", "Aa", 15));
        personListSort.add(new Person("Ba", "Ac", 20));
        personListSort.add(new Person("Ba", "Cc", 20));
        personListSort.add(new Person("Bb", "Cc", 10));
    }

    @Test
    public void getNameShouldReturnValue() {
        Assert.assertEquals("TestName", person.getName());
    }

    @Test
    public void getSurnameShouldReturnValue() {
        Assert.assertEquals("TestSurname", person.getSurname());
    }

    @Test
    public void getAgeShouldReturnValue() {
        Assert.assertEquals(10, person.getAge());
    }

    @Test
    public void personToString() {
        Assert.assertEquals("Person{name='TestName', surname='TestSurname', age=10}", person.toString());
    }

    @Test
    public void personShouldBeSorting() {
        Collections.sort(personListUnsort);
        Assert.assertEquals(personListSort.toString(), personListUnsort.toString());
    }

}
