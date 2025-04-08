FROM openjdk:8-jre-alpine

WORKDIR /app

ARG JAR_FILE=target/test-task-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
