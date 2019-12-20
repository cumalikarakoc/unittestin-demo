FROM openjdk:11
EXPOSE 8080
COPY target/unit-testing-demo-1.0-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]