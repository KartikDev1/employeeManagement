# Use an official Java runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/employeeManagement-0.0.1-SNAPSHOT.jar employeeManagement.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
