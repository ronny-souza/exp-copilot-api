FROM maven:3.8.3-openjdk-17 AS build

COPY src app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests

FROM openjdk:17-alpine

workdir /app
COPY --from=build /app/target/*.jar /app/app.jar

ENV DB_HOST 127.0.0.1:3306
ENV DB_NAME copilot
ENV DB_USERNAME ronyeri
ENV DB_PASSWORD ronyeri

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
