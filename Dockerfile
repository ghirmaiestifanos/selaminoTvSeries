FROM openjdk:8-jdk-alpine
RUN mkdir /app
WORKDIR "/app"
EXPOSE 8500
COPY target/selaminoTvSeries.jar /app/
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/selaminoTvSeries.jar"]