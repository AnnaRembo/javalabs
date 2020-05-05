import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.ershova.lab24.Car;

/**
 * @author Anna
 */
public class CarTest {
    private final double EPS = 1e-9;
    public static Car car;
    @BeforeClass
    public static void carInit() {
        car = new Car(240, 120);
    }

    @Test
    public void carDistanceShouldBeReturned() {
        Assert.assertEquals(240, car.getDistance(), EPS);
    }

    @Test
    public void carTimeShouldBeReturned() {
        Assert.assertEquals(120, car.getTime(), EPS);
    }

    @Test
    public void testCalculateSpeed() {
        Assert.assertEquals(120, car.calculateSpeed(car.getDistance(), car.getTime()), EPS);
    }

    @Test
    public void testCarTeleport() {
        Assert.assertEquals(240, car.calculateSpeed(car.getDistance(), 0), EPS);
    }

    // отрицательная скорость - скорость удаления
    @Test
    public void testCarRemovalRate() {
        Assert.assertEquals(-120, car.calculateSpeed(-car.getDistance(), car.getTime()), EPS);
    }
}
