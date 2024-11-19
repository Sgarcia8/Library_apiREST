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
git clone https://github.com/Sgarcia8/Library_apiREST.git
cd API
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

Después de agregar estas dependencias, sincroniza tu proyecto en el IDE, si no cuentas con estas dependencias puedes incluirlas en tu IDE usando los .jar que se encuentran en la carpeta libs.

## Configuración de la Base de Datos

Configura las credenciales de PostgreSQL en el archivo `application.properties` o `application.yml`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_tu_base
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
api.openLibrary.url=https://openlibrary.org/search.json?title=
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
| POST   | `/api/auth/login`  | Generar un token de autenticación usando un correo y contraseña. |

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
    1. Creación de libros en el sistema (ADMIN)
        - **URL**: `http://localhost:8080//api/libros/admin`
        - **Método**: POST
        - **Body** (raw JSON):
        ```json
         {
            "titulo": "Dune 3",
            "añoPublicacion": 2020,
            "disponibilidad": true,
            "descripcion": "Libro de ciencia ficción",
            "librosPrestado": [],
            "autor": {
                "idAutor": 2
            },
            "categoria": {
                "idCategoria": 2
            }
        }
        ```
    2. Modificación de libros en el sistema (ADMIN)
        - **URL**: `http://localhost:8080//api/libros/admin`
        - **Método**: POST
        - **Body** (raw JSON):
        ```json
         {
            "idLibro": 2,
            "titulo": "Dune 3",
            "añoPublicacion": 2020,
            "disponibilidad": true,
            "descripcion": "Libro de ciencia ficción",
            "librosPrestado": [],
            "autor": {
                "idAutor": 2
            },
            "categoria": {
                "idCategoria": 2
            }
        }
        ```
    3. El resto de endpoints no necesitan un body

## Notas

- Requiere Java 21 o superior.
- Asegúrate de que PostgreSQL esté en ejecución.
- Este proyecto utiliza controladores para diferenciar claramente entre las operaciones públicas y las restringidas.
- Es importante configurar correctamente los roles y permisos en Spring Security para garantizar que los endpoints restringidos solo sean accesibles por administradores.
- Para obtener libros desde una API externa, el endpoint /api/libros/public/titulo/{titulo} realiza una búsqueda extendida en caso de no encontrar el libro en la base de datos local.
- En el proyecto se encuentra en txt con información para llenar la base de datos y probar el código
- En el txt las contraseñas de los usuarios estan encriptadas con Bcrypt, la contraseña para cada usuario es la siguiente
  
| usuario | contraseña    | 
|--------|----------------|
| Usuario1  | 12345       | 
| Usuario2  | 1234        |
| Usuario3  | 123         | 
| Usuario4  | 12          |
| Usuario5  | 1           |
| Usuario6  | 123456      |
| Usuario7  | 1234567     |
| Usuario8  | 12345678    |
| Usuario9  | 123456789   |
| Usuario10 | 12345678910 |

---

Cualquier pregunta o sugerencia, no dudes en contactarme. ¡Gracias por utilizar esta API! 🚀

