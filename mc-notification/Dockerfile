FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/mc-notification.jar /app/mc-notification.jar

CMD ["java", "-jar", "/app/mc-notification.jar"]

EXPOSE 8083