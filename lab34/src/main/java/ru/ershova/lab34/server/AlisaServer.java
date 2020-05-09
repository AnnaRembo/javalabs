package ru.ershova.lab34.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * @author Anna
 *
 * прослушивает входящие соединения и передает их для обработки
 */
public class AlisaServer {

    public static void main(String[] args) {
        new AlisaServer(8000).run();
    }

    private final int port;

    public AlisaServer(int port) {
        this.port = port;
    }

    public void run() {
        // nIO группа boss принимает входящие соединения, когда они прибывают, и передает рабочей группе на обработку
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        // аналогично клиенту, обработку входящих соединений определяет ServerBootstrap
        try {
            ServerBootstrap bootstrap = new ServerBootstrap()
                    .group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // IO сокет для связи
                    .childHandler(new AlisaServerInitializer()); // инициализация обработки входящих сообщений

            // слушать порт входящих соединений
            bootstrap.bind(port).sync().channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally { // очистить ELG
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
