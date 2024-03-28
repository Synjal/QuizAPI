FROM eclipse-temurin:17

WORKDIR /app

EXPOSE 8080

COPY target/api_quizz_cda-0.0.1-SNAPSHOT.jar /app/api.jar

ENTRYPOINT ["java", "-jar", "api.jar"]
