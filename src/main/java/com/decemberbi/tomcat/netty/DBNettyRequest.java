package com.decemberbi.tomcat.netty;

import com.decemberbi.tomcat.common.DBCommonRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;


public class DBNettyRequest extends DBCommonRequest {

    private ChannelHandlerContext  ctx;

    private HttpRequest req;

    public DBNettyRequest(ChannelHandlerContext  ctx, HttpRequest req) {
        super();
        this.ctx = ctx;
        this.req = req;
    }

    public String getMethod() {
        return req.method().name();
    }

    public String getUrl() {
        return req.uri();
    }

    public Map<String, List<String>> getParameters() {
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(req.uri());
        return queryStringDecoder.parameters();
    }

    public String getParameter(String name) {
        Map<String, List<String>> parameters = getParameters();
        List<String> param = parameters.get(name);
        if (null == param) {
            return null;
        } else {
            return param.get(0);
        }
    }

}
