import org.junit.Assert;
import org.junit.Test;
import ru.ershova.lab8.PairedCharacters;

/**
 * @author Anna
 */
public class PairedCharactersTest {
    @Test
    public void stringShouldBeEmpty() {
        Assert.assertEquals("", PairedCharacters.removePairCharacters(""));
    }

    @Test
    public void stringShouldNotChange() {
        Assert.assertEquals("123asdf1234Aa a", PairedCharacters.removePairCharacters("123asdf1234Aa a"));
    }

    @Test
    public void stringShouldChange() {
        Assert.assertEquals("Hi  world", PairedCharacters.removePairCharacters("aaHeeeei assa worllld"));
    }
}
