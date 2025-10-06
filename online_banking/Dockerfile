FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/digital-banking.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]