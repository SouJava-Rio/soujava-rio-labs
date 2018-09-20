#!/bin/sh

echo "

███████╗ ██████╗ ██╗   ██╗     ██╗ █████╗ ██╗   ██╗ █████╗ 
██╔════╝██╔═══██╗██║   ██║     ██║██╔══██╗██║   ██║██╔══██╗
███████╗██║   ██║██║   ██║     ██║███████║██║   ██║███████║
╚════██║██║   ██║██║   ██║██   ██║██╔══██║╚██╗ ██╔╝██╔══██║
███████║╚██████╔╝╚██████╔╝╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║
╚══════╝ ╚═════╝  ╚═════╝  ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝
                                                           
"


echo Iniciando o Conteiner MongoDB...

printf "\n"


docker run -it -d --rm --name mongo --network my-net -p 27017:27017 -v data/db:/data/db mongo:latest

printf "\n"

echo Conteiner MongoDB Iniciado

printf "\n"

sleep 5 

echo Iniciando o Conteiner danieldiasjava/mvc-jnosql-crud...

printf "\n"

docker run --rm  -d --name mvc -p 8080:8080 -h localhost --network my-net soujavario/mvc-jnosql-crud:latest

printf "\n"

echo  Aguardando o Conteiner danieldiasjava/mvc-jnosql-crud iniciar...

sleep 25

printf "\n"

echo Conteiner danieldiasjava/mvc-jnosql-crud Iniciado

printf "\n"

echo abrindo o navegador com o seguinte URL http://localhost:8080/MVC1.0.Ozark-0.0.1-SNAPSHOT

printf "\n"

xdg-open http://localhost:8080/MVC1.0.Ozark-0.0.1-SNAPSHOT

$SHELL
