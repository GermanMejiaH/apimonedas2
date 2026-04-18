# Informe del Proyecto: API de Monedas

---

## 1. Resumen Ejecutivo

El proyecto consiste en una API REST segura, desarrollada en Spring Boot y PostgreSQL para la gestión de monedas, países y cambios de moneda históricos, con seguridad implementada mediante tokens JWT. El desarrollo se basó en la Arquitectura Onion (Onion Architecture), que permite desacoplar componentes, garantizar testabilidad y promover la mantenibilidad del sistema.

---

## 2. Introducción

### 2.1 Definición del problema
La necesidad surge de desarrollar una solución backend escalable y segura que permita:
- Gestionar información de monedas de todo el mundo
- Consultar la relación entre monedas y países
- Consultar cambios de moneda por periodo
- Garantizar la seguridad del acceso mediante autenticación por tokens

### 2.2 Objetivos del proyecto
1. Desarrollar una API REST completa y funcional
2. Implementar seguridad basada en tokens JWT
3. Aplicar la arquitectura Onion para garantizar desacoplamiento
4. Integrar con PostgreSQL para almacenamiento persistente
5. Cumplir con todos los requisitos funcionales y no funcionales definidos en el documento de requisitos

---

## 3. Tecnologías y Herramientas Utilizadas

| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| Java | 17 | Lenguaje de programación |
| Spring Boot | 3.3.5 | Framework para aplicaciones |
| PostgreSQL | 12+ | Motor de base de datos relacional |
| Spring Security | 3.3.5 | Seguridad y autenticación |
| JWT (JJWT) | 0.12.3 | Generación y validación de tokens |
| JPA/Hibernate | 6.5.3 | ORM para acceso a datos |
| Maven | 3.6+ | Gestión de dependencias |
| Swagger UI | 2.6+ | Documentación interactiva de la API |

---

## 4. Arquitectura del Sistema

### 4.1 Arquitectura Onion

El proyecto implementa la Arquitectura Onion (Onion Architecture), compuesta por las siguientes capas (de interior a exterior):

1. **Dominio:
   - Entidades del negocio (Moneda, Pais, CambioMoneda, Usuario
   - DTOs (PeriodoDto, UsuarioLoginDto

2. **Core:
   - Interfaces de repositorios
   - Interfaces de servicios

3. **Aplicación:
   - Implementaciones de servicios
   - Lógica de negocio

4. **Infraestructura:
   - Repositorios JPA
   - Acceso a la base de datos

5. **Presentación:
   - Controladores REST
   - Configuración de la aplicación
   - punto de entrada

### 4.2 Estructura de Directorios

```
apimonedas2/
├── api/
│   ├── core/               # Capa Core
│   ├── dominio/           # Capa Dominio
│   ├── aplicacion/       # Capa Aplicación
│   ├── infraestructura/ # Capa Infraestructura
│   └── presentacion/    # Capa Presentación
├── bd/                    # Scripts de base de datos
│   ├── DDL_Monedas.sql
│   ├── DDL_Monedas_Secuencias.sql
│   └── DML_Monedas.sql
├── README.md
├── INFORME_PROYECTO.md
└── ingenieria_de_requisitos_api_monedas.md
```

---

## 5. Modelo de Datos

### 5.1 Diagrama de Entidades

| Entidad | Atributos |
|---------|-----------|
| **Moneda** | id, nombre, sigla, símbolo, emisor |
| **Pais** | id, nombre, códigoAlfa2, códigoAlfa3, moneda (relación) |
| **CambioMoneda** | id, moneda, fecha, valor |
| **Usuario** | id, username, password, nombre |

---

## 6. Funcionalidades Implementadas

### 6.1 Autenticación
- Validación de credenciales
- Generación de tokens JWT
- Validación de tokens en todas las solicitudes
- Endpoint: `POST /api/login

### 6.2 Gestión de Monedas
- Listar todas las monedas
- Obtener moneda por ID
- Buscar monedas por nombre
- Buscar moneda por nombre de país
- Agregar moneda
- Modificar moneda
- Eliminar moneda
- Consultar cambios de moneda por periodo

### 6.3 Gestión de Países
- Listar todos los países
- Obtener país por ID

### 6.4 Gestión de Usuarios
- Listar todos los usuarios

---

## 7. Seguridad

La seguridad se implementó mediante:
1. **Spring Security: Configuración de seguridad
2. **JWT:
   - Generación de tokens al iniciar sesión
   - Validación de tokens en cada solicitud
   - Error 403 Forbidden si el token no es válido o ha expirado

---

## 8. Pruebas y Validación

### 8.1 Pruebas Funcionales
- Todas los endpoints fueron probados con Swagger UI
- Funcionalidad de autenticación verificada
- Funcionalidad de CRUD de monedas verificada
- Consulta de cambios por periodo verificada
- Búsqueda por país verificada

### 8.2 Datos de Prueba
La base de datos incluye:
- 177 monedas
- 193 países
- 100 registros de cambio de moneda históricos (para la moneda 35, el Peso Colombiano, entre enero y abril de 2010
- 1 usuario de prueba

---

## 9. Conclusiones

El proyecto ha cumplió con todos los requisitos establecidos:
✅ Desarrollo de una API REST funcional y segura
✅ Implementación de la Arquitectura Onion
✅ Integración exitosa con PostgreSQL
✅ Seguridad por tokens JWT
✅ Cumplimiento de todos los requisitos funcionales y no funcionales
✅ Documentación interactiva con Swagger UI
✅ Datos de prueba incluidos

---

## 10. Recomendaciones Futuras

1. Implementación de Docker para facilitar la instalación y despliegue
2. Agregar más tests unitarios y de integración
3. Implementación de caché para mejorar el rendimiento
4. Agregar más registros de cambios para más monedas
5. Implementar roles y permisos más detallados
6. Implementación de logging estructurado para monitoreo

---

## 11. Referencias

- Documento de Ingeniería de Requisitos: `ingenieria_de_requisitos_api_monedas.md`
- Spring Boot: https://spring.io/projects/spring-boot
- Arquitectura Onion: https://jeffreypalermo.com/2008/07/the-onion-architecture-part-3/

---

---
**Fecha de entrega: 17 de abril de 2026
**Curso: Ingeniería de Requisitos
**Institución: IUPB
