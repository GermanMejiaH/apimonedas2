INGENIERÍA DE REQUISITOS
SISTEMA: API DE MONEDAS CON SEGURIDAD

--------------------------------------------------
1. DEFINICIÓN DEL PROBLEMA
--------------------------------------------------
Se requiere desarrollar una API REST utilizando Spring Boot y PostgreSQL que permita gestionar información de monedas del mundo, consultar sus cambios respecto al dólar y proteger el acceso mediante autenticación por token.

--------------------------------------------------
2. OBJETIVO DEL SISTEMA
--------------------------------------------------
Construir una API backend segura, escalable y desacoplada que permita:
- Gestionar monedas
- Consultar moneda por país
- Consultar cambios históricos
- Autenticación mediante token
- Implementación de arquitectura Onion

--------------------------------------------------
3. ACTORES DEL SISTEMA
--------------------------------------------------
- Usuario autenticado
- Sistema de autenticación

--------------------------------------------------
4. REQUISITOS FUNCIONALES
--------------------------------------------------
RF1 - Autenticación de usuario
El sistema debe permitir validar credenciales y retornar un token junto con la información del usuario.

RF2 - Buscar moneda por país
El sistema debe permitir consultar la moneda asociada a un país.

RF3 - Listar cambios de moneda por periodo
El sistema debe permitir consultar los cambios de una moneda dentro de un rango de fechas.

RF4 - Gestión de monedas (CRUD)
El sistema debe permitir:
- Crear moneda
- Consultar moneda
- Actualizar moneda
- Eliminar moneda
- Listar monedas

RF5 - Seguridad por token
Todas las solicitudes deben incluir un token válido. En caso contrario, se debe retornar un error 403.

--------------------------------------------------
5. REQUISITOS NO FUNCIONALES
--------------------------------------------------
Seguridad:
- Uso obligatorio de token
- Validación en cada request

Rendimiento:
- Consultas eficientes con JPA

Escalabilidad:
- Arquitectura desacoplada

Testabilidad:
- Uso de interfaces

Mantenibilidad:
- Separación de capas
- Inyección de dependencias

--------------------------------------------------
6. MODELO DE DOMINIO
--------------------------------------------------
Entidad Moneda:
- id
- nombre
- sigla
- simbolo
- emisor

Entidad Pais:
- id
- nombre
- codigoAlfa2
- codigoAlfa3
- moneda

Entidad CambioMoneda:
- id
- moneda
- fecha
- valor

Entidad Usuario:
- id
- username
- password

--------------------------------------------------
7. CASOS DE USO
--------------------------------------------------
CU1 - Login
CU2 - Consultar moneda por país
CU3 - Consultar cambios por periodo
CU4 - CRUD de monedas

--------------------------------------------------
8. ENDPOINTS
--------------------------------------------------
POST /api/login

GET /api/monedas/listar
GET /api/monedas/obtener/{id}
GET /api/monedas/buscar/{nombre}
GET /api/monedas/buscarporpais/{nombre}
POST /api/monedas/agregar
PUT /api/monedas/modificar
DELETE /api/monedas/eliminar/{id}
GET /api/monedas/listarporperiodo

--------------------------------------------------
9. ARQUITECTURA (ONION)
--------------------------------------------------
Core:
- Entidades
- Interfaces de repositorios
- Interfaces de servicios

Aplicación:
- Implementación de servicios

Infraestructura:
- Acceso a base de datos

Presentación:
- Controladores REST

--------------------------------------------------
10. SEGURIDAD
--------------------------------------------------
- Uso de token en header Authorization
- Validación obligatoria en cada request

--------------------------------------------------
11. REQUISITOS TÉCNICOS
--------------------------------------------------
- Java
- Spring Boot
- PostgreSQL
- JPA (Hibernate)
- Maven
- Postman

--------------------------------------------------
12. REGLAS DE NEGOCIO
--------------------------------------------------
- Un país tiene una sola moneda
- Una moneda puede pertenecer a varios países
- No se permiten monedas duplicadas
- No se permite acceso sin token

--------------------------------------------------
13. CONCLUSIÓN
--------------------------------------------------
El sistema debe implementar una API REST completa, segura y basada en arquitectura Onion, que permita gestionar monedas y sus cambios, incluyendo autenticación por token.

