package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.rmi.server.LogStream.log;

public class WebServiceProxy implements Proxy {

    static String filePath;
    private WebServer webServer;


    public WebServiceProxy(String filePath,WebServer webServer) {
        this.filePath = filePath;
        this.webServer=webServer;
        try {
            Files.deleteIfExists(Paths.get(this.filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void log(String msg) {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(filePath, true));
            out.println(msg);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    static String msg1 = "Request made to ";
    static String msg2;
    static String msg;


    @Override
    public String getRequest(WebRequest webRequest) {

        if (webRequest.getLoggedUser().isAdmin()) {
            msg2 = " by admin user";
        } else {
            msg2 = " by non admin user";
        }
        msg = msg1 + webRequest.getPath() + msg2;
        log(msg);
        return webServer.getRequest(webRequest);
    }
}

