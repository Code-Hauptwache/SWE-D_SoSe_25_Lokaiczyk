# Website Monitor System - Observer Pattern Implementation

A Java implementation of a website monitoring system using the Observer design pattern.

## Project Structure

```
src/main/java/com/websitemonitor/
├── model/
│   ├── User.java
│   ├── Website.java (Subject)
│   ├── Subscription.java (Observer)
│   └── Notification.java
├── observer/
│   ├── WebsiteObserver.java
│   └── WebsiteSubject.java
├── service/
│   ├── NotificationService.java (Singleton)
│   └── MonitoringService.java
├── controller/
│   └── WebsiteController.java
├── Main.java
└── MetricsCalculator.java
```

## Observer Pattern Implementation

- **Subject**: `Website` implements `WebsiteSubject`
  - Maintains list of observers
  - Notifies observers when updates detected
  
- **Observer**: `Subscription` implements `WebsiteObserver`
  - Registers with website automatically
  - Handles notifications when website updates

## Features

- Observer pattern for loose coupling
- Multiple subscriptions can observe same website
- Automatic notification on website updates
- Singleton pattern for NotificationService
- Mock notification system (email, SMS)
- Coupling metrics calculation

## How to Run

```bash
cd website-monitor/src/main/java
javac com/websitemonitor/*.java com/websitemonitor/*/*.java
java com.websitemonitor.Main
```

## Design Benefits

1. **Loose Coupling**: Websites don't know about notification details
2. **Flexibility**: Easy to add/remove observers dynamically
3. **Single Responsibility**: Each class has one clear purpose
4. **Open/Closed Principle**: Can extend without modifying existing code

## UML Diagram

See `observer_pattern_uml.puml` for the complete class diagram showing the Observer pattern structure.