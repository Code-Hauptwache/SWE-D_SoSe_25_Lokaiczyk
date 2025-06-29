package com.websitemonitor.observer;

public interface WebsiteSubject {
    void attach(WebsiteObserver observer);
    void detach(WebsiteObserver observer);
    void notifyObservers(String updateInfo);
}