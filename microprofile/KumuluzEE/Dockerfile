FROM openjdk:8u171-jdk-alpine

ADD /target/KumuluzEE-0.0.1-SNAPSHOT.jar /opt/demo-kumuluzEE.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/demo-kumuluzEE.jar", "-Djava.net.preferIPv4Stack=true"]
