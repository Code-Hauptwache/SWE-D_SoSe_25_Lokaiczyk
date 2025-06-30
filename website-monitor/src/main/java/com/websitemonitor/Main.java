package com.websitemonitor;

import com.websitemonitor.controller.WebsiteController;
import com.websitemonitor.model.User;
import com.websitemonitor.model.Website;
import com.websitemonitor.strategy.*;
import java.util.*;

public class Main {
    private static volatile boolean running = true;
    private static int checkInterval = 60; // Default 60 seconds
    
    public static void main(String[] args) {
        System.out.println("=== Website Monitor System with Observer & Strategy Patterns ===\n");
        
        // Initialize controller
        WebsiteController controller = new WebsiteController();
        
        // Parse command line arguments
        List<String> urls = new ArrayList<>();
        parseArguments(args, urls);
        
        // Setup monitoring based on arguments or use defaults
        if (urls.isEmpty()) {
            System.out.println("No URLs provided. Using default test configuration...\n");
            setupDefaultMonitoring(controller);
        } else {
            System.out.println("Monitoring URLs: " + urls + "\n");
            setupCustomMonitoring(controller, urls);
        }
        
        // Add shutdown hook for graceful exit
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\n\nShutting down monitoring...");
            running = false;
        }));
        
        // Continuous monitoring loop
        System.out.println("\n=== Starting Continuous Monitoring (Ctrl+C to stop) ===");
        System.out.println("Check interval: " + checkInterval + " seconds\n");
        
        int checkCount = 0;
        while (running) {
            checkCount++;
            System.out.println("\n--- Check #" + checkCount + " at " + new Date() + " ---");
            
            controller.manageSubscriptions();
            
            // Calculate and display metrics periodically
            if (checkCount % 5 == 0) {
                System.out.println("\n--- Metrics Update ---");
                MetricsCalculator calculator = new MetricsCalculator();
                calculator.calculateAndPrintMetrics();
            }
            
            // Wait for next check
            try {
                Thread.sleep(checkInterval * 1000L);
            } catch (InterruptedException e) {
                // Exit gracefully on interrupt
                running = false;
            }
        }
        
        System.out.println("\nMonitoring stopped. Goodbye!");
    }
    
    private static void parseArguments(String[] args, List<String> urls) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--interval") && i + 1 < args.length) {
                try {
                    checkInterval = Integer.parseInt(args[i + 1]);
                    i++; // Skip next argument
                } catch (NumberFormatException e) {
                    System.err.println("Invalid interval value: " + args[i + 1]);
                }
            } else if (args[i].startsWith("http://") || args[i].startsWith("https://")) {
                urls.add(args[i]);
            }
        }
    }
    
    private static void setupDefaultMonitoring(WebsiteController controller) {
        // Create test users
        User user1 = new User("1", "john_doe", "john@example.com", "+1234567890");
        User user2 = new User("2", "jane_smith", "jane@example.com", "+0987654321");
        
        controller.addUser(user1);
        controller.addUser(user2);
        
        // Create subscriptions
        System.out.println("--- Creating Default Subscriptions ---");
        controller.createSubscription(user1, "https://example.com", 60, "email");
        controller.createSubscription(user1, "https://news.com", 30, "sms");
        controller.createSubscription(user2, "https://blog.com", 120, "email");
        
        // Set different strategies for demonstration
        Map<String, Website> websites = controller.getWebsites();
        for (Website site : websites.values()) {
            if (site.getUrl().contains("example.com")) {
                site.setComparisonStrategy(new ContentSizeStrategy());
                System.out.println("Set ContentSizeStrategy for " + site.getUrl());
            } else if (site.getUrl().contains("news.com")) {
                site.setComparisonStrategy(new HtmlContentStrategy());
                System.out.println("Set HtmlContentStrategy for " + site.getUrl());
            } else if (site.getUrl().contains("blog.com")) {
                site.setComparisonStrategy(new TextContentStrategy());
                System.out.println("Set TextContentStrategy for " + site.getUrl());
            }
        }
    }
    
    private static void setupCustomMonitoring(WebsiteController controller, List<String> urls) {
        // Create a default user for custom monitoring
        User defaultUser = new User("docker", "docker_user", "monitor@docker.local", "+1234567890");
        controller.addUser(defaultUser);
        
        System.out.println("--- Creating Custom Subscriptions ---");
        
        // Create subscriptions for provided URLs
        for (String url : urls) {
            controller.createSubscription(defaultUser, url, checkInterval, "email");
            System.out.println("Added monitoring for: " + url);
        }
        
        // Set default strategy (ContentSizeStrategy) for all sites
        Map<String, Website> websites = controller.getWebsites();
        for (Website site : websites.values()) {
            site.setComparisonStrategy(new ContentSizeStrategy());
        }
    }
}