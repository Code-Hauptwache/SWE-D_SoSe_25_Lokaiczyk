# Task 3: CRC Cards with Controller and Expert Principles

## CRC Cards for Website Monitor System

### User
```
┌─────────────────────────────────────────────────────┐
│                      User                           │
├─────────────────────────┬───────────────────────────┤
│     Responsibilities    │      Collaborations       │
│ - Know user credentials │ - Subscription            │
│ - Know contact info     │ - WebsiteController       │
│ - Authenticate self     │                           │
│ - Request subscriptions │                           │
└─────────────────────────┴───────────────────────────┘
```

### Website
```
┌─────────────────────────────────────────────────────┐
│                    Website                          │
├─────────────────────────┬───────────────────────────┤
│     Responsibilities    │      Collaborations       │
│ - Know URL and content  │ - MonitoringSystem        │
│ - Know last check time  │ - Subscription            │
│ - Check for updates     │                           │
│ - Provide content       │                           │
└─────────────────────────┴───────────────────────────┘
```

### Subscription
```
┌─────────────────────────────────────────────────────┐
│                  Subscription                       │
├─────────────────────────┬───────────────────────────┤
│     Responsibilities    │      Collaborations       │
│ - Know preferences      │ - User                    │
│ - Know frequency        │ - Website                 │
│ - Know comm channel     │ - WebsiteController       │
│ - Manage subscription   │                           │
└─────────────────────────┴───────────────────────────┘
```

### WebsiteController (NEW - Controller Principle)
```
┌─────────────────────────────────────────────────────┐
│               WebsiteController                     │
├─────────────────────────┬───────────────────────────┤
│     Responsibilities    │      Collaborations       │
│ - Handle user requests  │ - User                    │
│ - Coordinate operations │ - Subscription            │
│ - Manage subscriptions  │ - MonitoringSystem        │
│ - Process system events │ - NotificationService     │
└─────────────────────────┴───────────────────────────┘
```

### MonitoringSystem
```
┌─────────────────────────────────────────────────────┐
│                MonitoringSystem                     │
├─────────────────────────┬───────────────────────────┤
│     Responsibilities    │      Collaborations       │
│ - Schedule periodic     │ - Website                 │
│   checks                │ - NotificationService     │
│ - Detect updates        │ - WebsiteController       │
│ - Trigger notifications │                           │
└─────────────────────────┴───────────────────────────┘
```

### NotificationService
```
┌─────────────────────────────────────────────────────┐
│               NotificationService                   │
├─────────────────────────┬───────────────────────────┤
│     Responsibilities    │      Collaborations       │
│ - Know how to send      │ - Notification            │
│   notifications         │ - MonitoringSystem        │
│ - Create notifications  │ - Subscription            │
│ - Handle delivery       │                           │
└─────────────────────────┴───────────────────────────┘
```

### Notification
```
┌─────────────────────────────────────────────────────┐
│                  Notification                       │
├─────────────────────────┬───────────────────────────┤
│     Responsibilities    │      Collaborations       │
│ - Know message content  │ - NotificationService     │
│ - Know delivery status  │ - User                    │
│ - Send itself           │                           │
└─────────────────────────┴───────────────────────────┘
```

## Changes Made Using GRASP Principles

### 1. Added WebsiteController (Controller Principle)
**Reason:** Applied Controller principle to handle system events
- **Before:** User directly managed subscriptions
- **After:** WebsiteController handles all user requests and coordinates operations
- **Benefit:** Separates UI concerns from business logic

### 2. Moved Responsibilities (Expert Principle)
**Changes made:**
- **Subscription management** moved from User to WebsiteController
- **Notification creation** stays with NotificationService (has the expertise)
- **Update checking** stays with Website (has the content information)

### 3. Updated Collaborations
- User now collaborates with WebsiteController instead of directly with Subscription
- WebsiteController coordinates between all other classes
- Cleaner separation of concerns

## Benefits of Applied Principles:
- **Lower Coupling:** User doesn't directly manage complex subscription logic
- **Higher Cohesion:** Each class has more focused responsibilities
- **Better Control:** Single point for handling system operations
- **Easier Maintenance:** Changes to subscription logic only affect WebsiteController