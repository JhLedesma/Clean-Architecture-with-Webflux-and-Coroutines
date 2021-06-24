# Clean-architecture with webflux and coroutines
En este proyecto combinamos lo mejor de dos mundos. Una arquitectura limpia y programacion non-blocking

## Articulo

* #### [Medium](https://jesusledesma.medium.com/migrando-a-clean-architecture-webflux-con-corrutinas-en-kotlin-parte-1-ec382b933438)

## Sobre este proyecto

### Tecnologias utilizadas:
  * Kotlin Coroutines
  * Spring Boot Weblux
  * Gradle
  * JDK 11
  * MongoDB

### Consultas
* Jesus Ledesma (jh.ledesmaa@gmail.com)

## Ejecución de la aplicación

### IDE
Asegurarse que intellij o su IDE de preferencia este configurado para leer gradle-wrapper.
Dirigirse a ```File | Settings | Build, Execution, Deployment | Build Tools | Gradle ```

Las opciones `build` y `run` con el valor `IntelliJ`. La opcion `Use Gradle From` con el valor `gradle-wrapper.properties`

Con esta configuracion puede ejecutar el proyecto desde su IDE. En caso de querer hacerlo con gradle seguir las instrucciones alternativas que se ven aqui debajo

### Gradle
```
./gradlew bootRun
```
El servidor levantará en el puerto 8080