FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
WORKDIR usr/app
COPY --from=build ${JAR_FILE} qhala-library-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/qhala-library-0.0.1-SNAPSHOT.jar"]
