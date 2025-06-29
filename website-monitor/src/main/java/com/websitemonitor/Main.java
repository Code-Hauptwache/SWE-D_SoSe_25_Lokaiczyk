package com.websitemonitor;

import com.websitemonitor.controller.WebsiteController;
import com.websitemonitor.model.User;
import com.websitemonitor.model.Website;
import com.websitemonitor.strategy.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Website Monitor System with Observer & Strategy Patterns ===\n");
        
        // Initialize controller
        WebsiteController controller = new WebsiteController();
        
        // Create test users
        User user1 = new User("1", "john_doe", "john@example.com", "+1234567890");
        User user2 = new User("2", "jane_smith", "jane@example.com", "+0987654321");
        
        controller.addUser(user1);
        controller.addUser(user2);
        
        // Create subscriptions
        System.out.println("--- Creating Subscriptions ---");
        controller.createSubscription(user1, "https://example.com", 60, "email");
        controller.createSubscription(user1, "https://news.com", 30, "sms");
        controller.createSubscription(user2, "https://blog.com", 120, "email");
        
        System.out.println("\n--- Testing Different Comparison Strategies ---");
        
        // Get websites and set different strategies
        Map<String, Website> websites = controller.getWebsites();
        Website exampleSite = null;
        Website newsSite = null;
        Website blogSite = null;
        
        for (Website site : websites.values()) {
            if (site.getUrl().contains("example.com")) {
                exampleSite = site;
                site.setComparisonStrategy(new ContentSizeStrategy());
            } else if (site.getUrl().contains("news.com")) {
                newsSite = site;
                site.setComparisonStrategy(new HtmlContentStrategy());
            } else if (site.getUrl().contains("blog.com")) {
                blogSite = site;
                site.setComparisonStrategy(new TextContentStrategy());
            }
        }
        
        System.out.println("\n--- First Check with Different Strategies ---");
        controller.manageSubscriptions();
        
        System.out.println("\n--- Changing Strategy at Runtime ---");
        if (exampleSite != null) {
            exampleSite.setComparisonStrategy(new TextContentStrategy());
        }
        
        System.out.println("\n--- Second Check with Changed Strategy ---");
        controller.manageSubscriptions();
        
        System.out.println("\n--- Calculating Metrics ---");
        MetricsCalculator calculator = new MetricsCalculator();
        calculator.calculateAndPrintMetrics();
        
        System.out.println("\n=== Pattern Benefits ===");
        System.out.println("Observer Pattern:");
        System.out.println("- Loose coupling between subjects and observers");
        System.out.println("- Dynamic subscription management");
        
        System.out.println("\nStrategy Pattern:");
        System.out.println("- Different comparison algorithms encapsulated");
        System.out.println("- Easy to add new comparison strategies");
        System.out.println("- Runtime strategy switching");
        
        System.out.println("\n=== System Running ===");
    }
}