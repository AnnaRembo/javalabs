import org.junit.Assert;
import org.junit.Test;
import ru.ershova.lab25.ReverseString;

/**
 * @author Anna
 */
public class ReverseStringTest {

    @Test
    public void stringShouldNotReverse() {
        String string = new String("abc cba");
        Assert.assertEquals(string, ReverseString.reverseString(string));
    }

    @Test
    public void stringShouldBeReverse() {
        String stringForReverse = new String("1!dlrow olleH");
        String expString = new String("Hello world!1");
        Assert.assertEquals(expString, ReverseString.reverseString(stringForReverse));
    }

    @Test
    public void stringShouldBeEmpty() {
        Assert.assertEquals("", ReverseString.reverseString(""));
    }
}
