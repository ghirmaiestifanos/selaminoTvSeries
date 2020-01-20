FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8500
ARG JAR_FILE=target/selaminoTvSeries.jar
COPY ${JAR_FILE} selaminoTvSeries.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/selaminoTvSeries.jar"]