#!/bin/sh

export JAVA_HOME=CAMINHO-PARA-O-JDK10
export PATH=${JAVA_HOME}/bin:${PATH}
export MAVEN_HOME=CAMINHO-PARA-O-MAVEN
export PATH=${MAVEN_HOME}/bin:${PATH}
export TERRAFORM_HOME=CAMINHO-PARA-O-TERRAFORM
export PATH=$TERRAFORM_HOME:$PATH

mvn clean package 

cp manifest.json target/

cd target/

zip -g helidon-sample.zip libs/*.jar helidon-sample.jar manifest.json 

rm manifest.json

cd ..

mv ./target/helidon-sample.zip ./

echo 'EXECUTANDO O TERRAFORM'

terraform init -input=false

terraform apply -input=false -auto-approve

$SHELL
