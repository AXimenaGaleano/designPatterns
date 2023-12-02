package com.company;

public class PolicyCheckRequestHandler extends RequestHandler {

    @Override
    public void handleRequest(WebRequest webRequest) {

        if (!webRequest.getLoggedUser().isAdmin() && webRequest.getPath().equals("/dashboard")) {
            System.out.println("Status 403 : user is not authorized to access this content");
        } else {
            successor.handleRequest(webRequest);

        }

    }
}

/*
 * * 1.c - Implement a PolicyCheckRequestHandler() that checks that the User has
 * the right to access
 * the requested content. If not it produces the response for the webserver
 * (403), otherwise
 * it passes the request to the next handler()
 */
