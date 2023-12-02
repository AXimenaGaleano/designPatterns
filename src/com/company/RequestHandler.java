package com.company;

abstract class RequestHandler {

    protected RequestHandler successor;

    public void setSuccessor(RequestHandler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(WebRequest webRequest);
}

/*
 * 1.a - Make an abstract class RequestHandler, which will serve as the base
 * class
 * for handlers according to the Chain of Responsibility pattern.
 * It must have a handleRequest() method, and a successor member which is also a
 * RequestHandler
 */
