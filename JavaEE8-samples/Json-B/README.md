# JSON-B
Projeto utilizado para exemplificar a utilização do JSON-B

## Tech Stack
* Java 8
* Maven 3(Versão mínima)
* JSON-B 
* Docker

## Executando o projeto

mvn clean package

java -jar Json-B-sample.jar dentro da pasta target/

### saida


```json
Serializando a Classe

{
    "descricao": "Comunidade Java do Rio",
    "leaders": [
        "Daniel Dias",
        "Paulo Sim?es",
        "Ulisses Telemaco"
    ],
    "localidade": {
        "estado": "RJ",
        "pais": "Brasil"
    },
    "nome": "SouJava-Rio"
}
```
```bash
Deserializar a Classe

JUG(nome=SouJava-Rio, leaders=[Daniel Dias, Paulo Sim?es, Ulisses Telemaco], 
descricao=Comunidade Java do Rio, localidade=Localidade(estado=RJ, pais=Brasil))
```

# Docker

No local do Dockerfile executar :

## BUILD 

sudo docker build -t jsonb-demo .

logo depois :

## executar

sudo docker run --name demo jsonb-demo

## Para e remover o Container

sudo docker stop demo

sudo docker rm demo

## Links informativos

* JSON-B [JSON-B](http://json-b.net/index.html)
