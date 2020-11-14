package com.decemberbi.tomcat.config;

import com.decemberbi.tomcat.common.DBCommonRequest;
import com.decemberbi.tomcat.common.DBCommonResponse;

public class DBSecondServlet extends DBServlet {

    @Override
    public void doGet(DBCommonRequest request, DBCommonResponse response) throws Exception {
        doPost(request, response);
    }

    @Override
    public void doPost(DBCommonRequest request, DBCommonResponse response) throws Exception {
        System.out.println("second servlet response");
        response.write("This is Second Servlet");
    }
}
