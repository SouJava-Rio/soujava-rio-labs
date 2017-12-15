# SparkJava
Projeto utilizado para exemplificar a utilização do SparkJava

## Tech Stack
* Java 8
* Maven 3(Versão mínima)
* SparkJava 2.7.1
* Docker
* Angular

## Executando o projeto

mvn clean package

java -jar SparkJava-sample.jar dentro da pasta target/

depoois -> http://localhost:8080/hello

# Docker

No local do Dockerfile executar :

## BUILD 

sudo docker build -t sparkJava-demo .

logo depois :http://localhost:8080/hello

## executar

sudo docker run --name demo sparkJava-demo

## Para e remover o Container

sudo docker stop demo

sudo docker rm demo
