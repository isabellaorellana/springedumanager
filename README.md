SpringEduManager - OTEC Primavera 🎓

SpringEduManager es una plataforma integral de gestión académica diseñada para la OTEC Primavera. El sistema permite administrar de manera eficiente la oferta educativa, el registro de estudiantes y la gestión de cursos, proporcionando interfaces diferenciadas según el rol del usuario.

🧠 Caso de Estudio: Seguridad y Control de Acceso (RBAC)

Este proyecto fue seleccionado para el portafolio debido a su complejidad en la implementación de reglas de negocio y seguridad.

1. Descripción del Desafío

El mayor reto técnico fue implementar un sistema de Control de Acceso Basado en Roles (RBAC). Era crítico garantizar que solo los administradores gestionaran la oferta académica, mientras que los estudiantes solo pudieran visualizar su información.

2. Solución Propuesta

Se implementó Spring Security 6 utilizando una arquitectura de seguridad personalizada. Se configuró un SecurityFilterChain para definir reglas de acceso granulares por URL y se utilizó BCrypt para la encriptación de contraseñas.

3. Justificación de Herramientas

Spring Boot 3.2: Elegido por su capacidad de autoconfiguración y rapidez.

MariaDB: Seleccionado por su rendimiento en integridad referencial.

Thymeleaf: Utilizado para renderización rápida en el servidor.

4. Aprendizajes Clave

Optimización: Manejo avanzado de JPA y Relaciones (ManyToOne).

Seguridad: Cobertura total de endpoints sensibles.

🚀 Características Principales

Gestión de Cursos y Usuarios: CRUD completo.

Seguridad: Encriptación de datos con BCrypt.

Roles: ADMIN (gestión total) y USER (consulta).

🛠️ Stack Tecnológico

Lenguaje: Java 25

Framework: Spring Boot 3.2.0

Base de Datos: MariaDB

Seguridad: Spring Security

📂 Arquitectura (MVC)

Modelo: Entidades JPA.

Repositorio: Interfaces de persistencia.

Servicio: Lógica de negocio.

Controlador: Endpoints REST.

📝 Credenciales de Prueba

ADMIN: admin@otec.cl | Contraseña: admin123

ESTUDIANTE: elenanito@gmail.com | Contraseña: elena123
