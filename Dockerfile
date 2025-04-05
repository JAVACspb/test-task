# Используем базовый образ с OpenJDK 8 (JRE)
FROM openjdk:8-jre-alpine

# Определяем рабочую директорию внутри контейнера
WORKDIR /app

# Указываем переменную, где находится jar-файл, собранный Maven (убедитесь, что вы выполнили mvn package)
ARG JAR_FILE=target/test-task-0.0.1-SNAPSHOT.jar

# Копируем jar-файл в контейнер и переименовываем его в app.jar
COPY ${JAR_FILE} app.jar

# Открываем порт 8080 для доступа к приложению
EXPOSE 8080

# Задаем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
