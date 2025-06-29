# Website Monitor System

A simple Java implementation of a website monitoring system that notifies users when websites are updated.

## Project Structure

```
src/main/java/com/websitemonitor/
├── model/
│   ├── User.java
│   ├── Website.java
│   ├── Subscription.java
│   └── Notification.java
├── service/
│   ├── NotificationService.java
│   └── MonitoringService.java
├── controller/
│   └── WebsiteController.java
├── Main.java
└── MetricsCalculator.java
```

## Features

- User management
- Website monitoring with update detection
- Subscription management (create, modify, cancel)
- Mock notification system (email, SMS)
- Coupling metrics calculation

## How to Run

```bash
cd website-monitor/src/main/java
javac com/websitemonitor/*.java com/websitemonitor/*/*.java
java com.websitemonitor.Main
```

## Coupling Metrics

The system calculates:
- **Afferent Coupling (Ca)**: Number of classes that depend on this class
- **Efferent Coupling (Ce)**: Number of classes this class depends on
- **Instability (I)**: Ce / (Ca + Ce)

## Design Decisions

1. **Package Structure**: Organized by layer (model, service, controller)
2. **Low Coupling**: Services are loosely coupled through dependency injection pattern
3. **High Cohesion**: Each class has a single, well-defined responsibility
4. **Mock Implementation**: Notifications and website checking are mocked for simplicity

## Options to Reduce Coupling

1. Use interfaces for services
2. Implement dependency injection framework
3. Use event-driven architecture
4. Apply facade pattern
5. Extract common interfaces for model classes