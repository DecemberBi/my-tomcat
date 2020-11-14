package com.decemberbi.tomcat.common;

import java.io.OutputStream;

public class DBCommonResponse {

    private OutputStream out;

    public DBCommonResponse() {
    }

    public DBCommonResponse(OutputStream out) {
        this.out = out;
    }

    public void write(String s) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html;\n")
                .append("\r\n")
                .append(s);
        out.write(sb.toString().getBytes());
    }

}
