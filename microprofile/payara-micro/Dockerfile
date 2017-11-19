FROM jboss/base-jdk:8

ADD /target/microprofile-sample-microbundle.jar /opt/microprofile-sample.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/microprofile-sample.jar", "-Djava.net.preferIPv4Stack=true"]
