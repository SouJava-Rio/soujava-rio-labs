FROM openjdk:8u171-jdk-alpine

ADD /target/Json-B-sample.jar /opt/Json-B-sample.jar
ADD /target/dependency-jars/ /opt/dependency-jars/

ENTRYPOINT ["java", "-jar", "/opt/Json-B-sample.jar", "-Djava.net.preferIPv4Stack=true"]
