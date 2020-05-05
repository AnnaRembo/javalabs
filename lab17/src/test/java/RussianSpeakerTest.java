import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.ershova.lab17.HelloSpeaker;
import ru.ershova.lab17.RussianSpeaker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Anna
 */
public class RussianSpeakerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void helloShouldBeRussian() {
        RussianSpeaker russianSpeaker = new RussianSpeaker();
        russianSpeaker.sayHello();
        Assert.assertEquals("Привет!", outContent.toString());
    }

    @Test
    public void helloShouldBeEnglish() {
        HelloSpeaker helloSpeaker = new HelloSpeaker();
        helloSpeaker.sayHello();
        Assert.assertEquals("Hello!", outContent.toString());
    }
}
