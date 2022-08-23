FROM openjdk:11
ADD target/sistema-vacunas-backend-0.0.1-SNAPSHOT.jar springboot-vacunasinventario.jar
ENTRYPOINT ["java","-jar","springboot-vacunasinventario.jar"]