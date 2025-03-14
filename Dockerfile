FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
COPY libs ./libs
RUN mvn clean package -DskipTests -B

FROM openjdk:11-jre-slim
WORKDIR /app

COPY --from=build /build/target/userService.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-jar", "app.jar"]
