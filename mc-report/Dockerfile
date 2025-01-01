FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/mc-report.jar /app/mc-report.jar

CMD ["java", "-jar", "/app/mc-report.jar"]

EXPOSE 8084
