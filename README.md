# Event Driven Microservices Conductor

Este es un ejemplo de uso para la orquestación de microservicios con Conductor [Conductor](https://github.com/conductor-oss/conductor). Este microservicio no incorpora el SDK del orquestador y es un servicio pensado para ser invocado vía API-REST desde una tarea del workflow

# Pre-requisitos
1. Docker
2. Servidor Conductor funcionando en local
3. Entornos Maven y Java 

**Crear contenedor para servidor Conductor versión Community**

1. Chequear si tenemos docker instalado y ejecutar el siguiente comando para levantar el servidor en local:

```shell
docker run --init -p 9090:8080 -p 1234:5000 --mount source=redis,target=/redis \
--mount source=postgres,target=/pgdata orkesio/orkes-conductor-community-standalone:latest
```
El UI del servidor de Conductor estará disponible en:

http://localhost:1234

que está funcionando en el puerto 9090

