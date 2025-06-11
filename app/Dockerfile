# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src
# ENV KAFKA_BROKER_URL=127.0.0.1

RUN mvn clean package -DskipTests

# Stage 2: Production
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8084

CMD ["java", "-jar", "app.jar"]
