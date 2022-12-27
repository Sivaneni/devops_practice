FROM openjdk:8-jdk-alpine 
VOLUME /tmp 
COPY target/PhotoAppDiscoveryService-0.0.1-SNAPSHOT.jar eureka.jar 
ENTRYPOINT ["java","-jar","eureka.jar"] 