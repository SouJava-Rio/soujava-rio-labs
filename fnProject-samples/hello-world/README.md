# Hello-World
Projeto utilizado para exemplificar a utilização de FDK-Java

## Tech Stack
* Java 8
* Maven 3(Versão mínima)
* Docker >= 17.05 

## Executando o projeto

### 1 - Instalar o Fn CLI 
```bash 
curl -LSs https://raw.githubusercontent.com/fnproject/cli/master/install | sh 
```

### 2 - executando 
    ```bash
    fn --verbose run
  ```

  ```json
{
"jug":"SouJava-Rio",
"lideres":["Daniel","Paulo","Ulisses"],
"localidade":
    {
    "estado":"Rio de Janeiro","pais":"Brasil"
    }
}
```
### 4 - modo http 
 - Em um ternimal digitar fn start para inicar o servidor.
 - abra outra aba do terminal e digite o seguinte comando : 
   fn deploy --app nomeDaMinhaAPP --local
 - logo depois executar -> fn call nomeDaMinhaAPP /hello-world

 ou via browser -> http://localhost:8080/r/nomeDaMinhaAPP/hello-world 

## Links informativos

* Adam Bien - [Serverless Java with Java Function Developer Kit (FDK)](https://www.youtube.com/watch?v=eWvj8ZVE5To)
* cloud21 -  [o-que-e-arquitetura-serverless](https://cloud21.com.br/computacao-em-nuvem/o-que-e-arquitetura-serverless/)
* Martin Fowler  [Serverless Architectures]https://martinfowler.com/articles/serverless.html)
