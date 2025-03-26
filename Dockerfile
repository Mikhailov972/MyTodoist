FROM openjdk:21-jdk
COPY build/libs/taskService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]