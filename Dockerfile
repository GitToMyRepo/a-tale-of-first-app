FROM openjdk:17-oracle
WORKDIR /app
COPY target/simple-consumer-app-0.0.1-SNAPSHOT.jar consumer-app.jar
ENTRYPOINT ["java", "-jar", "consumer-app.jar"]