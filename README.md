<p align="center">
  <a href="https://spring.io/" target="blank"><img src="https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg" width="200" alt="Spring Logo" /></a>
</p>

<!-- estas instrucciones permitira que otro desarrollador puedan ejecutar -->
# Nota
* Se esta usando un repositorio de base de datos en la nube: [ElephantSQL](https://www.elephantsql.com/)


# Ejecutar en desarrollo(forma 1)
1. Tener docker instalado:
* [Docker Desktop](https://www.docker.com/get-started)
2. Clonar el repositorio de github
3. Ejecutar de archivo Dockerfile, para construir la imagen, con todas las dependencia, usando el comando en consola en la raíz del proyecto:
```
docker buil -t inventario_vacunacion:1.0 .
```
4. Finalmente, para correr el contenedor, usando el comando en consola en la raíz del proyecto:
```
docker run -p:8081:8080 inventario_vacunacion:1.0
```
# Ejecutar en desarrollo(forma 2)
1. Clonar el repositorio de github
2. Finalmente, abrir en la termina la ruta /target del proyecto(en esta ruta es donde se encuentra empaquetado el archivo .jar del proyecto), ejecutar el comando:
```
java -jar sistema-vacunas-backend-0.0.1-SNAPSHOT.jar
```
## Stack usado
* Spring boot
* Postgresql