# Documentación Prueba Técnica W2M
El método de seguridad esta creado pero no lo he implementado porque solo deja hacer peticiones get indicando un usuario y contraseña, con los demás métodos no funciona y da error 401.

## Rutas
    GET -> http://localhost:8080/naves
    GET -> http://localhost:8080/naves/{ID}
    GET -> http://localhost:8080/naves/{name}
    POST -> http://localhost:8080/naves Hay que pasarle un json por el body no es necesario indicar ID
    PUT -> http://localhost:8080/naves/edit Hay que pasarle un json por el body indicando la ID
    DELETE -> http://localhost:8080/naves/{ID}


- Arquitectura de Carpetas
    - /model/Nave.java -> Contiene el modelo de la base de datos y el objeto a crear.
    - /repository/NaveRepository.java -> Interfaz que extiende de JPA para crear el CRUD.
    - /controller/NaveController.java -> Contiene las rutas y las llamadas a los métodos.
    - /service/NaveService.java -> Contiene los métodos que intoducen la información a la BBDD.
    - /navecache/NaveCacheConfig -> 
    - /aspect/AspectConfig.java -> Contiene la excepción de números negativos.
    - /exception/GeneralException.java -> Contiene la excepxión general.
    - /SecurityConfig.java -> Configuración de autenticación básica.

    - /resources/application.properties -> Contiene la configuración del servidor.
    - /resources/db.changelog/changelog-master.xml -> Configuración para liquibase.
    - /resources/db.changelog/changelog-v1.0.xml -> Configuración del esquema de BBDD

    - /tests/NaveServiceTests -> Contiene los tests unitarios.
    - /tests/controller/application-test.properties -> Contiene la configuración del servidor para los tests.
    - /tests/controller/NaveControllerTest.java -> Contiene los tests de integración.
    - /tests/controller/TestSecurityConfig.java -> Configuración de autenticación básica para los tests.

## Dependencias
    Dependencias Usadas
    - Spring Web
    - Devtools
    - Logging
    - Spring AOP
    - Spring Context
    - Spring Context Support
    - Spring Security
    - Spring Caché

    - h2 Database 
    - Starter Data JPA
    - LiquiBase

    - Spring Test
    - Junit-Jupiter-Api
    - Jackson Databind

    
