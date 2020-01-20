FROM openjdk:alpine
VOLUME /tmp
ADD target/selaminoTvSeries.jar /app/app.jar
EXPOSE 8500
ENTRYPOINT ["java","-jar","/app/app.jar"]