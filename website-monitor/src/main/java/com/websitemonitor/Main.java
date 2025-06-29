package com.websitemonitor;

import com.websitemonitor.controller.WebsiteController;
import com.websitemonitor.model.User;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Website Monitor System with Observer Pattern ===\n");
        
        // Initialize controller
        WebsiteController controller = new WebsiteController();
        
        // Create test users
        User user1 = new User("1", "john_doe", "john@example.com", "+1234567890");
        User user2 = new User("2", "jane_smith", "jane@example.com", "+0987654321");
        
        controller.addUser(user1);
        controller.addUser(user2);
        
        // Create subscriptions (observers are automatically attached)
        System.out.println("--- Creating Subscriptions ---");
        controller.createSubscription(user1, "https://example.com", 60, "email");
        controller.createSubscription(user1, "https://news.com", 30, "sms");
        controller.createSubscription(user2, "https://blog.com", 120, "email");
        controller.createSubscription(user2, "https://example.com", 45, "sms");
        
        System.out.println("\n--- Running First Check ---");
        controller.manageSubscriptions();
        
        System.out.println("\n--- Modifying Subscription ---");
        Map<String, Object> modifyParams = new HashMap<>();
        modifyParams.put("subscriptionId", "1");
        modifyParams.put("frequency", 90);
        modifyParams.put("channel", "sms");
        controller.handleUserRequest("modify", modifyParams);
        
        System.out.println("\n--- Running Second Check ---");
        controller.manageSubscriptions();
        
        System.out.println("\n--- Calculating Metrics ---");
        MetricsCalculator calculator = new MetricsCalculator();
        calculator.calculateAndPrintMetrics();
        
        System.out.println("\n=== Observer Pattern Benefits ===");
        System.out.println("1. Websites don't know about notifications - loose coupling");
        System.out.println("2. Multiple subscriptions can observe the same website");
        System.out.println("3. Subscriptions handle their own notifications");
        System.out.println("4. Easy to add/remove observers dynamically");
        
        System.out.println("\n=== System Running ===");
    }
}