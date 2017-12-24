# Exemplo MVC-SPEC-FORM

## Tech Stack
* Java 8
* Maven 3(Versão mínima)
* Micro-Profile
* Docker
* Wildfly-Swarm
* Payara-Micro

## Executando o projeto

* Payara-micro
mvn clean install -P payara payara-micro:bundle && mvn -P payara payara-micro:start

ou java -jar *.jar dentro da pasta target/

* Wildfly-Swarm

mvn clean package -P wildfly - para gerar o uber-Jar

java -jar *.jar dentro da pasta target/

URL -> http://localhost:8080/

# Docker

No local do Dockerfile executar :

## BUILD 

sudo docker build -t MVC-demo . 

logo depois :

## executar

sudo docker run --name demo -p 8080:8080 -h localhost MVC-demo

acesse a URL -> http://localhost:8080/

## Para e remover o Container

sudo docker stop demo

sudo docker rm demo

