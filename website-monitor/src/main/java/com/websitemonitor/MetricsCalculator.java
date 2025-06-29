package com.websitemonitor;

import java.util.HashMap;
import java.util.Map;

public class MetricsCalculator {
    
    // Class dependencies for coupling calculation with Observer pattern
    private static final Map<String, ClassMetrics> classMetrics = new HashMap<>();
    
    static {
        // Initialize metrics for each class - updated for Observer pattern
        // Model classes
        classMetrics.put("User", new ClassMetrics("User", 0, 0));
        classMetrics.put("Website", new ClassMetrics("Website", 2, 3)); // implements Subject, uses Observer interface
        classMetrics.put("Subscription", new ClassMetrics("Subscription", 3, 2)); // implements Observer, uses Website, User, NotificationService
        classMetrics.put("Notification", new ClassMetrics("Notification", 1, 1)); // depends on User
        
        // Observer interfaces
        classMetrics.put("WebsiteObserver", new ClassMetrics("WebsiteObserver", 0, 2)); // used by Website and Subscription
        classMetrics.put("WebsiteSubject", new ClassMetrics("WebsiteSubject", 0, 1)); // used by Website
        
        // Service classes
        classMetrics.put("NotificationService", new ClassMetrics("NotificationService", 3, 1)); // uses Notification, Subscription, User
        classMetrics.put("MonitoringService", new ClassMetrics("MonitoringService", 1, 0)); // uses Website only
        
        // Controller class
        classMetrics.put("WebsiteController", new ClassMetrics("WebsiteController", 4, 0)); // uses User, Website, Subscription, MonitoringService
    }
    
    public void calculateAndPrintMetrics() {
        System.out.println("\nCoupling Metrics with Observer Pattern:");
        System.out.println("Class Name | Afferent Coupling (Ca) | Efferent Coupling (Ce) | Instability (I)");
        System.out.println("-----------|------------------------|------------------------|----------------");
        
        for (ClassMetrics metrics : classMetrics.values()) {
            double instability = metrics.calculateInstability();
            System.out.printf("%-18s | %-22d | %-22d | %.2f%n", 
                metrics.className, metrics.afferentCoupling, metrics.efferentCoupling, instability);
        }
        
        System.out.println("\nObserver Pattern Benefits:");
        System.out.println("- Reduced coupling between Website and notification logic");
        System.out.println("- MonitoringService is simpler (Ce reduced from 4 to 1)");
        System.out.println("- Clear separation of concerns with Observer/Subject interfaces");
        
        System.out.println("\nPackage Structure:");
        System.out.println("- com.websitemonitor.model (User, Website, Subscription, Notification)");
        System.out.println("- com.websitemonitor.observer (WebsiteObserver, WebsiteSubject)");
        System.out.println("- com.websitemonitor.service (NotificationService, MonitoringService)");
        System.out.println("- com.websitemonitor.controller (WebsiteController)");
        
        System.out.println("\nFurther Coupling Reduction Options:");
        System.out.println("1. Use dependency injection framework");
        System.out.println("2. Create factory classes for object creation");
        System.out.println("3. Implement repository pattern for data access");
        System.out.println("4. Use event bus for decoupled communication");
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