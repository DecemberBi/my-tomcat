package com.decemberbi.tomcat.common;

import com.decemberbi.tomcat.config.DBServlet;

public class DBSecondServlet extends DBServlet {

    @Override
    public void doGet(DBRequest request, DBResponse response) throws Exception {
        doPost(request, response);
    }

    @Override
    public void doPost(DBRequest request, DBResponse response) throws Exception {
        response.write("This is Second Servlet");
    }
}
