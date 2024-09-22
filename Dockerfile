FROM openjdk:17-jdk-slim
#ENV SERVER_PORT=8087
WORKDIR /app
COPY target/*.jar /app/web.jar
ENTRYPOINT ["java", "-jar", "web.jar"]
