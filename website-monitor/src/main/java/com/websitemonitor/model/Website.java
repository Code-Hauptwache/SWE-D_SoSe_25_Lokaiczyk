package com.websitemonitor.model;

import com.websitemonitor.observer.WebsiteSubject;
import com.websitemonitor.observer.WebsiteObserver;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Website implements WebsiteSubject {
    private String websiteId;
    private String url;
    private Date lastChecked;
    private Date lastModified;
    private String lastContent;
    private List<WebsiteObserver> observers;
    
    public Website(String websiteId, String url) {
        this.websiteId = websiteId;
        this.url = url;
        this.lastChecked = new Date();
        this.lastModified = new Date();
        this.observers = new ArrayList<>();
    }
    
    @Override
    public void attach(WebsiteObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer attached to " + url);
        }
    }
    
    @Override
    public void detach(WebsiteObserver observer) {
        observers.remove(observer);
        System.out.println("Observer detached from " + url);
    }
    
    @Override
    public void notifyObservers(String updateInfo) {
        for (WebsiteObserver observer : observers) {
            observer.onWebsiteUpdated(this, updateInfo);
        }
    }
    
    public boolean checkForUpdates() {
        // Mock implementation - in real system would fetch actual content
        System.out.println("Checking website: " + url);
        lastChecked = new Date();
        
        // Simulate random updates
        if (Math.random() > 0.7) {
            lastModified = new Date();
            String updateInfo = "Content updated at " + lastModified;
            notifyObservers(updateInfo);
            return true;
        }
        return false;
    }
    
    public String getContent() {
        // Mock implementation
        return "Mock content for " + url;
    }
    
    // Getters and setters
    public String getWebsiteId() {
        return websiteId;
    }
    
    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public Date getLastChecked() {
        return lastChecked;
    }
    
    public void setLastChecked(Date lastChecked) {
        this.lastChecked = lastChecked;
    }
    
    public Date getLastModified() {
        return lastModified;
    }
    
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    
    public String getLastContent() {
        return lastContent;
    }
    
    public void setLastContent(String lastContent) {
        this.lastContent = lastContent;
    }
    
    public List<WebsiteObserver> getObservers() {
        return new ArrayList<>(observers);
    }
}