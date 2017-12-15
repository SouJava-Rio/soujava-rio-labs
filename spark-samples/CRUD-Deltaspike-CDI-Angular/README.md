# SparkJava
Projeto utilizado para exemplificar a utilização do SparkJava

## Tech Stack
* Java 8
* Maven 3(Versão mínima)
* SparkJava 2.7.1
* Docker
* Angular
* CDI
* DeltaSpike
* H2 DataBase
* Json-B

## Executando o projeto

mvn clean package

java -jar SparkJava-sample.jar dentro da pasta target/

# Front-End

dentro da pasta app-jug -> ng serve -open

# Docker

No local do Dockerfile executar :

## BUILD 

sudo docker build -t sparkJava-demo .

logo depois :http://localhost:8080/hello

## executar

sudo docker run --name demo -p 8080:8080 sparkJava-demo

## Para e remover o Container

sudo docker stop demo

sudo docker rm demo
