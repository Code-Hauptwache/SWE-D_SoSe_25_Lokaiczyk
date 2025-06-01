# Task 1: UML Design Model for Website Monitor System

## System Description
A website monitoring system that allows users to register for updates on specific websites and receive notifications when changes are detected.

## UML Class Diagram
The structural design is implemented in [`task01_uml.puml`](task01_uml.puml).

## Classes and Responsibilities

### User
- **Attributes:** userId, username, email, phoneNumber
- **Methods:** register(), login(), manageSubscriptions()
- **Purpose:** Represents system users who want to monitor websites

### Website
- **Attributes:** websiteId, url, lastChecked, lastModified
- **Methods:** checkForUpdates(), getContent()
- **Purpose:** Represents websites being monitored

### Subscription
- **Attributes:** subscriptionId, frequency, communicationChannel, isActive, createdDate
- **Methods:** modify(), cancel(), activate()
- **Purpose:** Links users to websites with specific monitoring preferences

### NotificationService
- **Methods:** generateNotification(), sendNotification(), scheduleCheck()
- **Purpose:** Handles notification creation and delivery

### Notification
- **Attributes:** notificationId, message, timestamp, status
- **Methods:** send()
- **Purpose:** Represents individual notifications sent to users

### MonitoringSystem
- **Methods:** periodicCheck(), processUpdates()
- **Purpose:** Core system that coordinates website checking

## Key Relationships
- **User creates Subscription** (1 to many)
- **Subscription monitors Website** (many to 1)
- **NotificationService creates Notification**
- **MonitoringSystem uses NotificationService**
- **User receives Notification**

## How to View the UML Diagram
1. Open [`task01_uml.puml`](task01_uml.puml) in VSCode
2. Right-click and select "Preview PlantUML"
3. Or use plantuml.com to render the diagram online