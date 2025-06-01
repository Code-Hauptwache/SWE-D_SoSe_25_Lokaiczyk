# Task 8: Design Activities Dependencies

## Are Design Activities Independent or Interdependent?

The design activities are **INTERDEPENDENT** - they depend on each other.

## Example: Online Shopping Website

### How They Connect:

**Architectural Design:**
- Decides: 3-layer structure (Web → Business → Database)

**Database Design:**
- Must fit the architecture layers
- Creates tables for products, users, orders

**User Interface Design:**
- Must show data from the database
- Must work with the web layer of architecture

**Component Design:**
- Shopping cart component needs database connection
- Payment component needs business layer logic
- All components must fit the architecture

### Why They Are Interdependent:

If you change the **database structure** (add new table), you must also change:
- **User interface** (show new data)
- **Components** (handle new data)
- **Architecture** (maybe add new layer)

## Conclusion:

All design activities connect together like puzzle pieces. Change one piece, and you must adjust the others to make everything fit properly.