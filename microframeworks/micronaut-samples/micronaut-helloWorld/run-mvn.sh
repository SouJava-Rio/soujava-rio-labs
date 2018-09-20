#!/bin/sh

echo "

███████╗ ██████╗ ██╗   ██╗     ██╗ █████╗ ██╗   ██╗ █████╗ 
██╔════╝██╔═══██╗██║   ██║     ██║██╔══██╗██║   ██║██╔══██╗
███████╗██║   ██║██║   ██║     ██║███████║██║   ██║███████║
╚════██║██║   ██║██║   ██║██   ██║██╔══██║╚██╗ ██╔╝██╔══██║
███████║╚██████╔╝╚██████╔╝╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║
╚══════╝ ╚═════╝  ╚═════╝  ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝
                                                           
"

echo Fazendo build do projeto....

printf "\n"

#trocar para a sua instalação

export JAVA_HOME=/home/daniel/desenvolvimento/jdk-10.0.2
export PATH=${JAVA_HOME}/bin:${PATH}
export MAVEN_HOME=/home/daniel/desenvolvimento/apache-maven-3.5.4
export PATH=${MAVEN_HOME}/bin:${PATH}

mvn clean package 

printf "\n"

echo Build finalizado.

$SHELL
