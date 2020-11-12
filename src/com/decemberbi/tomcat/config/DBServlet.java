package com.decemberbi.tomcat.config;

import com.decemberbi.tomcat.common.DBRequest;
import com.decemberbi.tomcat.common.DBResponse;

public abstract class DBServlet {

    public void service(DBRequest request, DBResponse response) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    public abstract void doGet(DBRequest request, DBResponse response) throws Exception;

    public abstract void doPost(DBRequest request, DBResponse response) throws Exception;

}
