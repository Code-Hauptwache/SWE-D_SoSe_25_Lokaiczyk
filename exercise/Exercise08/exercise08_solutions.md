# Exercise 08 - Solutions

## 1. Difference between Virtual Machine and Docker Container

**Virtual Machine:**
- Runs complete guest OS with own kernel
- Resource heavy (several GB)
- Takes minutes to start
- Hardware-level virtualization

**Docker Container:**
- Shares host OS kernel
- Lightweight (tens of MB)
- Starts in seconds
- OS-level virtualization

## 2. Main purpose of Continuous Integration

**Answer: c)** frequently integrate code into a shared repository and run automated tests

CI helps detect integration problems early by merging code changes frequently.

## 3. Docker Container for Website Monitor

Modified Main.java to support command-line arguments and continuous monitoring. The application now runs in a loop until stopped with Ctrl+C.

**Build and run commands:**
```bash
mvn clean package
docker build -t website-monitor .
```

**Usage Examples:**

1. **Default mode** (uses hardcoded test data):
```bash
docker run website-monitor
```

2. **Monitor specific URLs**:
```bash
docker run website-monitor https://www.google.com https://www.github.com
```

3. **Custom check interval** (default is 60 seconds):
```bash
docker run website-monitor --interval 30 https://www.google.com
```

**Features:**
- Continuous monitoring loop (Ctrl+C to stop)
- Command-line URL arguments
- Configurable check interval
- Falls back to hardcoded test data if no URLs provided
- Uses Observer pattern for notifications
- Uses Strategy pattern for comparison methods
- Displays metrics every 5 checks

**Example Output:**
```
=== Website Monitor System with Observer & Strategy Patterns ===

Monitoring URLs: [https://www.google.com]

--- Creating Custom Subscriptions ---
Added monitoring for: https://www.google.com

=== Starting Continuous Monitoring (Ctrl+C to stop) ===
Check interval: 60 seconds

--- Check #1 at Mon Jun 30 11:20:00 CEST 2025 ---
[Monitoring output...]
```

## 4. Tool for CI/CD pipelines

**Answer: b) Jenkins**

Jenkins is the most common CI/CD orchestration tool. Kubernetes is for container orchestration, Ansible for configuration management, and Terraform for infrastructure as code.

## 5. Strategies to speed up testing in CI pipeline

- **Parallel test execution** - Run tests concurrently on multiple agents
- **Test categorization** - Separate unit, integration, and E2E tests
- **Incremental testing** - Only run tests affected by code changes
- **Test caching** - Cache dependencies and test data
- **Fail fast** - Stop pipeline on first failure

## 6. Exam Question Suggestion

**Question:** "Explain how the Observer and Strategy patterns can be combined in a real-world application. Provide a concrete example with UML diagram and discuss the benefits of using both patterns together versus implementing the functionality without design patterns. Include coupling/cohesion analysis."
