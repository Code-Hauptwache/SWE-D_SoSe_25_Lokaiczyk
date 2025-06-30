package com.websitemonitor;

import java.net.HttpURLConnection;
import java.net.URL;

public class DockerMain {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar app.jar <website-url>");
            System.exit(1);
        }
        
        String websiteUrl = args[0];
        System.out.println("Monitoring: " + websiteUrl);
        
        try {
            URL url = new URL(websiteUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            long startTime = System.currentTimeMillis();
            int responseCode = connection.getResponseCode();
            long responseTime = System.currentTimeMillis() - startTime;
            
            System.out.println("Status Code: " + responseCode);
            System.out.println("Response Time: " + responseTime + "ms");
            
            if (responseCode >= 200 && responseCode < 300) {
                System.out.println("Status: UP");
            } else {
                System.out.println("Status: DOWN");
            }
            
            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Status: ERROR");
        }
    }
}