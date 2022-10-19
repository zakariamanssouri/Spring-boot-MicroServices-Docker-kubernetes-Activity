FROM openjdk:17-alpine
VOLUME /tmp
COPY target/eureka-server-0.0.1-SNAPSHOT.jar /eureka-server.jar
CMD ["java","-jar","/eureka-server.jar","--spring.profiles.active=prod"]
EXPOSE 8761