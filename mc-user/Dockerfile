FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/mc-user.jar /app/mc-user.jar

CMD ["java", "-jar", "/app/mc-user.jar"]

EXPOSE 8080