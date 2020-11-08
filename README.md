# Netflix

#### Raúl Morales Ruiz

---

## Introducción

El objetivo del proyecto es trabajar sobre un sistema de contenido en streaming, como Netflix.

En el apartado de funciones disponibles se indican las distintas posibilidades del proyecto.

## Requisitos

- Tener instalado [Spring Tool Suite](https://spring.io/tools), para la parte backend.
- Utilizar algún navegador web (preferiblemente [Google Chrome](https://www.google.com/intl/es_es/chrome/)), para la parte frontend.

## Preparación del entorno

Para utilizar la aplicación web, primero debemos descargar los entornos backend y frontend.

- Descargamos el [proyecto](https://github.com/raulmoralesruiz/DWES_netflix) desde el siguiente enlace:
  https://github.com/raulmoralesruiz/DWES_netflix

### Backend

- Importamos el proyecto en Spring.

        File -> Import -> Maven -> Existing Maveng Projects

        Una vez agregado el proyecto, Spring descargará las dependencias necesarias (podemos comprobarlo en la esquina inferior derecha.)

- Iniciamos el servidor desde Spring

        Tras importar el proyecto, iniciamos el servidor desde el apartado "Boot Dashboard" (normalmente ubicado en la parte inferior izquieda.)

        Desplegamos el botón "local" -> click botón derecho sobre "jacaranda2" -> click sobre start

## Funciones disponibles

### Customer

#### GET

- Leer clientes

        Petición:
        localhost:8080/netflix/customer

- Leer clientes, filtrando por ciudad

        Petición:
        localhost:8080/netflix/customer/city/sevilla

        Podemos sustituir "sevilla" por la ciudad que queramos buscar.

- Leer clientes, ordenando por DNI

        Petición:
        localhost:8080/netflix/customer/dni

- Leer clientes, obteniendo todos los nombres de usuario

        Petición:
        localhost:8080/netflix/customer/username

- Leer un cliente, filtrando por ID

        Petición:
        localhost:8080/netflix/customer/1

        Podemos sustituir "1" por el ID del cliente que queramos buscar.

- Leer un cliente, filtrando por nombre y apellido

        Petición:
        localhost:8080/netflix/customer/raul/morales

        Podemos sustituir "raul" por el nombre del cliente que queramos buscar.
        De la misma forma, también podemos sustituir "morales" por otro apellido.

#### POST

- Crear cliente

        Petición:
        localhost:8080/netflix/customer

        Debemos especificar el cuerpo (body) con los datos del usuario que vamos a crear.
        Por ejemplo:

        {
        "username": "raulmr",
        "name": "Raúl",
        "surname": "Morales",
        "address": "Calle Falsa, 123",
        "city": "Sevilla",
        "dni": "11112222A"
        }

#### DELETE

- Borrar cliente

        Petición:
        localhost:8080/netflix/customer/1

### Suscription (Customer)

#### GET

- Leer todas las suscripciones

        Petición:
        localhost:8080/netflix/suscription

- Leer suscripción de un cliente concreto

        Petición:
        localhost:8080/netflix/suscription/c1

        Podemos sustituir "1" por el ID de cliente que queramos.

#### POST

- Crear/insertar suscripción a un cliente

        Petición:
        localhost:8080/netflix/suscription/c1

        Podemos sustituir "1" por el ID de cliente que queramos.

        Debemos especificar el cuerpo (body) con los datos de la suscripción que vamos a crear.
        Por ejemplo:

        {
        "start": "2020-07-01T02:00:00",
        "end": "2020-10-01T02:15:00",
        "typeOfSuscription": "BASIC"
        }

#### DELETE

- Borrar suscripción de un cliente

        Petición:
        localhost:8080/netflix/suscription/c1

        Podemos sustituir "1" por el ID de cliente que queramos.

### Visual (Customer)

#### GET

- Leer todas las visualizaciones

        Petición:
        localhost:8080/netflix/visual

- Leer visualización de un cliente concreto

        Petición:
        localhost:8080/netflix/visual/c1

        Podemos sustituir "1" por el ID de cliente que queramos.

#### POST

- Crear/insertar visualización a un cliente

        Petición:
        localhost:8080/netflix/visual/c1/p1

        c1: Corresponde al id de cliente.
        Podemos sustituir "1" por el ID de cliente que queramos.

        p1: Corresponde al id de producto.
        Podemos sustituir "1" por el ID de producto que queramos.

        Debemos especificar el cuerpo (body) con los datos de la visualización que vamos a crear.
        Por ejemplo:

        {
        "inicio": "2020-07-01T02:00:00",
        "fin": "2020-10-01T02:15:00"
        }

#### DELETE

- Borrar visualización de un cliente

        Petición:
        localhost:8080/netflix/visual/c1/v1

        c1: Corresponde al id de cliente.
        Podemos sustituir "1" por el ID de cliente que queramos.

        v1: Corresponde al id de visualización.
        Podemos sustituir "1" por el ID de visualización que queramos.

### Product

#### GET

- Leer todos los productos

        Petición:
        localhost:8080/netflix/products/

- Leer producto concreto

        Petición:
        localhost:8080/netflix/products/1

        Podemos sustituir "1" por el ID de producto que queramos.

- Leer lista de productos correspondientes a tipo de suscripción básico

        Petición:
        localhost:8080/netflix/products/basic/

- Leer lista de productos correspondientes a tipo de suscripción premium

        Petición:
        localhost:8080/netflix/products/premium/

#### POST

- Crear un producto con tipo de suscripción básico

        Petición:
        localhost:8080/netflix/products/

        Debemos especificar el cuerpo (body) con los datos del producto que vamos a crear.
        Por ejemplo:

        {
        "title": "película básica",
        "categoria": "SCIFI",
        "tipoContenido": "MOVIE",
        "tipoSuscripcion": "BASIC"
        }

- Crear un producto con tipo de suscripción premium

        Petición:
        localhost:8080/netflix/products/

        Debemos especificar el cuerpo (body) con los datos del producto que vamos a crear.
        Por ejemplo:

        {
        "title": "película premium",
        "categoria": "SCIFI",
        "tipoContenido": "MOVIE",
        "tipoSuscripcion": "PREMIUM"
        }

#### DELETE

- Borrar visualización de un cliente

        Petición:
        localhost:8080/netflix/products/1

        Podemos sustituir "1" por el ID de producto que queramos.
