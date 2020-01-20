FROM openjdk:8-jdk-alpine
ADD ./target/selaminoTvSeries.jar selaminoTvSeries.jar
EXPOSE 8500
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/selaminoTvSeries.jar"]