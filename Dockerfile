FROM openjdk:21

WORKDIR /app
COPY . .

COPY target/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar", "ru.ziplla.basi_dannih.BasiDannihApplication", "--spring.config.location=src/main/resources/application.properties"]