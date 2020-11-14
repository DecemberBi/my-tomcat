package com.decemberbi.tomcat.config;

import com.decemberbi.tomcat.common.DBCommonRequest;
import com.decemberbi.tomcat.common.DBCommonResponse;

public abstract class DBServlet {

    public void service(DBCommonRequest request, DBCommonResponse response) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    public abstract void doGet(DBCommonRequest request, DBCommonResponse response) throws Exception;

    public abstract void doPost(DBCommonRequest request, DBCommonResponse response) throws Exception;

}
