FROM openjdk:alpine
ADD target/selaminoTvSeries.jar ./selaminoTvSeries.jar
EXPOSE 8500
ENTRYPOINT ["java","-jar","selaminoTvSeries.jar"]