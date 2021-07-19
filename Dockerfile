FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim

COPY /target/micronaut-java-*.jar /opt/micronaut-java.jar

EXPOSE 8080

CMD ["java", "-Dcom.sum.management.jmxremote", "-Xmx128m", "-XX:+IdeTuningGcOnIdle", "-Xtune:virtualized", "-jar", "/opt/micronaut-java.jar"]

ENV APP_NAME="Micronaut JAVA"
ENV APP_URL="http://localhost"

ENV DB_DRIVER=org.postgresql.Driver
ENV DB_HOST="http://localhost"
ENV DB_PORT="5432"
ENV DB_NAME="java"
ENV DB_USER="postgres"
ENV DB_PASSWORD="password"
