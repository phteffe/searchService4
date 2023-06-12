FROM maven:3.9-eclipse-temurin-20 as build
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM eclipse-temurin:20-jre-alpine
COPY --from=build /target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
