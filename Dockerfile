FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY build/libs/stream-trades-0.0.1-SNAPSHOT.jar build/app.jar
EXPOSE 8090

WORKDIR /app/build
ENTRYPOINT java -jar app.jar