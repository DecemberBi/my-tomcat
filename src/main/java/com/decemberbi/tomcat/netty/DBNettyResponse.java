package com.decemberbi.tomcat.netty;

import com.decemberbi.tomcat.common.DBCommonResponse;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class DBNettyResponse extends DBCommonResponse {

    private ChannelHandlerContext  ctx;

    private HttpRequest req;

    public DBNettyResponse(ChannelHandlerContext ctx, HttpRequest req) {
        super();
        this.ctx = ctx;
        this.req = req;
    }

    public void write(String s) throws Exception {
        try {
            if (s == null || s.length() == 0) {
                return;
            }

            DefaultFullHttpResponse response = new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,
                    Unpooled.wrappedBuffer(s.getBytes("UTF-8"))
            );
            response.headers().set("Content-Type", "text/html");
            ctx.write(response);
        } finally {
            ctx.flush();
            ctx.close();
        }
    }

}
