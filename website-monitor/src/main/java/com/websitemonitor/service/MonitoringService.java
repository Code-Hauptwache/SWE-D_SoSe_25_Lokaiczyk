package com.websitemonitor.service;

import com.websitemonitor.model.Subscription;
import com.websitemonitor.model.Website;
import java.util.List;
import java.util.ArrayList;

public class MonitoringService {
    private List<Website> monitoredWebsites;
    
    public MonitoringService() {
        this.monitoredWebsites = new ArrayList<>();
    }
    
    public void addWebsite(Website website) {
        if (!monitoredWebsites.contains(website)) {
            monitoredWebsites.add(website);
            System.out.println("Added website to monitoring: " + website.getUrl());
        }
    }
    
    public void removeWebsite(Website website) {
        monitoredWebsites.remove(website);
        System.out.println("Removed website from monitoring: " + website.getUrl());
    }
    
    public void periodicCheck() {
        System.out.println("Running periodic check for all websites...");
        
        for (Website website : monitoredWebsites) {
            // Simply trigger the check - observers will be notified automatically
            boolean updated = website.checkForUpdates();
            
            if (updated) {
                System.out.println("Update detected for: " + website.getUrl());
            } else {
                System.out.println("No updates for: " + website.getUrl());
            }
        }
    }
    
    public List<Website> getMonitoredWebsites() {
        return new ArrayList<>(monitoredWebsites);
    }
}