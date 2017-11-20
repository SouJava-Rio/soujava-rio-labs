FROM jboss/base-jdk:8

ADD /target/Struts1-simples-microbundle.jar /opt/Struts1-sample.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/Struts1-sample.jar", "-Djava.net.preferIPv4Stack=true"]
