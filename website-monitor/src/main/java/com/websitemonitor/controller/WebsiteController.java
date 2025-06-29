package com.websitemonitor.controller;

import com.websitemonitor.model.*;
import com.websitemonitor.service.MonitoringService;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WebsiteController {
    private Map<String, User> users;
    private Map<String, Website> websites;
    private Map<String, Subscription> subscriptions;
    private MonitoringService monitoringService;
    
    public WebsiteController() {
        this.users = new HashMap<>();
        this.websites = new HashMap<>();
        this.subscriptions = new HashMap<>();
        this.monitoringService = new MonitoringService();
    }
    
    public Subscription createSubscription(User user, String url, int frequency, String channel) {
        // Check if website already exists
        Website website = findOrCreateWebsite(url);
        
        // Create subscription
        String subscriptionId = UUID.randomUUID().toString();
        Subscription subscription = new Subscription(subscriptionId, user, website, frequency, channel);
        
        subscriptions.put(subscriptionId, subscription);
        monitoringService.addSubscription(subscription);
        
        System.out.println("Created subscription for user " + user.getUsername() + 
                          " to monitor " + url);
        
        return subscription;
    }
    
    public void modifySubscription(String subscriptionId, int newFrequency, String newChannel) {
        Subscription subscription = subscriptions.get(subscriptionId);
        if (subscription != null) {
            subscription.modify(newFrequency, newChannel);
            System.out.println("Modified subscription " + subscriptionId);
        }
    }
    
    public void cancelSubscription(String subscriptionId) {
        Subscription subscription = subscriptions.get(subscriptionId);
        if (subscription != null) {
            subscription.cancel();
            System.out.println("Cancelled subscription " + subscriptionId);
        }
    }
    
    public void handleUserRequest(String action, Map<String, Object> params) {
        switch (action) {
            case "create":
                User user = (User) params.get("user");
                String url = (String) params.get("url");
                int frequency = (int) params.get("frequency");
                String channel = (String) params.get("channel");
                createSubscription(user, url, frequency, channel);
                break;
            case "modify":
                String subId = (String) params.get("subscriptionId");
                int newFreq = (int) params.get("frequency");
                String newChan = (String) params.get("channel");
                modifySubscription(subId, newFreq, newChan);
                break;
            case "cancel":
                String cancelId = (String) params.get("subscriptionId");
                cancelSubscription(cancelId);
                break;
            default:
                System.out.println("Unknown action: " + action);
        }
    }
    
    public void manageSubscriptions() {
        System.out.println("Managing " + subscriptions.size() + " subscriptions");
        monitoringService.periodicCheck();
    }
    
    private Website findOrCreateWebsite(String url) {
        for (Website website : websites.values()) {
            if (website.getUrl().equals(url)) {
                return website;
            }
        }
        
        // Create new website
        String websiteId = UUID.randomUUID().toString();
        Website website = new Website(websiteId, url);
        websites.put(websiteId, website);
        return website;
    }
    
    // Getters for metrics calculation
    public Map<String, User> getUsers() {
        return users;
    }
    
    public Map<String, Website> getWebsites() {
        return websites;
    }
    
    public Map<String, Subscription> getSubscriptions() {
        return subscriptions;
    }
}