import org.junit.BeforeClass;
import org.junit.Test;
import ru.ershova.lab34.client.Client;
import ru.ershova.lab34.server.AlisaServer;

/**
 * @author Anna
 */
public class ClientTest {
    private static String host = "localhost";
    private static int port = 8800;

    @BeforeClass
    public static void initServer() {
        Thread thread = new Thread(() -> {
            new AlisaServer(port).run();
        }
        );
        thread.start();
    }

    @Test
    public void testConnectClient() throws InterruptedException {
        Thread thread2 = new Thread(() -> {
            new Client(host, port).run();
        }
        );
        thread2.start();

        Thread.sleep(1000);
    }
}
