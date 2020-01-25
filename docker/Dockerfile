FROM openjdk:8-jdk-alpine
EXPOSE 8500
COPY /target/selaminotvseries.jar /selaminotvseries.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/selaminoTvSeries.jar"]