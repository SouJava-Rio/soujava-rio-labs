FROM openjdk:8u171-jdk-alpine

ADD /target/microprofile-sample-microbundle.jar /opt/microprofile-sample.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/microprofile-sample.jar"]
