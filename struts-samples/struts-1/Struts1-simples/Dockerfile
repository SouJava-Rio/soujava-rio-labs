FROM openjdk:8u171-jdk-alpine

ADD /target/Struts1-simples-microbundle.jar /opt/Struts1-sample.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/Struts1-sample.jar", "-Djava.net.preferIPv4Stack=true"]
