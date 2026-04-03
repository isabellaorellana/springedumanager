SpringEduManager - OTEC Primavera 🎓

SpringEduManager es una plataforma integral de gestión académica diseñada para la OTEC Primavera. El sistema permite administrar de manera eficiente la oferta educativa, el registro de estudiantes y la gestión de cursos, proporcionando interfaces diferenciadas según el rol del usuario.

🧠 Caso de Estudio: Seguridad y Control de Acceso (RBAC)

Este proyecto fue seleccionado para el portafolio debido a su complejidad en la implementación de reglas de negocio y seguridad.

1. Descripción del Desafío

El mayor reto técnico fue implementar un sistema de Control de Acceso Basado en Roles (RBAC). Era crítico garantizar que solo los administradores gestionaran la oferta académica, mientras que los estudiantes solo pudieran visualizar su información, evitando brechas de seguridad en la manipulación de datos sensibles.

2. Solución Propuesta

Se implementó Spring Security 6 utilizando una arquitectura de seguridad personalizada. Se configuró un SecurityFilterChain para definir reglas de acceso granulares por URL y se utilizó BCrypt para la encriptación de contraseñas en la base de datos, asegurando la protección de las credenciales.

3. Justificación de Herramientas

Spring Boot 3.2: Elegido por su capacidad de autoconfiguración y rapidez para levantar servicios REST profesionales.

MariaDB: Seleccionado por su excelente rendimiento en aplicaciones que requieren integridad referencial estricta.

Thymeleaf: Utilizado para permitir una renderización rápida en el servidor sin añadir la complejidad de un framework de frontend separado.

4. Aprendizajes Clave

Optimización: Manejo avanzado de JPA y Relaciones (ManyToOne), logrando mantener tiempos de respuesta bajos.

Seguridad Robusta: Cobertura total de seguridad en los endpoints sensibles del sistema.

🚀 Características Principales

Gestión de Cursos y Usuarios: CRUD completo para el catálogo académico y perfiles de usuario.

Seguridad de Nivel Empresarial: Encriptación de datos sensibles con BCrypt.

Roles de Usuario Definidos:

ADMIN: Acceso total a gestión, reportes y configuración.

USER: Acceso a portal de autogestión y consulta de información académica.

🛠️ Stack Tecnológico

Lenguaje: Java 25 (OpenJDK Temurin)

Framework: Spring Boot 3.2.0

Persistencia: Spring Data JPA

Base de Datos: MariaDB

Seguridad: Spring Security

📂 Arquitectura (MVC)

Modelo (Entities): Mapeo de objetos a la base de datos.

Repositorio: Comunicación con la base de datos mediante JPA.

Servicio: Lógica de negocio y validaciones del sistema.

Controlador: Manejo de peticiones HTTP y endpoints.

📝 Credenciales de Prueba (Demo)

ADMIN: admin@otec.cl | Contraseña: admin123

ESTUDIANTE: elenanito@gmail.com | Contraseña: elena123

Este proyecto forma parte de mi portafolio profesional de desarrollo de software.
