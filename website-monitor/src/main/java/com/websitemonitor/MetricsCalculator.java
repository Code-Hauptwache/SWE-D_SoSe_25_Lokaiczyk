package com.websitemonitor;

import java.util.HashMap;
import java.util.Map;

public class MetricsCalculator {
    
    // Class dependencies for coupling calculation
    private static final Map<String, ClassMetrics> classMetrics = new HashMap<>();
    
    static {
        // Initialize metrics for each class
        // Model classes
        classMetrics.put("User", new ClassMetrics("User", 0, 0));
        classMetrics.put("Website", new ClassMetrics("Website", 0, 0));
        classMetrics.put("Subscription", new ClassMetrics("Subscription", 2, 2)); // depends on User, Website
        classMetrics.put("Notification", new ClassMetrics("Notification", 1, 1)); // depends on User
        
        // Service classes
        classMetrics.put("NotificationService", new ClassMetrics("NotificationService", 3, 1)); // uses Notification, Subscription, User
        classMetrics.put("MonitoringService", new ClassMetrics("MonitoringService", 4, 0)); // uses Subscription, Website, Notification, NotificationService
        
        // Controller class
        classMetrics.put("WebsiteController", new ClassMetrics("WebsiteController", 5, 0)); // uses all model classes + MonitoringService
    }
    
    public void calculateAndPrintMetrics() {
        System.out.println("\nCoupling Metrics for each class:");
        System.out.println("Class Name | Afferent Coupling (Ca) | Efferent Coupling (Ce) | Instability (I)");
        System.out.println("-----------|------------------------|------------------------|----------------");
        
        for (ClassMetrics metrics : classMetrics.values()) {
            double instability = metrics.calculateInstability();
            System.out.printf("%-10s | %-22d | %-22d | %.2f%n", 
                metrics.className, metrics.afferentCoupling, metrics.efferentCoupling, instability);
        }
        
        System.out.println("\nPackage Structure Suggestion:");
        System.out.println("- com.websitemonitor.model (User, Website, Subscription, Notification)");
        System.out.println("- com.websitemonitor.service (NotificationService, MonitoringService)");
        System.out.println("- com.websitemonitor.controller (WebsiteController)");
        
        System.out.println("\nOptions to Reduce Coupling:");
        System.out.println("1. Use interfaces for services (e.g., INotificationService)");
        System.out.println("2. Implement dependency injection instead of direct instantiation");
        System.out.println("3. Use event-driven architecture for notifications");
        System.out.println("4. Apply facade pattern to simplify controller interactions");
        System.out.println("5. Extract common interfaces for model classes");
    }
    
    private static class ClassMetrics {
        String className;
        int efferentCoupling; // Classes this class depends on
        int afferentCoupling; // Classes that depend on this class
        
        ClassMetrics(String className, int efferentCoupling, int afferentCoupling) {
            this.className = className;
            this.efferentCoupling = efferentCoupling;
            this.afferentCoupling = afferentCoupling;
        }
        
        double calculateInstability() {
            int total = efferentCoupling + afferentCoupling;
            if (total == 0) return 0.0;
            return (double) efferentCoupling / total;
        }
    }
}