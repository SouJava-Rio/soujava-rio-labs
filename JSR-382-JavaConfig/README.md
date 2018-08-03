# Exemplos da JSR-382 - JavaConfig
Aqui estão contribuições de projetos que usam a spec JavaConfig - JSR 382

## Tech Stack
* Java 10
* Maven 3(Versão mínima)
* CDI API - 2.0

## Projetos
Projeto         | Descrição
--------------- | -------------
[SimpleDependencyInjection](https://github.com/SouJava-Rio/soujava-rio-labs/tree/master/JSR-382-JavaConfig/SimpleDependencyInjection/javaconfig) | SimpleDependencyInjection
[SimpleProgrammatic](https://github.com/SouJava-Rio/soujava-rio-labs/tree/master/JSR-382-JavaConfig/SimpleProgrammatic/javaconfig) | Simple Programmatic 

## Links informativos

* Configuration API 1.0 - JSR 382-JCP [Configuration API 1.0 - JSR 382](https://jcp.org/en/jsr/detail?id=382)
* apache/geronimo-config [apache/geronimo-config]( https://github.com/apache/geronimo-config/tree/ConfigJSR) - Umas da Implementações
* Eclipse ConfigJSR [Eclipse ConfigJSR](https://github.com/eclipse/ConfigJSR)


# - Atenção

Para executar o projeto o usuario deve ter os builds localmente do JavaConfig e do Geronimo-config, alem de chamar o main do Weld(org.jboss.weld.environment.se.StartMain)

para isso basta fazer o fork do https://github.com/eclipse/ConfigJSR e do https://github.com/apache/geronimo-config/tree/ConfigJSR
e executar em ambos o comando :

```bash
mvn clean install -DskipTests
```
