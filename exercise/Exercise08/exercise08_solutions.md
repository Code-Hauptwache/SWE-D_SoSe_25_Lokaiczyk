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

Created Dockerfile and DockerMain.java for command line usage.

**Build and run commands:**
```bash
mvn clean package
docker build -t website-monitor .
docker run website-monitor https://www.google.com
```

**Output:**
```
Monitoring: https://www.google.com
Status Code: 200
Response Time: 590ms
Status: UP
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
