import org.junit.Assert;
import org.junit.Test;
import ru.ershova.lab6.Computer;

/**
 * @author Anna
 */
public class ComputerTest {
    private final double EPS = 1e-9;

    @Test
    public void sumShouldBeNegative() {
        Computer computer = new Computer();
        Assert.assertEquals(-5, computer.summ(-3, -2), EPS);
    }

    @Test
    public void sumShouldBePositive() {
        Computer computer = new Computer();
        Assert.assertEquals(5, computer.summ(3, 2), EPS);
    }
}
