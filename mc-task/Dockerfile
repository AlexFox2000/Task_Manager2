# Используем базовый образ OpenJDK
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR файл в контейнер
COPY target/mc-task.jar /app/mc-task.jar

# Указываем команду для запуска приложения
CMD ["java", "-jar", "/app/mc-task.jar"]

# Открываем порт, который используется приложением
EXPOSE 8081
