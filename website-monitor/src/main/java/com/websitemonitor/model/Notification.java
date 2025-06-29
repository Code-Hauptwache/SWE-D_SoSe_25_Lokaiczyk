package com.websitemonitor.model;

import java.util.Date;

public class Notification {
    private String notificationId;
    private String message;
    private Date timestamp;
    private String status; // "pending", "sent", "failed"
    private User recipient;
    private String channel;
    
    public Notification(String notificationId, String message, User recipient, String channel) {
        this.notificationId = notificationId;
        this.message = message;
        this.recipient = recipient;
        this.channel = channel;
        this.timestamp = new Date();
        this.status = "pending";
    }
    
    public void send() {
        // Mock implementation
        System.out.println("Sending notification to " + recipient.getEmail() + 
                          " via " + channel + ": " + message);
        this.status = "sent";
    }
    
    // Getters and setters
    public String getNotificationId() {
        return notificationId;
    }
    
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public User getRecipient() {
        return recipient;
    }
    
    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
    
    public String getChannel() {
        return channel;
    }
    
    public void setChannel(String channel) {
        this.channel = channel;
    }
}