FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/mc-comment.jar /app/mc-comment.jar

CMD ["java", "-jar", "/app/mc-comment.jar"]

EXPOSE 8082