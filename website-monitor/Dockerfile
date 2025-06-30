# Use OpenJDK 17 as base image
FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Copy the JAR file from target directory
COPY target/WebsiteMonitor-1.0-SNAPSHOT.jar app.jar

# Set the entrypoint to run the JAR with command line arguments
ENTRYPOINT ["java", "-jar", "app.jar"]