import org.junit.Assert;
import org.junit.Test;
import ru.ershova.lab26.Abbreviation;

/**
 * @author Anna
 */
public class AbbreviationTest {
    @Test
    public void stringShouldBeEmpty() {
        Assert.assertEquals("", Abbreviation.createAbbreviation("aaa aaa a "));
    }

    @Test
    public void stringShouldBeSPBPU() {
        Assert.assertEquals("СПБПУ", Abbreviation.createAbbreviation("Санкт-Петербургский Политехнический Университет"));
    }

    @Test
    public void stringShouldBeMVD() {
        Assert.assertEquals("МВД", Abbreviation.createAbbreviation("Министерство Внутренних Дел"));
    }

    @Test
    public void stringShouldBeSPBGTIPL() {
        Assert.assertEquals("СПБГТИПЛ", Abbreviation.createAbbreviation("Санкт-Петербургский Государственный Технический Институт им. Патриса Лумумбы"));
    }
}
