# Exercise 09 - Solutions

## 1. Defects at Delivery vs Product Support

**Explanation:**
The number of defects remaining in software at delivery has a direct correlation with product support effort:

- **More defects = More support work**
- Each defect can generate multiple support tickets
- Support costs increase linearly with defect count
- Customer satisfaction decreases as defects increase

**Impact on Product Support:**
- Increased bug reports and complaints
- Need for emergency patches and hotfixes
- Higher support team workload
- Increased operational costs
- Potential damage to company reputation

**Chart: Defects vs Support Effort**
```
Support Effort
    ^
150 |                    *
    |                 *
100 |              *
    |           *
 50 |        *
    |     *
  0 +--*--+-----+-----+----> 
    0    10    20    30   Defects at Delivery
```

The chart shows a linear relationship: as defects increase, support effort increases proportionally.

## 2. Developers Testing Their Own Programs

**Arguments FOR developers testing their own code:**
1. **Deep knowledge** - They understand the code's logic and edge cases
2. **Immediate feedback** - Can test and fix bugs quickly
3. **Cost-effective** - No need to explain code to another tester
4. **Early bug detection** - Can catch issues during development
5. **Faster iteration** - Quick test-fix-test cycles

**Arguments AGAINST developers testing their own code:**
1. **Confirmation bias** - Tend to test what they expect to work
2. **Blind spots** - Miss their own mistakes and assumptions
3. **Limited perspective** - May not think like end users
4. **Incomplete testing** - Often skip negative test cases
5. **Emotional attachment** - Less likely to find faults in their own work

## 3. Equivalence Classes and Unit Tests

**Equivalence Classes for Website Monitor:**

1. **Valid URLs:**
   - HTTP URLs: `http://example.com`
   - HTTPS URLs: `https://example.com`
   - URLs with paths: `https://example.com/page`

2. **Invalid URLs:**
   - Empty string: `""`
   - Malformed URLs: `htp://example`
   - Non-existent domains: `https://doesnotexist12345.com`

3. **Response Status Codes:**
   - Success (200-299): Website is UP
   - Client errors (400-499): Website has issues
   - Server errors (500-599): Website is DOWN

**Unit Tests Created in Project:**

1. **WebsiteTest.java** - Tests the Website model class
   - Test valid URL creation
   - Test content updates
   
2. **DockerMainTest.java** - Tests command line functionality
   - Test with no arguments (shows usage)
   - Test with valid URL
   - Test with invalid URL

3. **ComparisonStrategyTest.java** - Tests strategy patterns
   - Test ContentSizeStrategy
   - Test TextContentStrategy
   - Test HtmlContentStrategy

**Running the tests:**
```bash
mvn test
```

## 4. Regression Testing

### Definition
Regression testing is a type of software testing that verifies that previously developed and tested software still performs correctly after changes have been made. It ensures that new code changes, bug fixes, or feature additions don't break existing functionality.

### Key Characteristics:
1. **Re-running existing tests** after code modifications
2. **Automated execution** to save time and ensure consistency
3. **Continuous integration** - run after every commit
4. **Test suite maintenance** - update tests as features evolve

### Example in Our Project:
```bash
# Run all tests to ensure nothing broke
mvn test

# Example regression test scenario:
# 1. All tests pass initially
# 2. Developer adds new feature to Website class
# 3. Run tests again to ensure existing functionality works
# 4. If tests fail, the change introduced a regression
```

### Benefits:
- Early detection of bugs
- Confidence in code changes
- Maintains software quality
- Supports agile development

## 5. Black Box vs White Box Testing

### Black Box Testing
Testing the software without knowledge of internal structure or implementation details.

**Characteristics:**
- Tests from user's perspective
- Focuses on inputs and outputs
- No access to source code
- Tests functional requirements

**Example from our tests:**
```java
@Test
public void testInvalidUrl() {
    // Black box: We only care about the output for invalid input
    DockerMain.main(new String[]{"not-a-valid-url"});
    String output = outContent.toString();
    assertTrue(output.contains("Error:"));
}
```

### White Box Testing
Testing with full knowledge of internal code structure, logic, and implementation.

**Characteristics:**
- Tests internal logic and code paths
- Requires source code access
- Tests code coverage
- Can test edge cases and error handling

**Example from our tests:**
```java
@Test
public void testStrategyChange() {
    // White box: We know the internal implementation
    // and test the specific strategy pattern
    HtmlContentStrategy newStrategy = new HtmlContentStrategy();
    website.setComparisonStrategy(newStrategy);
    assertEquals(newStrategy, website.getComparisonStrategy());
}
```

### Comparison Diagram:
```
Black Box Testing                    White Box Testing
┌─────────────────┐                 ┌─────────────────┐
│   Input → ?  →  │                 │  Input → Code → │
│              ↓  │                 │     ↓     ↓     │
│          Output │                 │  Logic  Output  │
└─────────────────┘                 └─────────────────┘
   User's View                         Developer's View
```

### When to Use:
- **Black Box**: Acceptance testing, user scenarios, API testing
- **White Box**: Unit testing, code coverage, security testing
- **Both**: Comprehensive test strategy combining perspectives