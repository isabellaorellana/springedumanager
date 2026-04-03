# SpringEduManager - OTEC Primavera 🎓

**SpringEduManager** es una plataforma de gestión académica integral diseñada para optimizar la administración de oferta educativa, registro de estudiantes y control de cursos, garantizando una experiencia de usuario fluida y segura.

---

## 🧠 Caso de Estudio: Seguridad y Control de Acceso (RBAC)
Este proyecto destaca por su arquitectura robusta y la implementación de lógica de negocio crítica.

### 1. El Desafío
Implementar un sistema de **Control de Acceso Basado en Roles (RBAC)** para asegurar que los administradores gestionen la academia mientras los estudiantes solo acceden a su información personal.

### 2. La Solución
Se utilizó **Spring Security 6** con una arquitectura personalizada, configurando un `SecurityFilterChain` para reglas granulares y **BCrypt** para la protección de credenciales.

### 3. Justificación del Stack
* **Spring Boot 3.2**: Ecosistema maduro y rapidez en servicios REST.
* **MariaDB**: Consistencia y eficiencia en integridad referencial.
* **Thymeleaf**: Renderizado dinámico eficiente desde el servidor.

---

## 🚀 Características Principales
* ✅ **Gestión Académica**: CRUD completo de cursos, alumnos y matrículas.
* 🔐 **Seguridad Avanzada**: Encriptación BCrypt y protección contra vulnerabilidades (CSRF, XSS).
* 👥 **Roles Diferenciados**:
    * `ADMIN`: Gestión total y reportes.
    * `USER`: Portal de consulta y autogestión.
* 🏗️ **Arquitectura Limpia**: Organización en 4 capas (MVC).

---

## 🛠️ Stack Tecnológico

| Componente | Tecnología |
| :--- | :--- |
| **Lenguaje** | Java 25 (OpenJDK Temurin) |
| **Framework** | Spring Boot 3.2.0 |
| **Persistencia** | Spring Data JPA |
| **Base de Datos** | MariaDB |
| **Seguridad** | Spring Security 6 |
| **Vistas** | Thymeleaf + HTML5 / CSS3 |

---

## 📂 Arquitectura del Proyecto (MVC)
El sistema separa las responsabilidades de forma clara:
* **Modelo (Entities)**: Mapeo relacional de datos.
* **Repositorio**: Comunicación con MariaDB mediante JPA.
* **Servicio**: Capa de lógica de negocio y validaciones.
* **Controlador**: Gestión de peticiones y flujo de la aplicación.

---

## 📝 Credenciales de Prueba (Demo)
| Rol | Usuario | Contraseña |
| :--- | :--- | :--- |
| **ADMIN** | `admin@otec.cl` | `admin123` |
| **ESTUDIANTE** | `elenanito@gmail.com` | `elena123` |

---

## ⚙️ Instalación y Configuración

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/tu-usuario/SpringEduManager.git
    ```
2.  **Base de Datos:**
    * Crear base de datos `otec_primavera` en MariaDB.
    * Configurar credenciales en `src/main/resources/application.properties`.
3.  **Ejecutar:**
    ```bash
    ./mvnw spring-boot:run
    ```
