FROM openjdk:17-alpine
VOLUME /tmp
COPY target/billing*-0.0.1-SNAPSHOT.jar /billing-micro-service.jar
CMD ["java","-jar","/billing-micro-service.jar","--spring.profiles.active=prod"]
EXPOSE 8083