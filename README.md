# Mutantes

Challenge MercadoLibre

## API REST

Recibe un Json que representa una secuencia de ADN.
- ### Mutant: 
Devuelve **200-OK** si encuentra más de una secuencia de cuatro letras iguales, en forma oblicua, horizontal o vertical.\
Caso contrario devuelve **403-Forbidden**.

**POST** --> [http://ec2-18-229-125-208.sa-east-1.compute.amazonaws.com:8080/mutant/](http://ec2-18-229-125-208.sa-east-1.compute.amazonaws.com:8080/mutant/)

#### ADN Mutante 👾
>###### Request
>```sh
>{
> "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
>}
>```

>###### Response
>```sh
>200-OK
>```
#### ADN Humano 👦🏻
>###### Request
>```sh
>{
>"dna":["ATGCGA","CAGTCC","TTGTGT","AGAAGG","CTCCTA","TCACTG"]
>}
>```

>###### Response
>```sh
>400-Forbidden
>```


- ### Stats
Devuelve la cantidad de mutantes registrados en la base de datos.

**GET** --> [http://ec2-18-229-125-208.sa-east-1.compute.amazonaws.com:8080/stats/](http://ec2-18-229-125-208.sa-east-1.compute.amazonaws.com:8080/stats/)

#### Estadísticas 📊

>###### Response
>```sh
>200-OK
>```
>```sh
>{
>    "count_mutant_dna": 25,
>    "count_human_dna": 100,
>    "ratio": 0.25
>}
>```

## Tecnología

- [Java 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [Spring Boot](https://start.spring.io/)
- [Maven](https://maven.apache.org/)
- [IntelliJ IDEA](https://https://www.jetbrains.com/es-es/idea/)
- [Git](http://https://git-scm.com/)
- [AWS](https://aws.amazon.com/)
- [MongoDB](https://www.mongodb.com/es)
- [JUnit 5](https://junit.org/junit5/)
- [Postman](https://www.postman.com/downloads/)

## Environment

Comandos para configurar el ambiente en Unix

```sh
## Java
$ sudo apt-get install default-jre
$ java -version
## MondoDB
$ sudo apt install -y mongodb
$ sudo systemctl status mongodb
$ mongo --eval 'db.runCommand({ connectionStatus: 1 })'
## API Mutantes
$ git clone https://github.com/nahuelavalos/mutants.git
$ cd mutants/
$ mvn clean package
$ mvn spring-boot:run
```

## Run

Comandos para correr la API REST. 

Por defecto queda levantada en  [http://localhost/8080/](http://localhost/8080/)

```sh
$ java -jar master-mutants-1.2.0.jar
```
