# API Rest desarrollado por el Grupo 3 para la Comunidad ONE (Oracle Next Education) en la Primera Hackaton del 2024

_Creación de una API Rest, con los métodos CRUD correspondientes. Este proyecto es un sistema de gestión para un hotel que permite manejar reservas, habitaciones, servicios, atracciones y clientes. Dicha página será consumida por el Frontend_


## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas_

1)_Realiza una copia del repositorio en tu computadora local:_

```
git clone https://github.com/iancinti/hotel-g3-back/tree/develop
```

2)_Abre la ubicación del archivo dentro del IDE donde se ejecutará el código_

3)_Abre el archivo_ SpringJdbcConfig _donde debes indicar la URL de tu base de datos, el Usuario y el Password para la persistencia de los datos_

```
    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("URL_BD");
        dataSource.setUsername("USUARIO_BD");
        dataSource.setPassword("PASSWORD_BD");

        return dataSource;
    }
```

4)_Ejecuta el archivo_ HotelG3BackApplication.java _y listo!!!. Diviertete_

### Pre-requisitos 📋

_Es necesario tener esto instalado antes de ejecutar el proyecto de manera local_

- Git (instala aquí: https://git-scm.com/download/win)
- Un IDE, por ej. Intellij, para Java (instala aquí: https://www.jetbrains.com/es-es/idea/download/?section=windows)
- Java 17 o superior (instala aquí: https://www.oracle.com/ar/java/technologies/downloads/)

## Construido con 🛠️

* [Java]Lenguaje
* [Spring]Framework
* [PostgreSQL]Base de datos


# Diagrama entidad-relacion

![](https://github.com/iancinti/hotel-g3-back/blob/develop/diagrams/Entidad-Relaci%C3%B3n%20.drawio.png)

## Diagramas de clases por dominio
[Dominio Attraction](https://github.com/iancinti/hotel-g3-back/blob/feature/readme-domain/src/main/java/com/g3/hotel_g3_back/attraction/README.md)

[Dominio Booking](https://github.com/iancinti/hotel-g3-back/blob/feature/readme-domain/src/main/java/com/g3/hotel_g3_back/booking/README.md)

[Dominio Customer](https://github.com/iancinti/hotel-g3-back/blob/feature/readme-domain/src/main/java/com/g3/hotel_g3_back/customer/README.md)

[Dominio Gallery](https://github.com/iancinti/hotel-g3-back/blob/feature/readme-domain/src/main/java/com/g3/hotel_g3_back/gallery/README.md)

[Dominio Service](https://github.com/iancinti/hotel-g3-back/blob/feature/readme-domain/src/main/java/com/g3/hotel_g3_back/service/README.md)

## Pruebas

### Test General
```bash
mvn test
```

## Url Swagger-Io 

### http://localhost:8080/swagger-ui/index.html