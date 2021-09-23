FROM openjdk:8-jdk-alpine
COPY target/challengerFeira-0.0.1-SNAPSHOT.jar challengerFeira-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/challengerFeira-0.0.1-SNAPSHOT.jar"]