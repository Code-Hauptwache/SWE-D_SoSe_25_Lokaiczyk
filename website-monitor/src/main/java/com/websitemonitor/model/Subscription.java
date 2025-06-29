package com.websitemonitor.model;

import java.util.Date;

public class Subscription {
    private String subscriptionId;
    private User user;
    private Website website;
    private int frequency; // in minutes
    private String communicationChannel; // "email", "sms", etc.
    private boolean isActive;
    private Date createdDate;
    
    public Subscription(String subscriptionId, User user, Website website, 
                       int frequency, String communicationChannel) {
        this.subscriptionId = subscriptionId;
        this.user = user;
        this.website = website;
        this.frequency = frequency;
        this.communicationChannel = communicationChannel;
        this.isActive = true;
        this.createdDate = new Date();
    }
    
    public void modify(int newFrequency, String newChannel) {
        this.frequency = newFrequency;
        this.communicationChannel = newChannel;
    }
    
    public void cancel() {
        this.isActive = false;
    }
    
    public void activate() {
        this.isActive = true;
    }
    
    // Getters and setters
    public String getSubscriptionId() {
        return subscriptionId;
    }
    
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Website getWebsite() {
        return website;
    }
    
    public void setWebsite(Website website) {
        this.website = website;
    }
    
    public int getFrequency() {
        return frequency;
    }
    
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    
    public String getCommunicationChannel() {
        return communicationChannel;
    }
    
    public void setCommunicationChannel(String communicationChannel) {
        this.communicationChannel = communicationChannel;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean active) {
        isActive = active;
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}