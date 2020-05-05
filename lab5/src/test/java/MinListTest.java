import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.ershova.lab5.MinList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Anna
 */
public class MinListTest {
    private final double EPS = 1e-9;
    private static List<String> stringList;
    private static List<Integer> integerList;

    @BeforeClass
    public static void createList() {
        stringList = new LinkedList<>();
        integerList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            stringList.add("string " + i);
            integerList.add(10 - i);
        }
    }

    @Test
    public void paramsShouldBeCorrect() {
        Assert.assertEquals(true, MinList.isCorrectParam(1, 4, integerList.size()));
    }

    @Test
    public void paramsShouldBeIncorrect() {
        Assert.assertEquals(false, MinList.isCorrectParam(-1, 4, integerList.size()));
    }

    @Test
    public void minShouldBeEqual() {
        Assert.assertEquals(4, MinList.min(0, 7, integerList), EPS);
    }

    @Test
    public void minShouldBeNull() {
        Assert.assertEquals(null, MinList.min(0, 14, integerList));
    }

    @Test
    public void stringIsNotCompare() {
        Assert.assertEquals("string 0", MinList.min(0, 4, stringList));
    }
}
