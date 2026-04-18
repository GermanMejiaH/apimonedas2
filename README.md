# API de Monedas - Proyecto

API REST de gestión de monedas con seguridad basada en arquitectura Onion

## Descripción

Sistema API REST desarrollado con Spring Boot y PostgreSQL que permite gestionar información de monedas del mundo, consultar sus cambios respecto al dólar y proteger el acceso mediante autenticación por token JWT.

## Tecnologías usadas

- Java 17
- Spring Boot 3.3.5
- PostgreSQL
- Spring Security
- JWT (JSON Web Tokens)
- JPA (Hibernate)
- Maven
- Swagger UI

## Arquitectura

El proyecto utiliza la Arquitectura Onion (Onion Architecture), organizada en capas:

1. **Core**: Entidades y interfaces
2. **Dominio**: Entidades y DTOs
3. **Aplicación**: Implementación de servicios
4. **Infraestructura**: Acceso a base de datos
5. **Presentación**: Controladores REST y punto de entrada de la aplicación

## Instalación y ejecución

### 1. Requisitos previos

- Java 17 o superior
- PostgreSQL 12 o superior
- Maven 3.6 o superior (o usar el Maven Wrapper incluido)

### 2. Configurar la base de datos

1. Abre PostgreSQL y crea la base de datos:
   ```sql
   CREATE DATABASE monedas;
   ```

2. Ejecuta los scripts SQL en el siguiente orden:
   1. `bd/DDL_Monedas.sql
   2. `bd/DDL_Monedas_Secuencias.sql
   3. `bd/DML_Monedas.sql

3. Verifica las credenciales en el archivo `api/presentacion/src/main/resources/application.properties:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/monedas
   spring.datasource.username=postgres
   spring.datasource.password=postgres
   ```

### 3. Ejecutar la aplicación

#### Usando Maven Wrapper (Windows):
```powershell
cd api
.\mvnw.cmd clean install -DskipTests
cd presentacion
..\mvnw.cmd spring-boot:run
```

#### Usando Maven Wrapper (Linux/macOS):
```bash
cd api
./mvnw clean install -DskipTests
cd presentacion
../mvnw spring-boot:run
```

### 4. Uso de la API

- Swagger UI: http://localhost:8081/swagger-ui.html

#### Credenciales de prueba

- **Usuario**: `frayosorio
- **Contraseña**: `123

#### Obtener token JWT

1. Abre Swagger UI
2. Encuentra el endpoint **POST /api/login
3. Usa las credenciales anteriores
4. Copia el token retornado
5. Haz clic en el botón **Authorize** (arriba a la derecha)
6. Escribe: `Bearer <tu_token>
7. Haz clic en **Authorize** y luego en **Close**
8. Ahora puedes usar todos los endpoints protegidos

## Endpoints disponibles

### Autenticación

| Método | Endpoint | Descripción |
|---------|----------|-------------|
| POST | `/api/login` | Autenticar usuario y obtener token JWT |

### Monedas

| Método | Endpoint | Descripción |
|---------|----------|-------------|
| GET | `/api/monedas/listar` | Obtiene todas las monedas |
| GET | `/api/monedas/obtener/{id} | Obtiene una moneda por ID |
| GET | `/api/monedas/buscar/{nombre} | Busca monedas por nombre |
| GET | `/api/monedas/buscarporpais/{nombre} | Busca la moneda asociada a un país |
| POST | `/api/monedas/agregar` | Agrega una nueva moneda |
| PUT | `/api/monedas/modificar` | Modifica una moneda existente |
| DELETE | `/api/monedas/eliminar/{id} | Elimina una moneda |
| POST | `/api/monedas/listarporperiodo` | Obtiene cambios de moneda por periodo |
| POST | `/api/monedas/cambios/{idmoneda} | Obtiene todos los cambios de una moneda |

### Países

| Método | Endpoint | Descripción |
|---------|----------|-------------|
| GET | `/api/paises/listar` | Obtiene todos los países |
| GET | `/api/paises/obtener/{id} | Obtiene un país por ID |

### Usuarios

| Método | Endpoint | Descripción |
|---------|----------|-------------|
| GET | `/api/usuarios/listar` | Obtiene todos los usuarios |

## Ejemplo de uso del endpoint `listarporperiodo`

Request body:
```json
{
  "idMoneda": 35,
  "desde": "2010-01-01",
  "hasta": "2010-01-10"
}
```

## Autor

Proyecto desarrollado para la materia Ingeniería de Requisitos - IUPB
