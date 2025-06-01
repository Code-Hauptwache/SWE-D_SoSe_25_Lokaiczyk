# Task 5: UML Diagrams and Java Implementation

## UML Class Diagram

I created a UML class diagram for a `Developer` class using PlantUML syntax. The diagram is in [`task05_uml.puml`](task05_uml.puml).

### Class Structure:
**5 Attributes:**
- `name: String` - Developer's full name
- `age: int` - Developer's age
- `email: String` - Developer's email address
- `programmingLanguage: String` - Primary programming language
- `yearsOfExperience: int` - Years of programming experience

**5+ Methods:**
- `getName()` / `setName()` - Get/set developer name with validation
- `getAge()` / `setAge()` - Get/set age with validation (16-100)
- `getEmail()` / `setEmail()` - Get/set email with format validation
- `getProgrammingLanguage()` / `setProgrammingLanguage()` - Get/set programming language
- `getYearsOfExperience()` / `setYearsOfExperience()` - Get/set experience (0-50 years)
- `writeCode()` - Business method for writing code
- `debugCode()` - Business method for debugging
- `reviewCode()` - Business method for code review
- `learnNewTechnology()` - Business method for learning
- `toString()` - String representation of the object

## UML Object Diagram

The object diagram shows a specific instance representing myself:
```
myself : Developer
- name = "John Student"
- age = 22
- email = "john.student@university.edu"
- programmingLanguage = "Java"
- yearsOfExperience = 2
```

## Java Implementation

The Java class [`Developer.java`](Developer.java) implements the UML design with integrity checks in all setter methods:

### Integrity Checks:
- **Name:** Cannot be null or empty, automatically trimmed
- **Age:** Must be between 16 and 100 years
- **Email:** Must contain "@" and "." (basic email validation)
- **Programming Language:** Cannot be null or empty
- **Years of Experience:** Must be between 0 and 50 years

### How to View UML Diagrams:
1. **Online:** Go to [plantuml.com](http://plantuml.com) and paste the content from `task05_uml.puml`
2. **VSCode:** Install "PlantUML" extension and preview the .puml file
3. **Command Line:** Install PlantUML and run `plantuml task05_uml.puml`

### How to Test the Java Implementation:
```bash
javac Developer.java
java Developer
```

This will:
- Create a Developer object with the values from the object diagram
- Test all business methods
- Demonstrate the integrity checks by trying invalid values

## Example Output:
```
Developer created: Developer{name='John Student', age=22, email='john.student@university.edu', programmingLanguage='Java', yearsOfExperience=2}
John Student is writing code in Java
John Student is debugging code
John Student is reviewing code from colleagues
John Student is learning new technology

Testing integrity checks:
Age validation works: Age must be between 16 and 100
Email validation works: Email must be valid format (contain @ and .)
```

## Files Created:
- [`task05_uml.puml`](task05_uml.puml) - PlantUML code for class and object diagrams
- [`Developer.java`](Developer.java) - Java implementation with integrity checks
- [`task05.md`](task05.md) - This documentation file