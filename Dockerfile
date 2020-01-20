FROM openjdk:8-jdk-alpine
EXPOSE 8500
COPY target/selaminoTvSeries.jar /selaminoTvSeries.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/selaminoTvSeries.jar"]