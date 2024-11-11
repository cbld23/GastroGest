Instrucciones para ejecutar la aplicación.

Este proyecto consiste en una aplicación Java Spring Boot que utiliza una base de datos PostgreSQL alojada en un contenedor Docker. 
La API está documentada con Swagger para facilitar su uso, en este caso será una aplicación Angular que actuará como frontend. 
A continuación se describen los pasos necesarios para ejecutar tanto la aplicación como la base de datos usando Docker y la JVM.

Requisitos previos
Antes de comenzar, asegúrate de tener instalados los siguientes programas en tu máquina:

Git para clonar el repositorio.
Docker para ejecutar la base de datos PostgreSQL.
Java 21+ (se recomienda JDK 21) para ejecutar la aplicación Spring Boot.
Maven para compilar y empaquetar la aplicación Spring Boot.

Pasos de ejecución
1. Clonar el repositorio a tu máquina local:
Ejecutar en una terminal:
git clone https://github.com/cbld23/product-catalog.git
cd product-catalog

2. Levantar la base de datos PostgreSQL usando Docker:
Ejecutar en una terminal:
docker-compose up -d
Esto descargará la imagen de PostgreSQL (si no la tienes) y levantará el contenedor en segundo plano.

3. Compilar y ejecutar la aplicación Spring Boot
Ejecutar en una terminal:
mvn clean install
Ejecuta la aplicación con el siguiente comando:
mvn spring-boot:run
Esto iniciará la aplicación en la JVM, por defecto en el puerto 8080.

4. Una vez que la aplicación esté corriendo, los endpoints de la API estan accesibles en:
http://localhost:8080/api

5. Es posible acceder a la API documentada con Swagger directamente desde el navegador y realizar llamadas en:
http://localhost:8080/swagger-ui.html

6. Detener los servicios
Detener el contenedor de Docker:
Ejecutar el siguiente comando:
docker-compose down
Detener la aplicación Spring Boot:
En el terminal donde se está ejecutando la aplicación, presiona Ctrl+C.