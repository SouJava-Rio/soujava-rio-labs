FROM openjdk:8u171-jdk-alpine

ADD /target/microprofile-sample-swarm.jar /opt/demo-swarm.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/demo-swarm.jar", "-Djava.net.preferIPv4Stack=true"]
