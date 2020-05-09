import org.junit.Assert;
import org.junit.Test;
import ru.ershova.lab34.server.MessageHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anna
 */
public class MessageHandlerTest {

    @Test
    public void stringShouldBeSeparated() {
        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("Как");
        expectedSet.add("дела");
        Assert.assertEquals(expectedSet, MessageHandler.separateString("Как    ?:** дела?"));
    }

    @Test
    public void alisaShouldAnswer() {
        String message = MessageHandler.processString("какая сегодня погода?");
        switch (message) {
            case "какая?": Assert.assertEquals("какая?", message); break;
            case "сегодня?": Assert.assertEquals("сегодня?", message); break;
            case "погода?": Assert.assertEquals("погода?", message); break;
        }
    }

    @Test
    public void testAskAlisaByName() {
        Assert.assertEquals("Я Вас слушаю",MessageHandler.askAlisa("Алиса"));
    }

    @Test
    public void testAskAlisaEmptyString() {
        Assert.assertEquals("Не поняла, что Вы хотели",MessageHandler.askAlisa(""));
    }

    @Test
    public void testAskAlisaPersonal() {
        Assert.assertEquals("Я?",MessageHandler.askAlisa("ты"));
    }

}
