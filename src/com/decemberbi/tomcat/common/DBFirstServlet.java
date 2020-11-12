package com.decemberbi.tomcat.common;

import com.decemberbi.tomcat.config.DBServlet;

public class DBFirstServlet extends DBServlet {

    @Override
    public void doGet(DBRequest request, DBResponse response) throws Exception {
        doPost(request, response);
    }

    @Override
    public void doPost(DBRequest request, DBResponse response) throws Exception {
        System.out.println("first servlet response");
        response.write("This is First Servlet");
    }
}
