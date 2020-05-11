FROM openjdk:8-jdk-alpine
WORKDIR /app
ARG JAR_VERSION=1.0-SNAPSHOT
ARG JAR_NAME=server
COPY ${JAR_FILE} app.jar
COPY server/target/${JAR_NAME}-${JAR_VERSION}.jar server.jar
COPY docker/scripts/wait-for-it.sh wait-for-it.sh
USER root
# RUN apt-get -q update && apt-get -qy install netcat
RUN chmod +x wait-for-it.sh
RUN ls
ENTRYPOINT ["sh", "-c", "./wait-for-it.sh", "chat-server-db:7000", "--", "java","-jar","server.jar"]