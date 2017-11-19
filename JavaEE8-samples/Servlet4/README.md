# Servlet 4
Projeto utilizado para exemplificar a utilização de Server Push/HTTP2 

## Tech Stack
* Java 8
* Maven 3(Versão mínima)
* Servlet 4 
* Docker
* Payara-micro

## Executando o projeto

mvn clean install payara-micro:bundle - para gerar o uber-Jar

mvn  payara-micro:start - para executar o app

ou java -jar Servlet4-sample-microbundle.jar dentro da pasta target/

URL -> http://localhost:8080/Servlet4-sample-1.0/

# Docker

No local do Dockerfile executar :

## BUILD 

sudo docker build -t servlet4-demo .

logo depois :

## executar

sudo docker run --name demo -p 8080:8080 -h localhost servlet4-demo

acesse a URL -> http://localhost:8080/Servlet4-sample-1.0/

## Para e remover o Container

sudo docker stop demo

sudo docker rm demo

## Links informativos

* Leonéia Evangelista. - [O que é o HTTP2 e quais os seus benefícios?](https://www.kinghost.com.br/blog/2017/04/o-que-e-o-http2-e-quais-os-seus-beneficios/)
* Java Servlet 4 [Java Servlet 4](http://jcp.org/en/jsr/detail?id=369)
