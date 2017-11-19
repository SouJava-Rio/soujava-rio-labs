# Exemplo MicroProfile-Payara-Micro


## Executando o projeto

mvn clean install payara-micro:bundle - para gerar o uber-Jar

mvn  payara-micro:start - para executar o app

ou java -jar microprofile-sample-microbundle.jar dentro da pasta target/

URL -> http://locahost:8080/microprofile-payara-0.0.1-SNAPSHOT/app/JUG

# Docker

No local do Dockerfile executar :

## BUILD 

sudo docker build -t microprofile-payara-demo .

logo depois :

## executar

sudo docker run --name demo -p 8080:8080 -h localhost microprofile-payara-demo

acesse a URL -> http://localhost:8080/microprofile-payara-0.0.1-SNAPSHOT/app/JUG

## Para e remover o conteiner

sudo docker stop demo

sudo docker rm demo

## Links informativos

* Leonéia Evangelista. - [O que é o HTTP2 e quais os seus benefícios?](https://www.kinghost.com.br/blog/2017/04/o-que-e-o-http2-e-quais-os-seus-beneficios/)
* Java Servlet 4 [Java Servlet 4](http://jcp.org/en/jsr/detail?id=369)

## Links informativos

* Payara-Micro [Payara-Micro](https://www.payara.fish/payara_micro)
