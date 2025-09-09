FROM eclipse-temurin:24-jdk-alpine AS build

WORKDIR /app
COPY . .
RUN apk add --no-cache maven
RUN mvn clean package -DskipTests

FROM eclipse-temurin:24-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080


CMD ["java", "-jar", "app.jar"]

# Desenvolvimento
#CMD ["./mvnw", "spring-boot:run"]