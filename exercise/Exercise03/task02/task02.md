# Task 2: GRASP Principles - Finding Responsible Classes

## How to Find the Responsible Class for a Method

### Information Expert Principle
**Problem:** What is a general principle of assigning responsibilities to objects?

**Solution:** Assign a responsibility to the **information expert** - the class that has the information necessary to fulfill the responsibility.

### Steps:
1. **Clearly state the responsibility** (what needs to be done)
2. **Identify what information is needed** to fulfill this responsibility
3. **Find the class that has this information** (or most of it)
4. **Assign the method to that class**

### Example:
- **Responsibility:** Calculate the total of a sale
- **Information needed:** Line items and their subtotals
- **Expert class:** `Sale` (has the line items)
- **Result:** `getTotal()` method goes to `Sale` class

## How to Find the Responsible Class for Object Creation

### Creator Principle
**Problem:** Who should be responsible for creating instances of a class?

**Solution:** Assign class B the responsibility of creating instance of class A if:
- B **aggregates** A objects
- B **contains** A objects  
- B **records instances** of A objects
- B **closely uses** A objects
- B **has the initializing data** for creating A objects

### Priority Order:
1. **Prefer:** B aggregates or contains A objects
2. **Key idea:** Creator needs to keep reference anyway and will frequently use the created object

### Example:
- **Question:** Who creates `SalesLineItem` objects?
- **Analysis:** `Sale` contains multiple `SalesLineItem` objects
- **Result:** `Sale` should create `SalesLineItem` instances

## Benefits:
- **Low Coupling:** Objects create what they need, avoiding dependencies
- **High Cohesion:** Related responsibilities stay together
- **Natural Design:** Follows intuitive object relationships