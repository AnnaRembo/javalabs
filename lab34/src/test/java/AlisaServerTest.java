import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.ershova.lab34.client.ClientInitializer;
import ru.ershova.lab34.server.AlisaServer;

/**
 * @author Anna
 */
public class AlisaServerTest {

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
    public void testConnectToAlice() {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientInitializer());

            bootstrap.connect(host, port).sync().channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
