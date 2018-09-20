FROM openjdk:8u171-jdk-alpine

ADD /target/SparkJava-sample.jar /opt/SparkJava-sample.jar
ADD /target/dependency-jars/ /opt/dependency-jars/

EXPOSE 8080 
ENTRYPOINT ["java", "-jar", "/opt/SparkJava-sample.jar", "-Djava.net.preferIPv4Stack=true"]
