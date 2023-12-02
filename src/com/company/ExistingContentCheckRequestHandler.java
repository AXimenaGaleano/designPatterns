package com.company;

public class ExistingContentCheckRequestHandler extends RequestHandler {

    @Override
    public void handleRequest(WebRequest webRequest) {

        if (!webRequest.getPath().equals("/dashboard") && !webRequest.getPath().equals("/home")){
            System.out.println("Status 404 : Page missing");
        } else {
            successor.handleRequest(webRequest);
        }
    }
}

/*
 * 1.b - Implement a ExistingContentCheckRequestHandler which handles a
 * WebRequest, and checks
 * if the requested content (the path) is valid. If not, it produces the
 * response for the webserver (404)
 * otherwise it passes the request to the next handler
 */