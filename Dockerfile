FROM clojure:openjdk-8-lein AS builder

COPY src /usr/app/src
COPY project.clj /usr/app

WORKDIR /usr/app

RUN lein uberjar

FROM openjdk:8u265-jre

COPY --from=builder /usr/app/target/*-standalone.jar app.jar

EXPOSE 9080

ENTRYPOINT java -jar app.jar
