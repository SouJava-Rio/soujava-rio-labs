FROM openjdk:8u171-jdk-alpine

ADD /target/Servlet4-sample-microbundle.jar /opt/servlet4.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/servlet4.jar", "-Djava.net.preferIPv4Stack=true"]
