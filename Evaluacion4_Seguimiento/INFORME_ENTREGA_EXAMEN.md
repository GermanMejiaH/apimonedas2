# Informe de Evaluación: Automatización y Contenerización de Microservicios
**Asignatura:** Computación en la Nube y Contenerización
**Proyecto:** API de Calendarios Laborales (Microservicios)

## 1. Introducción
Este informe detalla la solución implementada para la automatización del despliegue de la aplicación distribuida de Calendarios Laborales. Se han aplicado conceptos de infraestructura como código (IaC), contenerización con Docker y CI/CD mediante Jenkins.

## 2. Arquitectura del Sistema
La solución se compone de dos microservicios principales operando sobre una red virtualizada:

*   **Red de Contenedores:** `redcalendario` (Driver: bridge).
*   **Microservicio 1 (apiFestivos):**
    *   **Tecnología:** Node.js.
    *   **Base de Datos:** MongoDB (`dockerbdfestivos`).
    *   **Puerto:** 3000.
*   **Microservicio 2 (apiCalendario):**
    *   **Tecnología:** Spring Boot.
    *   **Base de Datos:** PostgreSQL (`dockerbdcalendario`).
    *   **Puerto:** 8080.

## 3. Implementación de Contenerización
Se han creado y optimizado los siguientes archivos de configuración:

*   **Dockerfiles:** Cada microservicio cuenta con un archivo de definición de imagen optimizado (Node.js slim y OpenJDK Alpine).
*   **Docker Compose:** El archivo `docker-compose.yml` orquesta los cuatro contenedores, definiendo dependencias (`depends_on`), redes y variables de entorno para la comunicación entre servicios.

## 4. Pipeline de Automatización (Jenkins)
Se implementó un pipeline en **Groovy** ([Jenkinsfile](Jenkinsfile)) que automatiza el flujo de trabajo tras cada "push" al repositorio:

1.  **Stage: Preparación:** Limpieza del entorno y clonación del código fuente.
2.  **Stage: Compilación Spring Boot:** Construcción del artefacto JAR utilizando el wrapper de Maven (`mvnw`).
3.  **Stage: Construcción Docker:** Generación de imágenes personalizadas para ambos microservicios.
4.  **Stage: Despliegue:** Orquestación y levantamiento de servicios en segundo plano.
5.  **Stage: Verificación:** Pruebas de conectividad automatizadas (Health Checks) mediante comandos `curl` a los endpoints de las APIs.

## 5. Conclusiones
La solución cumple con todos los requisitos del examen:
- Automatización total del despliegue.
- Uso de redes personalizadas para aislamiento de microservicios.
- Persistencia de datos mediante contenedores especializados.
- Pipeline de Jenkins funcional para integración continua.

---
**Entregables adjuntos:**
- `Jenkinsfile`
- `docker-compose.yml`
- `Dockerfile` (Node.js & Spring Boot)
- Código fuente de las APIs.
