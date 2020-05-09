package ru.ershova.lab34.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static ru.ershova.lab34.server.MessageHandler.processString;

/**
 * @author Anna

 * обрабатывает входящие подключения к серверу
 * возвращает клиенту ответ в стиле Fallout 4
 */
public class AlisaServerHandler extends SimpleChannelInboundHandler<String> {
    // список клиентов
    private static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    // при новом подключении к серверу
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();

        System.out.println("[SERVER MESSAGE " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + "] " + incoming.remoteAddress() + " присоединился\n");

        incoming.writeAndFlush("[Алиса (" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + ")]: Добро пожаловать в сеть \"РОБКО Индастриз (ТМ)\"\n");

        // добавить в список клиентов
        channels.add(ctx.channel());
    }

    // при отключении клиента
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();

        System.out.println("[SERVER MESSAGE " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + "] " + incoming.remoteAddress() + " покинул сервер\n");

        // убрать из списка клиентов
        channels.remove(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String message) throws Exception {
        // отправитель сообщения
        Channel incoming = channelHandlerContext.channel();

        // обработка сообщения
        String answer = processString(message);

        incoming.writeAndFlush("[Алиса (" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + ")]: " + answer + "\n");
    }
}
