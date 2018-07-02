# Exemplo MicroProfile-KumuluzEE

## Tech Stack
* Java 8
* Maven 3(Versão mínima)
* Jax-RS,CDI,JSON-P 
* Docker
* KumuluzEE

## Executando o projeto

mvn clean package  - para gerar o uber-Jar

java -jar KumuluzEE-0.0.1-SNAPSHOT.jar dentro da pasta target/

URL -> http://locahost:8080/app/JUG

# Docker

No local do Dockerfile executar :

## BUILD 

sudo docker build -t microprofile-kumuluzEE-demo . 

logo depois :

## executar

sudo docker run --name demo -p 8080:8080 microprofile-kumuluzEE-demo

acesse a URL -> http://locahost:8080/app/JUG

acessar o MicroProfile OpenAPI -> http://localhost:8080/openapi
## Para e remover o Container

sudo docker stop demo

sudo docker rm demo

## Links informativos

* KumuluzEE[http://ee.kumuluz.com/](http://ee.kumuluz.com/)
