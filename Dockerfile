FROM openjdk:8-jdk-alpine
WORKDIR "/app"
EXPOSE 8500
COPY target/*.jar ./app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","selaminoTvSeries.jar"]