# Library_apiREST
Proyecto: API REST para Gestión de Libros

Este proyecto es una API REST desarrollada en Spring Boot que permite la gestión de libros, utilizando PostgreSQL como motor de base de datos y Spring Security con JWT (JSON Web Tokens) para la seguridad de acceso a los endpoints.

---

## Tecnologías utilizadas

- Spring Boot: Framework principal para la creación del API REST.
- Spring Security: Proporciona seguridad a los endpoints mediante autenticación y autorización con JWT.
- PostgreSQL: Motor de base de datos para almacenar la información.
- JWT: Manejados mediante librerías externas para generar y validar tokens de acceso.

---

## Instalación de dependencias para JWT

Para manejar JWT, se han utilizado tres extensiones que deben agregarse al proyecto. Estas se pueden instalar añadiendo las siguientes dependencias al archivo pom.xml:

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.5</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.12.5</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.12.5</version>
</dependency>

Asegúrate de actualizar el proyecto en tu IDE (por ejemplo, IntelliJ IDEA o Eclipse) para descargar las dependencias.

---

## Endpoints del API

### AuthController
Manejo de autenticación con JWT.

- POST /api/auth/login
    - Descripción: Endpoint para autenticar usuarios y obtener un token JWT.
    - Parámetros: 
      {
        "correo": "user@example.com",
        "contrasena": "password123"
      }
    - Respuesta exitosa:
      {
        "token": "JWT_TOKEN_GENERADO"
      }

---

### LibroController
Gestión de libros en el sistema.

- POST /api/libros/admin
    - Descripción: Crea un nuevo libro (Acceso restringido a administradores).
    - Cuerpo de solicitud:
      {
        "titulo": "Nombre del libro",
        "autorId": 1,
        "categoriaId": 2
      }

- GET /api/libros/public
    - Descripción: Obtiene la lista de todos los libros (Acceso público).

- GET /api/libros/public/{id}
    - Descripción: Obtiene los detalles de un libro por su ID (Acceso público).

- GET /api/libros/public/titulo/{titulo}
    - Descripción: Busca un libro por su título. Si no existe en la base de datos, busca en una API externa.

- GET /api/libros/public/autor/{id}
    - Descripción: Obtiene libros por ID de autor (Acceso público).

- GET /api/libros/public/categoria/{id}
    - Descripción: Obtiene libros por ID de categoría (Acceso público).

- POST /api/libros/admin/actualizar/{id}
    - Descripción: Actualiza la información de un libro existente (Acceso restringido a administradores).
    - Cuerpo de solicitud:
      {
        "titulo": "Nuevo título",
        "autorId": 1,
        "categoriaId": 3
      }

- DELETE /api/libros/admin/{id}
    - Descripción: Elimina un libro por su ID (Acceso restringido a administradores).

---

## Cómo clonar y ejecutar este proyecto

1. Clonar el repositorio:
   git clone https://github.com/tu-usuario/tu-repositorio.git
   cd tu-repositorio

2. Configurar la base de datos:
   - Asegúrate de tener PostgreSQL instalado y en ejecución.
   - Crea una base de datos llamada library_db.
   - Actualiza las credenciales en el archivo application.properties o application.yml:
     spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña

3. Ejecutar la aplicación:
   - Con Maven:
     mvn spring-boot:run
   - O con tu IDE ejecutando la clase principal LibraryApplication.

4. Probar los endpoints en Postman:
   - Autenticación:
     1. Haz una solicitud POST al endpoint /api/auth/login con los datos del usuario.
     2. Copia el token obtenido en la respuesta.
   - Acceso a endpoints protegidos:
     - Agrega el token al encabezado de tus solicitudes:
       Authorization: Bearer JWT_TOKEN
   - Realiza las solicitudes según los endpoints descritos anteriormente.

---

## Notas adicionales

- Este proyecto utiliza controladores para diferenciar claramente entre las operaciones públicas y las restringidas.
- Es importante configurar correctamente los roles y permisos en Spring Security para garantizar que los endpoints restringidos solo sean accesibles por administradores.
- Para obtener libros desde una API externa, el endpoint /api/libros/public/titulo/{titulo} realiza una búsqueda extendida en caso de no encontrar el libro en la base de datos local.

---

Cualquier pregunta o sugerencia, no dudes en contactarme. ¡Gracias por utilizar esta API! 🚀
