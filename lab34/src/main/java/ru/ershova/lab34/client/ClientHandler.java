package ru.ershova.lab34.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Anna
 *
 * обрабатывает входящие объекты - строки
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) {
        // печать полученного с сервера сообщения
        System.out.println(s);
    }
}
