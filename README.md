# Orquestación de microservicios con Conductor

Este es un ejemplo de uso para la orquestación de microservicios con Conductor [Conductor](https://github.com/conductor-oss/conductor). Este microservicio no incorpora el SDK del orquestador y es un servicio pensado para ser invocado vía API-REST desde una tarea del workflow

# Pre-requisitos
1. Docker
2. Servidor Conductor funcionando en local
3. Entornos Maven y Java 


# Cómo se prueba

**Crear contenedor para servidor Conductor versión Community**

1. Chequear si tenemos docker instalado y ejecutar el siguiente comando para levantar el servidor en local:

```shell
docker run --init -p 9090:8080 -p 1234:5000 --mount source=redis,target=/redis \
--mount source=postgres,target=/pgdata orkesio/orkes-conductor-community-standalone:latest
```
El UI del servidor de Conductor estará disponible en:

```shell
http://localhost:1234
```
y está levantado en el puerto 9090

2. En la carpeta "examples" del proyecto, tenemos un json con el ejemplo para integrar este servicio. En la consola UI de Conductor definiremos un nuevo workflow:

```shell
conductor_workflow.json
```

3. Arrancamos nuestro microservicio en la misma máquina donde tenemos el servidor de Conductor:

```shell
mvn spring-boot:run
``` 

 Podemos comprobar que el API implementado en el microservicio está disponible en la URL -> 

```shell 
 http://localhost:8081/swagger-ui/index.html
``` 

4. Desde la pestaña Workbench del UI, seleccionando "Workflow Name", "Workflow Version", y los parámetros de entrada podremos ejecutar este caso de uso. Un ejemplo de objeto de entrada:

```shell
{
  "accountId": "093332211",
  "amount": 100
}
```
