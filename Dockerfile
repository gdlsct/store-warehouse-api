FROM gradle:8.10.1-jdk21-alpine as builder
WORKDIR /app
COPY . /app/.
RUN gradle build -x test

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "/app/*.jar"]