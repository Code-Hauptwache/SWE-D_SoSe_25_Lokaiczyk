# Website Monitor System - Observer & Strategy Patterns

A Java implementation of a website monitoring system using Observer and Strategy design patterns.

## Project Structure

```
src/main/java/com/websitemonitor/
├── model/
│   ├── User.java
│   ├── Website.java (Subject + Strategy Context)
│   ├── Subscription.java (Observer)
│   └── Notification.java
├── observer/
│   ├── WebsiteObserver.java
│   └── WebsiteSubject.java
├── strategy/
│   ├── ComparisonStrategy.java
│   ├── ContentSizeStrategy.java
│   ├── HtmlContentStrategy.java
│   └── TextContentStrategy.java
├── service/
│   ├── NotificationService.java (Singleton)
│   └── MonitoringService.java
├── controller/
│   └── WebsiteController.java
├── Main.java
└── MetricsCalculator.java
```

## Design Patterns Implemented

### Observer Pattern
- **Subject**: `Website` implements `WebsiteSubject`
- **Observer**: `Subscription` implements `WebsiteObserver`
- Automatic notification when websites update

### Strategy Pattern
- **Strategy**: `ComparisonStrategy` interface
- **Concrete Strategies**:
  - `ContentSizeStrategy`: Compares file size
  - `HtmlContentStrategy`: Compares normalized HTML
  - `TextContentStrategy`: Compares extracted text only
- Runtime strategy switching

## Features

- Multiple comparison strategies for website changes
- Observer pattern for loose coupling
- Strategy pattern for flexible comparison algorithms
- Singleton pattern for NotificationService
- Mock notification system (email, SMS)
- Coupling metrics calculation

## How to Run

```bash
cd website-monitor/src/main/java
javac com/websitemonitor/*.java com/websitemonitor/model/*.java com/websitemonitor/service/*.java com/websitemonitor/controller/*.java com/websitemonitor/observer/*.java com/websitemonitor/strategy/*.java
java com.websitemonitor.Main
```

## Design Benefits

1. **Observer Pattern**:
   - Loose coupling between subjects and observers
   - Dynamic subscription management
   - Automatic update propagation

2. **Strategy Pattern**:
   - Encapsulated comparison algorithms
   - Runtime algorithm selection
   - Easy to add new strategies

3. **Combined Benefits**:
   - Flexible and extensible design
   - Clear separation of concerns
   - Maintainable and testable code

## UML Diagrams

- `observer_pattern_uml.puml` - Observer pattern structure
- `strategy_pattern_uml.puml` - Strategy pattern structure

## Coding Conventions

See Exercise06/coding_conventions.md for detailed coding standards used in this project.