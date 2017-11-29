# Exemplo MicroProfile-KumuluzEE

## Tech Stack
* Java 8
* Maven 3(Versão mínima)
* Jax-RS,CDI,JSON-P 
* Docker
* KumuluzEE

## Executando o projeto



# Docker

No local do Dockerfile executar :

## BUILD 

sudo docker build -t microprofile-kumuluzee-demo . 

logo depois :

## executar

sudo docker run --name demo -p 8080:8080 microprofile-kumuluzee-demo

acesse a URL -> 

## Para e remover o Container

sudo docker stop demo

sudo docker rm demo

## Links informativos

* KumuluzEE[https://ee.kumuluz.com/](https://ee.kumuluz.com/)
