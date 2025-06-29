# Exercise 5 - Observer Pattern Implementation

## Task 1: Refactored Code with Observer Pattern

Successfully refactored the website monitor system to implement the Observer pattern.

### Key Changes:

1. **Created Observer Interfaces**
   - `WebsiteObserver` - Interface for objects that need to be notified
   - `WebsiteSubject` - Interface for objects that notify observers

2. **Website as Subject**
   - Implements `WebsiteSubject`
   - Maintains list of observers
   - Notifies all observers when updates detected

3. **Subscription as Observer**
   - Implements `WebsiteObserver`
   - Automatically registers with website on creation
   - Handles its own notifications when updated

4. **Simplified MonitoringService**
   - No longer handles notifications
   - Just triggers website checks
   - Reduced coupling (Ce: 4 → 1)

### Benefits Demonstrated:

From the program output:
- **Multiple observers per subject**: Both john_doe and jane_smith observe example.com
- **Automatic notification**: When website updates, all subscriptions are notified
- **Loose coupling**: Website doesn't know about notification details
- **Dynamic observer management**: Easy to add/remove subscriptions

### Coupling Improvements:

| Component | Before | After |
|-----------|--------|-------|
| MonitoringService | Ce: 4 | Ce: 1 |
| Website | Ce: 0 | Ce: 2 (but uses interfaces) |
| Overall | Tight coupling | Loose coupling via interfaces |

## Task 2: UML Diagram

Created `observer_pattern_uml.puml` showing:
- Observer and Subject interfaces
- Implementation relationships
- Observer pattern structure
- Notes explaining the pattern flow

The diagram clearly illustrates how the Observer pattern decouples the website monitoring from notification handling.