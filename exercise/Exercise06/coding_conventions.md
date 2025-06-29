# Coding Conventions - Website Monitor System

## Task 3: Coding Conventions Used

### 1. Naming Conventions

**Classes:**
- PascalCase (e.g., `WebsiteController`, `NotificationService`)
- Descriptive names indicating purpose
- Interfaces prefixed with 'I' concept avoided (modern Java style)

**Methods:**
- camelCase (e.g., `checkForUpdates()`, `hasChanged()`)
- Verb-based names for actions
- Boolean methods start with 'is', 'has', or 'can'

**Variables:**
- camelCase for instance and local variables
- Meaningful names avoiding abbreviations
- Constants in UPPER_SNAKE_CASE (if any)

**Packages:**
- All lowercase (e.g., `com.websitemonitor.strategy`)
- Organized by layer/feature

### 2. Code Organization

**Package Structure:**
```
com.websitemonitor
├── model/          # Domain entities
├── observer/       # Observer pattern interfaces
├── strategy/       # Strategy pattern classes
├── service/        # Business logic services
└── controller/     # Application controllers
```

**Class Structure:**
1. Package declaration
2. Imports (organized)
3. Class declaration
4. Instance variables (private)
5. Constructors
6. Public methods
7. Private helper methods
8. Getters/Setters

### 3. Design Patterns Applied

- **Observer Pattern**: For event notification
- **Strategy Pattern**: For comparison algorithms
- **Singleton Pattern**: For NotificationService

### 4. Best Practices

**Encapsulation:**
- All instance variables are private
- Public methods for controlled access
- Defensive copying for collections

**Comments:**
- Javadoc style for public methods (where needed)
- Inline comments for complex logic
- Self-documenting code preferred

**Error Handling:**
- Null checks where appropriate
- Meaningful exception messages
- Graceful degradation

### 5. Code Style

**Indentation:**
- 4 spaces (no tabs)
- Consistent brace style (opening brace on same line)

**Line Length:**
- Maximum 100 characters per line
- Logical line breaks for readability

**Spacing:**
- Blank lines between methods
- Spaces around operators
- No trailing whitespace

### 6. Java-Specific Conventions

- Use of generics for type safety
- Prefer interfaces over concrete types
- Override toString() for debugging
- Proper equals() and hashCode() implementation (where needed)
- Use of Java 8+ features where appropriate

These conventions ensure code readability, maintainability, and consistency across the project.