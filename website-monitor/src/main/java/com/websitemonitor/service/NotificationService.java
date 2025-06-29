package com.websitemonitor.service;

import com.websitemonitor.model.Notification;
import com.websitemonitor.model.Subscription;
import com.websitemonitor.model.User;
import java.util.UUID;

public class NotificationService {
    
    public Notification generateNotification(Subscription subscription, String updateMessage) {
        String notificationId = UUID.randomUUID().toString();
        User user = subscription.getUser();
        String channel = subscription.getCommunicationChannel();
        
        String message = "Website Update: " + subscription.getWebsite().getUrl() + 
                        " - " + updateMessage;
        
        return new Notification(notificationId, message, user, channel);
    }
    
    public void sendNotification(Notification notification) {
        notification.send();
    }
    
    public void scheduleCheck(Subscription subscription) {
        // Mock implementation - in real system would use scheduling framework
        System.out.println("Scheduled check for " + subscription.getWebsite().getUrl() + 
                          " every " + subscription.getFrequency() + " minutes");
    }
}