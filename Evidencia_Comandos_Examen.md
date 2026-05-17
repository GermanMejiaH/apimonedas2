# Evidencia de Comandos - Evaluación 4 Seguimiento

## 1. Creación de la Red de Contenedores
Para que los microservicios puedan comunicarse entre sí por nombre de contenedor, se crea una red tipo bridge:

```bash
docker network create redcalendario
```

## 2. Construcción de Imágenes (Dockerfiles)

### API de Festivos (NodeJS)
Ubicación: `./festivos-api-node`
Comando:
```bash
cd festivos-api-node
docker build -t dockerapifestivos .
```

### API de Calendario (SpringBoot)
Ubicación: `./festivos-api-spring`
Comando:
```bash
cd festivos-api-spring
docker build -t dockerapicalendario .
```

## 3. Despliegue de Contenedores (Manual)

### Bases de Datos
```bash
# MongoDB para Festivos
docker run -d --name dockerbdfestivos --network redcalendario -p 27017:27017 mongo:latest

# PostgreSQL para Calendario
docker run -d --name dockerbdcalendario --network redcalendario -e POSTGRES_DB=festivos -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5433:5432 postgres:latest
```

### Microservicios
```bash
# Contenedor API Festivos
docker run -d --name dockerapifestivos --network redcalendario -p 3000:3000 dockerapifestivos

# Contenedor API Calendario
docker run -d --name dockerapicalendario --network redcalendario -p 8080:8080 dockerapicalendario
```

## 4. Despliegue Orquestado (Docker Compose)
Para simplificar el proceso, se puede utilizar el archivo `docker-compose.yml` adjunto:

```bash
docker-compose up --build -d
```

---
**Nota:** Se han configurado los archivos `application.properties` y `.env` para apuntar a los nombres de los contenedores (`dockerbdcalendario` y `dockerbdfestivos`) en lugar de `localhost`.
