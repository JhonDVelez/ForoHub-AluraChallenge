<h1 align="center">
  Foro Hub
</h1>

![networking](https://github.com/user-attachments/assets/62c17ccf-9f2d-4e91-a804-e6f711ae3209)

# Introducción 

Este proyecto consiste en un API Rest basado en un foro donde se será necesario registrar un usuario y luego iniciar sesión para obtener una autenticación que se hará por medio de un JSON Web Token(JWT), esta autenticación permite tres tipos de roles, Miembro (Usuario Común), Moderador(Encargado de supervisar los tópicos y sus respuestas con la opción de eliminarlos) y por ultimo el Administrador(Que podrá hacer las tareas de un moderador y adicionalmente crear, modificar y eliminar los cursos del foro).

Se podran crear topicos para los cursos o responder a topicos de otros usuarios.

# Como se usa

Las pruebas realizadas a continuación se realizaron en la herramienta Insomnia, pero si lo desea puede dirigirse a la ruta  http://localhost:8080/swagger-ui/index.html (Si es necesario se debe cambiar la puerta utilizada) Donde esta implementada la documentación que hace uso de la Librería de OpenAPI 3 que junto con Spring Boot ofrecen una documentación automática interactiva donde verá la estructura del proyecto, los request posibles así como realizar las mismas pruebas que se realizarán. 

Primero debemos crear un usuario, este será creado automáticamente con el rol de Miembro.

![image](https://github.com/user-attachments/assets/58120af4-c65e-47fc-a8a8-1a6b617df2a1)

Luego de esto, realizamos un POST en login para ingresar usuario poniendo en el body de la request el nombre de usuario y contraseña con los que nos registramos anteriormente.

Una vez enviada la request se retorna el token que usaremos en las siguientes pruebas ya que era necesario para autenticar que el usuario ingresó y darle acceso a los métodos que desee.

![image](https://github.com/user-attachments/assets/12fd3dc7-92ab-4f73-b4ef-c19f4ae3095f)

Para ello en la sección de Auth seleccionamos Bearer Token y pegamos el token que obtuvimos anteriormente.

![image](https://github.com/user-attachments/assets/b15ad55a-0401-438f-b81a-a576269b6f98)

Hecho esto ya podemos probar las demás query que se tienen como por ejemplo, si queremos registrar un nuevo topico, lo primero seria obtener los cursos que estan disponibles.

![image](https://github.com/user-attachments/assets/4bc4edec-2159-4e76-9ab2-cafa1f0d5b52)

Para este ejemplo se desea crear un topico en el curso de Java con Spring Boot que tiene el id 2 y el id de nuestro usuario era el 6 entonces se ingresan los datos de la siguiente forma.

![image](https://github.com/user-attachments/assets/823b306f-f18b-484f-a134-442bd3e92950)

Se observa como el retorno incluye el topico creado con sus los datos ingresados y algunos adicionales como el tipo que este caso no se ingreso, además de la informacion del creador y del curso en el que se registro.

De esta forma puede realizar las diferentes querys que se implementaron, que son las siguientes.

# API Endpoints

### /usuarios
- **GET** - Obtiene una lista de todos los usuarios.
- **POST** - Crea nuevos usuarios.
- **DELETE** - Elimina usuarios (requiere ser ADMIN).
- **PUT** - Actualiza datos del usuario.

### /usuarios/id
- **GET** - Obtiene los detalles completos del usuario.
- **DELETE** - Elimina de manera lógica el usuario con el id indicado.

### /cursos
- **GET** - Obtiene una lista de los cursos almacenados.
- **POST** - Crea un nuevo curso.
- **DELETE** - Elimina un curso.
- **PUT** - Actualiza la información de un curso.

### /topicos
- **GET** - Muestra todos los tópicos almacenados.
- **POST** - Crea un nuevo tópico.

### /topicos/idTopico
- **GET** - Entrega datos del creador, los datos del tópico y las respuestas que tiene. Las respuestas incluirán los autores, la hora de creación y los mensajes.
- **DELETE** - Elimina el post.
- **POST** - Agrega nuevas respuestas a un determinado tópico.
- **PUT** - Permite al creador modificar el tópico.

### /topicos/idTopico/idRespuesta
- **GET** - Obtiene los datos de la respuesta específica.
- **PUT** - Edita la respuesta ya almacenada.
- **DELETE** - Elimina la respuesta almacenada.

# Referencias

- [HttpRequest Java](https://docs.oracle.com/en/java/javase/22/docs/api/java.net.http/java/net/http/HttpRequest.html)
- [Insomnia API tests](https://insomnia.rest/)
- [MySQL](https://www.mysql.com/)
- [Spring Doc](https://springdoc.org/)



