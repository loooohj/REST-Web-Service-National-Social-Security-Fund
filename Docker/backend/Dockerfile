#Build stage
FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -Dskiptests

#Runtime stage
FROM amazoncorretto:17
ARG PROFILE=dev
ARG APP_VERSION=1.0.0
#define few things
WORKDIR /app
COPY --from=build /build/target/prodcnss-*.jar /app/app

EXPOSE 8585

ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}
CMD java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} prodcnss-${JAR_VERSION}.jar