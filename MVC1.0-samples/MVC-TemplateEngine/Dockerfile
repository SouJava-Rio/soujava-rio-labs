FROM jboss/base-jdk:8

ADD /target/*.jar /opt/demo.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/demo.jar", "-Djava.net.preferIPv4Stack=true"]
