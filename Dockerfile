FROM openjdk:8-jdk-alpine
RUN addgroup -S qhala && qhala -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/qhala.jar"]