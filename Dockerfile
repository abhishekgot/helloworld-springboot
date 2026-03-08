# ---------- Stage 1: Build ----------
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /build

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the jar
#RUN mvn clean package -DskipTests
RUN mvn -q clean package -DskipTests

# Stage 2 — Runtime container
FROM eclipse-temurin:21-jre
#FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copy the jar from build stage
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8080

#ENTRYPOINT ["java","-jar","app.jar"]
ENTRYPOINT ["java","-jar","/app/app.jar"]