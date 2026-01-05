# Start with a base image containing Java runtime
FROM eclipse-temurin:21-jre-jammy

# Information around who maintains the image
MAINTAINER stack.com

# Add the application's jar to the image
COPY target/loans-0.0.1-SNAPSHOT.jar loans-0.0.1-SNAPSHOT.jar

# Execute the application
ENTRYPOINT ["java", "-jar", "loans-0.0.1-SNAPSHOT.jar"]
