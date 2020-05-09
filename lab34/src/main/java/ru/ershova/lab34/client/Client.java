package ru.ershova.lab34.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Anna
 *
 * подключается к серверу
 */
public class Client {

    public static void main(String[] args) {
        new Client("localhost", 8000).run();
    }

    private final String host;
    private final int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class) // nIO сокет ввода вывода
                    .handler(new ClientInitializer()); // инициализация обработки сообщений

            Channel channel = bootstrap.connect(host, port).sync().channel(); // создать соединение с сервером
            BufferedReader in = new BufferedReader(new InputStreamReader((System.in))); // захват консоли ввода

            // разрыв соединения
            boolean breakTheConnection = false;
            String message;

            while (!breakTheConnection) { // принятие ввода и запись на сервер
                message = in.readLine();
                channel.writeAndFlush(message + "\r\n");
                if (message.equals("close")) {
                    breakTheConnection = true;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally { // после выхода из цикла отключить ELG
            group.shutdownGracefully();
        }
    }
}
