FROM openjdk:8-jdk-alpine
MAINTAINER sohama4@gmail.com
USER root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /app
ARG JAR_VERSION=1.0-SNAPSHOT
ARG JAR_NAME=server
COPY server/target/${JAR_NAME}-${JAR_VERSION}.jar server.jar
COPY docker/scripts/wait-for-it.sh wait-for-it.sh