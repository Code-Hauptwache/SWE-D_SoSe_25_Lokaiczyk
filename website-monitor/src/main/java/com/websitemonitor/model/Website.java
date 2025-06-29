package com.websitemonitor.model;

import com.websitemonitor.observer.WebsiteSubject;
import com.websitemonitor.observer.WebsiteObserver;
import com.websitemonitor.strategy.ComparisonStrategy;
import com.websitemonitor.strategy.ContentSizeStrategy;
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
    private ComparisonStrategy comparisonStrategy;
    
    public Website(String websiteId, String url) {
        this.websiteId = websiteId;
        this.url = url;
        this.lastChecked = new Date();
        this.lastModified = new Date();
        this.observers = new ArrayList<>();
        this.comparisonStrategy = new ContentSizeStrategy(); // Default strategy
        this.lastContent = ""; // Initialize with empty content
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
        System.out.println("Checking website: " + url + " using " + comparisonStrategy.getStrategyName());
        lastChecked = new Date();
        
        // Mock implementation - simulate fetching new content
        String newContent = fetchContent();
        
        // Use strategy to compare content
        boolean hasChanged = comparisonStrategy.hasChanged(lastContent, newContent);
        
        if (hasChanged) {
            lastModified = new Date();
            lastContent = newContent;
            String updateInfo = "Content updated at " + lastModified + " (detected by " + 
                              comparisonStrategy.getStrategyName() + ")";
            notifyObservers(updateInfo);
            return true;
        }
        
        return false;
    }
    
    private String fetchContent() {
        // Mock implementation - simulate different content scenarios
        double random = Math.random();
        
        if (random > 0.7) {
            // 30% chance of content change
            return "<html><body><h1>Updated Content</h1><p>New text at " + 
                   new Date().getTime() + "</p></body></html>";
        } else if (random > 0.5) {
            // 20% chance of only size change
            return lastContent + " ";
        } else {
            // 50% chance of no change
            return lastContent;
        }
    }
    
    public String getContent() {
        return lastContent;
    }
    
    // Strategy pattern methods
    public void setComparisonStrategy(ComparisonStrategy strategy) {
        this.comparisonStrategy = strategy;
        System.out.println("Changed comparison strategy for " + url + " to " + strategy.getStrategyName());
    }
    
    public ComparisonStrategy getComparisonStrategy() {
        return comparisonStrategy;
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