package com.company;

import java.util.ArrayList;

public class WebServer implements WebRequestObservable,Proxy {

    private RequestHandler requestHandler;
    private ArrayList<WebRequestObserver> observers;
    public WebServer(RequestHandler requestHandler){
        this.requestHandler=requestHandler;
        observers=new ArrayList<WebRequestObserver>();
    }
    public String getRequest(WebRequest webrequest) {
        requestHandler.handleRequest(webrequest);
        notifyObservers(webrequest);
        return "";
    }

    @Override
    public void attach(WebRequestObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(WebRequestObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(WebRequest webRequest) {
        for (WebRequestObserver observer: observers){
            observer.update(webRequest);
        }
    }
}

/*
 * 1.e - Modify WebServer, it should reference the first handler of the chain of
 * handlers,
 * and call the chain in its method getRequest().
 * You can create the instances of handlers and chain them in your Main, then
 * give the first handler
 * of the chain to the WebServer constructor
 */

/*
 * 2.a - Modify the WebServer so that it implements the WebRequestObservable
 * interface.
 * We should be able to register observers on the web server, and any web
 * request made to the web server should notify all the registered observers
 * with the WebRequest object.
 */