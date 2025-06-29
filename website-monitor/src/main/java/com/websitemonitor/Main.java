package com.websitemonitor;

import com.websitemonitor.controller.WebsiteController;
import com.websitemonitor.model.User;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Website Monitor System ===\n");
        
        // Initialize controller
        WebsiteController controller = new WebsiteController();
        
        // Create test users
        User user1 = new User("1", "john_doe", "john@example.com", "+1234567890");
        User user2 = new User("2", "jane_smith", "jane@example.com", "+0987654321");
        
        // Create subscriptions
        controller.createSubscription(user1, "https://example.com", 60, "email");
        controller.createSubscription(user1, "https://news.com", 30, "sms");
        controller.createSubscription(user2, "https://blog.com", 120, "email");
        
        System.out.println("\n--- Running periodic check ---");
        controller.manageSubscriptions();
        
        System.out.println("\n--- Modifying subscription ---");
        Map<String, Object> modifyParams = new HashMap<>();
        modifyParams.put("subscriptionId", "1");
        modifyParams.put("frequency", 90);
        modifyParams.put("channel", "sms");
        controller.handleUserRequest("modify", modifyParams);
        
        System.out.println("\n--- Calculating Metrics ---");
        MetricsCalculator calculator = new MetricsCalculator();
        calculator.calculateAndPrintMetrics();
        
        System.out.println("\n=== System Running ===");
    }
}