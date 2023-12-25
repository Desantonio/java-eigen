# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk-alpine

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the Maven project files (including the POM file) into the container
COPY pom.xml /usr/src/app/

# Copy the source code into the container
COPY src /usr/src/app/src

# Copy the target directory (containing the compiled classes and JAR file) into the container
COPY target /usr/src/app/target

# Run the application
CMD ["java", "-cp", ".:/usr/src/app/target/your-jar-file.jar", "org.example.Main"]
