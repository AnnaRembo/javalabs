import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.ershova.lab4.Swap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Anna
 */
public class SwapTest {
    private static List<String> stringList;
    private static List<Integer> integerList;

    @BeforeClass
    public static void createList() {
        stringList = new LinkedList<>();
        integerList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            stringList.add("string " + i);
            integerList.add(i);
        }
    }

    @Test
    public void listShouldSwap() {
        Assert.assertNotEquals(stringList, Swap.swap(1, 4, stringList));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void indexOutOfRangeShouldThrowException() {
        Swap.swap(-1, 4, integerList);
    }
}
