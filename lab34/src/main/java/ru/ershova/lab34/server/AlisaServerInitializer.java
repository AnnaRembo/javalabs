package ru.ershova.lab34.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author Anna
 *
 * инициализация канала сокета сервера
 */
public class AlisaServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        // ожидать кадры не более 8192, каждый из которых ограничен окончанием строки
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        // байты в строки
        pipeline.addLast("decoder", new StringDecoder());
        // строки в байты
        pipeline.addLast("encoder", new StringEncoder());

        // определить класс, который обрабатывает все декодированные входящие строки Клиента
        pipeline.addLast("handler", new AlisaServerHandler());
    }
}
