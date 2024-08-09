FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/GoKapture_Assignment-0.0.1-SNAPSHOT.jar GoKapture_Assignment.jar
ENTRYPOINT ["java","-jar","/GoKapture_Assignment.jar"]