# Use an official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set a working directory
WORKDIR /app

# Add the JAR file to the container
COPY build/libs/taskmanager-0.0.1-SNAPSHOT.jar taskmanager-0.0.1-SNAPSHOT.jar

# Expose the application port (optional, but helpful)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "taskmanager-0.0.1-SNAPSHOT.jar"]
