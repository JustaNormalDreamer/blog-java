FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
COPY build/libs/micronaut-java-*-all.jar micronaut-java.jar
EXPOSE 8080
CMD ["java", "-Dcom.sum.management.jmxremote", "-Xmx128m", "-XX:+IdeTuningGcOnIdle", "-Xtune:virtualized", "-jar", "micronaut-java.jar"]
