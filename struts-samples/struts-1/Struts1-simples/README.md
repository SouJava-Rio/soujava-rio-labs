# Exemplo Struts 1

## Tech Stack
* Java 8
* Maven 3(Versão mínima)
* Struts 1.3
* Docker
* Payara-micro

## Executando o projeto

mvn clean install payara-micro:bundle - para gerar o uber-Jar

mvn  payara-micro:start - para executar o app

ou java -jar Struts1-simples-microbundle.jar dentro da pasta target/

URL -> http://locahost:8080/Struts-1-simples-0.0.1-SNAPSHOT

# Docker

No local do Dockerfile executar :

## BUILD 

sudo docker build -t struts1-demo .

logo depois :

## executar

sudo docker run --name demo -p 8080:8080 -h localhost struts1-demo

acesse a URL -> http://locahost:8080/Struts-1-simples-0.0.1-SNAPSHOT

## Para e remover o Container

sudo docker stop demo

sudo docker rm demo
