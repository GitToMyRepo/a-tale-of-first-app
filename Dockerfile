FROM openjdk:17-oracle
WORKDIR /app
COPY target/a-tale-of-first-app-0.0.1-SNAPSHOT.jar first-app.jar
ENTRYPOINT ["java", "-jar", "first-app.jar"]