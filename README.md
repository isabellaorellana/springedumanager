📑 SpringEduManager: Sistema de Gestión Académica OTEC Primavera

Descripción del Proyecto
SpringEduManager es una plataforma integral desarrollada con Spring Boot 3.2.0, diseñada para digitalizar la gestión de cursos y el seguimiento del progreso estudiantil. Este MVP resuelve la problemática de la OTEC Primavera, sustituyendo registros manuales por una arquitectura profesional con seguridad perimetral y persistencia de datos en tiempo real.

🚀 Arquitectura y Patrones
Para asegurar la escalabilidad y el orden exigido en la rúbrica, el proyecto se organiza en 4 capas de responsabilidad:

Modelo (Entity): Mapeo relacional con JPA/Hibernate de las tablas estudiantes y cursos.
Repositorio: Interfaces que extienden de JpaRepository para operaciones CRUD sobre MariaDB.
Controlador (MVC & REST): * Controllers: Gestión de vistas dinámicas con Thymeleaf.
RestControllers: Exposición de endpoints JSON para asegurar la interoperabilidad con futuras aplicaciones móviles (Requerimiento Lección 5).

🛡️ Seguridad y Acceso (Lección 4)
Implementación robusta de Spring Security con protección de rutas y gestión de sesiones:
Encriptación: Uso de BCryptPasswordEncoder para el resguardo seguro de credenciales.
Roles Definidos: * ROLE_ADMIN: Acceso total a la gestión administrativa.
ROLE_USER: Acceso exclusivo al portal de autogestión del estudiante (Caso: Elena Nito).

Sincronización: El sistema incluye un CommandLineRunner que garantiza la integridad de las credenciales al iniciar la aplicación.

🛠️ Stack Tecnológico
Java 21: Uso de las últimas características de rendimiento del lenguaje.
Spring Boot 3.2.0: Framework principal para el desarrollo ágil.
Spring Data JPA: Abstracción de persistencia de datos.
MariaDB: Motor de base de datos relacional para persistencia real y trazabilidad.
Thymeleaf: Motor de plantillas con diseño responsivo.
Maven: Gestión de dependencias y ciclo de vida (L5).

📊 Endpoints y Acceso Local
Portal Principal: http://localhost:8080/
Gestión (Admin): http://localhost:8080/admin/dashboard
Portal Estudiante: http://localhost:8080/estudiante/dashboar
API REST (JSON): http://localhost:8080/api/estudiantes (Interoperabilidad).

Credenciales para ingresar:
ADMIN: admin@otec.cl, contraseña: admin123
Estudiantes: Ej: elenanito@gmail.com, contraseña: elena123
