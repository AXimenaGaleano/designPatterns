package com.company;

public class RenderContentHandler extends RequestHandler {

    @Override
    public void handleRequest(WebRequest webRequest) {

        if (webRequest.getLoggedUser().isAdmin() && webRequest.getPath().equals("/dashboard")) {
            System.out.println("Status 200 : Dashboard content here");
        }
        else if (!webRequest.getLoggedUser().isAdmin() && webRequest.getPath().equals("/home")) {
            System.out.println("Status 200 : Home content here");

        } else {
            successor.handleRequest(webRequest);
        }

    }
}

/*
 * * 1.d - Implement a RenderContentHandler() which renders the content for the
 * WebRequest (200)
 */
