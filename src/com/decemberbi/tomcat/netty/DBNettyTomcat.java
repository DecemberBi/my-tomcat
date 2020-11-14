package com.decemberbi.tomcat.netty;

import com.decemberbi.tomcat.common.DBRequest;
import com.decemberbi.tomcat.common.DBResponse;
import com.decemberbi.tomcat.config.DBServlet;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DBNettyTomcat {

    private final int port = 8080;
    private ServerSocket serverSocket;
    private Map<String, DBServlet> servletMapping = new HashMap<>();

    private Properties webXml = new Properties();

    public void start() {

        init();

        try {
            System.out.println("my dbnetty tomcat start at port:" + this.port);
            /**
             * 这里替换成netty进行网络通信
             */
            /*serverSocket = new ServerSocket(this.port);
            while (true) {
                Socket socket = serverSocket.accept();
                process(socket);
            }*/
//            EventLoopGroup
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        try {
            String WEB_INF = this.getClass().getResource("/").getPath();
            FileInputStream fis = new FileInputStream(WEB_INF + "resource/web.properties");
            webXml.load(fis);

            for (Object k : webXml.keySet()) {
                String key = k.toString();
                if (key.endsWith(".url")) {
                    String servletName = key.replaceAll("\\.url$", "");
                    String url = webXml.getProperty(key);
                    String className = webXml.getProperty(servletName + ".className");

                    DBServlet servlet = (DBServlet) Class.forName(className).getDeclaredConstructor().newInstance();
                    servletMapping.put(url, servlet);
                }
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(Socket socket) throws Exception {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        DBRequest request = new DBRequest(inputStream);
        DBResponse response = new DBResponse(outputStream);

        String url = request.getUrl();
        if (servletMapping.containsKey(url)) {
            servletMapping.get(url).service(request, response);
        } else {
            response.write("404 - Not Found");
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();
        socket.close();
    }

}
