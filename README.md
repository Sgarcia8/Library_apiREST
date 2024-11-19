# API REST para Gestión de Libros

## Descripción del Proyecto

Este proyecto es una API REST desarrollada con Spring Boot que permite gestionar libros, autores y categorías. La API incorpora autenticación y autorización utilizando Java Security y JWT. Además, se utiliza PostgreSQL como base de datos relacional.

## Tecnologías Usadas

- **Spring Boot**: Framework principal para construir la API REST.
- **Spring Security**: Implementación de seguridad en endpoints.
- **JWT**: Para autenticación y manejo de sesiones seguras.
- **PostgreSQL**: Motor de base de datos.
- **Postman**: Para pruebas de los endpoints.

## Clonar el Proyecto

```bash
git clone <URL_DEL_REPOSITORIO>
cd <NOMBRE_DEL_PROYECTO>
```

## Instalación de Dependencias

Asegúrate de tener un IDE como IntelliJ IDEA o Eclipse configurado con soporte para Maven y Java.

### Configuración de las librerías para JWT

Añade las siguientes dependencias en tu archivo `pom.xml`:

```xml
<dependencies>
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
</dependencies>
```

Después de agregar estas dependencias, sincroniza tu proyecto en el IDE.

## Configuración de la Base de Datos

Configura las credenciales de PostgreSQL en el archivo `application.properties` o `application.yml`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_tu_base
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Ejecución del Proyecto

1. Ejecuta la aplicación desde tu IDE o usando Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

2. La API estará disponible en: `http://localhost:8080`.

## Endpoints Disponibles

### Endpoints de Libros (`/api/libros`)

| Método | Endpoint                              | Descripción                                        | Roles      |
|--------|---------------------------------------|----------------------------------------------------|------------|
| POST   | `/api/libros/admin`                   | Crear un libro.                                   | Admin      |
| GET    | `/api/libros/public`                  | Obtener todos los libros.                         | Público    |
| GET    | `/api/libros/public/{id}`             | Obtener un libro por ID.                          | Público    |
| GET    | `/api/libros/public/titulo/{titulo}`  | Buscar libro por título (o desde API externa).    | Público    |
| GET    | `/api/libros/public/autor/{id}`       | Obtener libros por autor.                         | Público    |
| GET    | `/api/libros/public/categoria/{id}`   | Obtener libros por categoría.                     | Público    |
| POST   | `/api/libros/admin/actualizar/{id}`   | Actualizar un libro existente.                    | Admin      |
| DELETE | `/api/libros/admin/{id}`              | Eliminar un libro.                                | Admin      |

### Endpoints de Autenticación (`/api/auth`)

| Método | Endpoint           | Descripción                                   |
|--------|--------------------|-----------------------------------------------|
| POST   | `/api/auth/login`  | Generar un token de autenticación con correo y contraseña. |

## Acceso a los Endpoints mediante Postman

1. Genera un token JWT en el endpoint de login:
   - **URL**: `http://localhost:8080/api/auth/login`
   - **Método**: POST
   - **Body** (raw JSON):
     ```json
     {
       "correo": "tu_correo@example.com",
       "contrasena": "tu_contraseña"
     }
     ```

2. Copia el token generado y úsalo en las solicitudes protegidas:
   - En Postman, añade un encabezado:
     ```
     Key: Authorization
     Value: Bearer <TU_TOKEN>
     ```

3. Accede a los endpoints como se describe arriba.

## Notas

- Requiere Java 17 o superior.
- Asegúrate de que PostgreSQL esté en ejecución.

¡Listo para probar!
