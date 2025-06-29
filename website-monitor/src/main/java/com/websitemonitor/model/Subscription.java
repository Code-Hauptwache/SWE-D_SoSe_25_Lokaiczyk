package com.websitemonitor.model;

import com.websitemonitor.observer.WebsiteObserver;
import com.websitemonitor.service.NotificationService;
import java.util.Date;

public class Subscription implements WebsiteObserver {
    private String subscriptionId;
    private User user;
    private Website website;
    private int frequency; // in minutes
    private String communicationChannel; // "email", "sms", etc.
    private boolean isActive;
    private Date createdDate;
    private NotificationService notificationService;
    
    public Subscription(String subscriptionId, User user, Website website, 
                       int frequency, String communicationChannel) {
        this.subscriptionId = subscriptionId;
        this.user = user;
        this.website = website;
        this.frequency = frequency;
        this.communicationChannel = communicationChannel;
        this.isActive = true;
        this.createdDate = new Date();
        this.notificationService = NotificationService.getInstance();
        
        // Register this subscription as observer to the website
        if (website != null) {
            website.attach(this);
        }
    }
    
    @Override
    public void onWebsiteUpdated(Website website, String updateInfo) {
        if (isActive && this.website.equals(website)) {
            System.out.println("Subscription " + subscriptionId + " notified of update: " + updateInfo);
            
            // Generate and send notification
            Notification notification = notificationService.generateNotification(this, updateInfo);
            notificationService.sendNotification(notification);
        }
    }
    
    public void modify(int newFrequency, String newChannel) {
        this.frequency = newFrequency;
        this.communicationChannel = newChannel;
    }
    
    public void cancel() {
        this.isActive = false;
        // Unsubscribe from website updates
        if (website != null) {
            website.detach(this);
        }
    }
    
    public void activate() {
        this.isActive = true;
        // Re-subscribe to website updates
        if (website != null) {
            website.attach(this);
        }
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
        // Detach from old website
        if (this.website != null) {
            this.website.detach(this);
        }
        
        this.website = website;
        
        // Attach to new website
        if (website != null && isActive) {
            website.attach(this);
        }
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