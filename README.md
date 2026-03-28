SpringEduManager: Sistema de Gestión Académica
Este proyecto es una aplicación robusta desarrollada con Spring Boot 3.4, diseñada para gestionar el catálogo de cursos y el registro de estudiantes de una institución educativa. Implementa una arquitectura profesional de capas, seguridad perimetral y persistencia de datos en tiempo real.

🚀 Arquitectura y Patrones
Para asegurar la escalabilidad exigida por la Coordinación Académica, el proyecto sigue una estructura de 4 Capas:

Modelo (Entity): Uso de JPA/Hibernate para mapear las tablas estudiantes y cursos en la base de datos.
Repositorio: Interfaces que extienden de JpaRepository para operaciones CRUD automáticas sobre H2.
Servicio: Capa de lógica de negocio que desacopla los controladores de la persistencia.
Controlador (MVC & REST): * Controllers: Gestionan las vistas dinámicas con Thymeleaf.
RestControllers: Exponen puntos de enlace JSON para interoperabilidad con otros sistemas (Lección 5).

🛡️ Seguridad (Lección 4)
El sistema cuenta con Spring Security activo para proteger las rutas críticas.
Roles: Configuración de rol ADMIN para la gestión de registros.
Credenciales por defecto: * Usuario: admin
Password: 123456

🛠️ Stack Tecnológico
Java 21 (OpenJDK Temurin): Última vanguardia en el entorno de ejecución.
Spring Boot 3.4.x: Framework principal.
Spring Data JPA: Abstracción de base de datos.
H2 Database: Base de datos en memoria para desarrollo ágil y pruebas.
Thymeleaf: Motor de plantillas con diseño CSS moderno y unificado.
Maven: Gestión de dependencias y ciclo de vida del proyecto.


Acceso Web:

Listado: http://localhost:8080/estudiantes
Consola H2: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:edumanagerdb).