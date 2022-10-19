FROM openjdk:17-alpine
VOLUME /tmp
ADD target/customer-micro-service-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java","-jar","/app.jar","--spring.profiles.active=prod"]
EXPOSE 8082