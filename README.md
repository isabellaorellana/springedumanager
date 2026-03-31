SpringEduManager - OTEC Primavera
SpringEduManager es una plataforma integral de gestión académica diseñada para la OTEC Primavera. El sistema permite administrar de manera eficiente la oferta educativa, el registro de estudiantes y la gestión de cursos, proporcionando interfaces diferenciadas según el rol del usuario.

🚀 Características Principales
Gestión de Cursos y Usuarios: CRUD completo para el catálogo académico y perfiles de usuario.
Seguridad y Control de Acceso: Implementación de Spring Security con encriptación BCrypt.
Roles de Usuario:
ADMIN: Acceso total a la gestión de datos, reportes y configuración.
USER: Acceso al portal de autogestión y visualización de información académica.
Interoperabilidad: Exposición de APIs RESTful para integración con otros sistemas.
Interfaz Dinámica: Vistas renderizadas con Thymeleaf.

🛠️ Stack Tecnológico
Lenguaje: Java 21
Framework Principal: Spring Boot 3.2.0
Gestión de Dependencias: Maven
Persistencia: Spring Data JPA
Base de Datos: MariaDB
Seguridad: Spring Security (BCrypt)
Motor de Plantillas: Thymeleaf

📂 Arquitectura del Proyecto
El sistema sigue el patrón de diseño MVC (Modelo-Vista-Controlador) y está organizado en una estructura de 4 capas para garantizar escalabilidad y mantenibilidad:

Modelo (Entities): Representación de las tablas de la base de datos.
Repositorio: Interfaz de comunicación con MariaDB mediante JPA.
Servicio: Lógica de negocio y validaciones.
Controlador: Manejo de peticiones HTTP y exposición de endpoints.

⚙️ Configuración e Instalación
Clonar el repositorio:

Bash
git clone https://github.com/isabellaorellana/springedumanager.git
Configurar la Base de Datos:
Crea una base de datos en MariaDB y actualiza las credenciales en el archivo src/main/resources/application.properties:

Properties
spring.datasource.url=jdbc:mariadb://localhost:3306/nombre_tu_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

Ejecutar la aplicación:

Bash
mvn spring-boot:run
📝 Licencia
Este proyecto fue desarrollado para fines académicos y profesionales.


Credenciales para ingresar:
ADMIN: admin@otec.cl, contraseña: admin123
Estudiantes: Ej: elenanito@gmail.com, contraseña: elena123
