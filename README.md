SpringEduManager - OTEC Primavera 🎓

SpringEduManager es una plataforma de gestión académica diseñada para la OTEC Primavera. El sistema optimiza la administración de oferta educativa, registro de estudiantes y control de cursos, garantizando una experiencia de usuario fluida y segura.

🧠 Caso de Estudio: Seguridad y Control de Acceso (RBAC)

Este proyecto fue seleccionado para el portafolio debido a su arquitectura robusta y la implementación de lógica de negocio crítica.

1. Descripción del Desafío

El mayor reto técnico fue implementar un sistema de Control de Acceso Basado en Roles (RBAC). Era imperativo asegurar que solo los administradores pudieran gestionar datos académicos, mientras que los estudiantes solo tuvieran acceso a su información personal, eliminando riesgos de manipulación de datos sensibles.

2. Solución Propuesta

Se implementó Spring Security 6 mediante una arquitectura personalizada. Se configuró un SecurityFilterChain para definir reglas de acceso granulares por URL y se utilizó BCrypt para la encriptación de contraseñas, protegiendo la identidad de los usuarios.

3. Justificación de Herramientas

Spring Boot 3.2: Por su ecosistema maduro y rapidez para desplegar servicios REST.

MariaDB: Por su consistencia y eficiencia en el manejo de integridad referencial.

Thymeleaf: Para renderizar interfaces dinámicas de manera eficiente desde el servidor.

🚀 Características Principales

✅ Gestión Académica: CRUD completo de cursos, alumnos y matrículas.

🔐 Seguridad Avanzada: Encriptación BCrypt y protección contra vulnerabilidades.

👥 Roles Diferenciados:

ADMIN: Gestión total de la plataforma y reportes.

USER: Portal de consulta y autogestión académica.

🏗️ Arquitectura Limpia: Organización en 4 capas (MVC).

🛠️ Stack Tecnológico

Componente

Tecnología

Lenguaje

Java 25 (OpenJDK Temurin)

Framework

Spring Boot 3.2.0

Persistencia

Spring Data JPA

Base de Datos

MariaDB

Seguridad

Spring Security 6

Vistas

Thymeleaf + HTML5 / CSS3

📂 Arquitectura del Proyecto

El sistema sigue el patrón de diseño MVC (Modelo-Vista-Controlador):

Modelo (Entities): Mapeo relacional de datos.

Repositorio: Interfaz de comunicación con MariaDB mediante JPA.

Servicio: Capa de lógica de negocio y validaciones.

Controlador: Gestión de peticiones y flujo de la aplicación.

📝 Credenciales de Prueba (Demo)

Rol

Usuario

Contraseña

ADMIN

admin@otec.cl

admin123

ESTUDIANTE

elenanito@gmail.com

elena123
