import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.ershova.lab7.TwoIterators;

import java.util.*;

/**
 * @author Anna
 */
public class TwoIteratorsTest {
    private static List<Integer> list1;
    private static List<Integer> list2;
    private static Set<Integer> set1;
    private static Set<Integer> emptySet;
    private static Set<Integer> resultSet;
    private static Iterator<Integer> iterator1;
    private static Iterator<Integer> iterator2;
    private static Iterator<Integer> iterator3;

    @BeforeClass
    public static void createList() {
        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
        set1 = new HashSet<>();
        emptySet = new LinkedHashSet<>();
        resultSet = new LinkedHashSet<>();

        list1.add(1); list2.add(1);
        list1.add(2); list2.add(2);
        list1.add(4); list2.add(4);
        list1.add(7); list2.add(7);
        list1.add(5); list2.add(5);
        list1.add(1); list2.add(1);

        set1.add(1);
        set1.add(7);
        set1.add(5);

        resultSet.add(2);
        resultSet.add(4);

        iterator1 = list1.iterator();
        iterator2 = list2.iterator();
        iterator3 = set1.iterator();
    }

    @Test
    public void iteratorShouldBeEmpty() {
        Assert.assertEquals(emptySet, TwoIterators.getDifference(iterator1, iterator2));
    }

    @Test
    public void iteratorShouldReturnValues() {
        Assert.assertEquals(resultSet, TwoIterators.getDifference(iterator1, iterator3));
    }
}
