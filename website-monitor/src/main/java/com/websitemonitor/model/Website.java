package com.websitemonitor.model;

import java.util.Date;

public class Website {
    private String websiteId;
    private String url;
    private Date lastChecked;
    private Date lastModified;
    private String lastContent;
    
    public Website(String websiteId, String url) {
        this.websiteId = websiteId;
        this.url = url;
        this.lastChecked = new Date();
        this.lastModified = new Date();
    }
    
    public boolean checkForUpdates() {
        // Mock implementation - in real system would fetch actual content
        System.out.println("Checking website: " + url);
        // Simulate random updates
        return Math.random() > 0.7;
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
}