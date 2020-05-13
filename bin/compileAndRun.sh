#!/bin/bash
echo "Running: mvn clean install"
mvn clean install

echo "Running: docker-compose build chat-server"
docker-compose build chat-server

echo "Running: docker-compose run --service-ports chat-server"
docker-compose run --service-ports chat-server