FROM openjdk:8-jdk-alpine
EXPOSE 8500
COPY selaminoTvSeries.jar /selaminoTvSeries.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/selaminoTvSeries.jar"]