package com.websitemonitor.service;

import com.websitemonitor.model.Subscription;
import com.websitemonitor.model.Website;
import com.websitemonitor.model.Notification;
import java.util.List;
import java.util.ArrayList;

public class MonitoringService {
    private NotificationService notificationService;
    private List<Subscription> activeSubscriptions;
    
    public MonitoringService() {
        this.notificationService = new NotificationService();
        this.activeSubscriptions = new ArrayList<>();
    }
    
    public void addSubscription(Subscription subscription) {
        activeSubscriptions.add(subscription);
        notificationService.scheduleCheck(subscription);
    }
    
    public void periodicCheck() {
        System.out.println("Running periodic check for all subscriptions...");
        
        for (Subscription subscription : activeSubscriptions) {
            if (subscription.isActive()) {
                processUpdates(subscription);
            }
        }
    }
    
    public void processUpdates(Subscription subscription) {
        Website website = subscription.getWebsite();
        
        if (website.checkForUpdates()) {
            System.out.println("Update detected for: " + website.getUrl());
            
            Notification notification = notificationService.generateNotification(
                subscription, "Website has been updated!"
            );
            
            notificationService.sendNotification(notification);
        } else {
            System.out.println("No updates for: " + website.getUrl());
        }
    }
    
    public List<Subscription> getActiveSubscriptions() {
        return activeSubscriptions;
    }
}