# Exemplo MicroProfile-Wildfly-Swarm

## Tech Stack
* Java 8
* Maven 3(Versão mínima)
* Jax-RS,CDI,JSON-P 
* Docker
* Wildfly-Swarm

## Executando o projeto

mvn clean package  - para gerar o uber-Jar

mvn  wildfly-swarm:run - para executar o app

ou java -jar microprofile-sample-swarm.jar dentro da pasta target/

URL -> http://locahost:8080/app/JUG

# Docker

No local do Dockerfile executar :

## BUILD 

sudo docker build -t microprofile-swarm-demo . 

logo depois :

## executar

sudo docker run --name demo -p 8080:8080 microprofile-swarm-demo

acesse a URL -> http://locahost:8080/app/JUG

## Para e remover o Container

sudo docker stop demo

sudo docker rm demo

## Links informativos

* Wildfly-Swarm[wildfly-swarm.io](http://wildfly-swarm.io/)

* Wildfly Microprofile Config [wildfly-microprofile-config](https://github.com/wildfly-extras/wildfly-microprofile-config)
