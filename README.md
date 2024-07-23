# API Rest desarrollado por el Grupo 3 para la Comunidad ONE (Oracle Next Education) en la Primera Hackaton del 2024

Creación de una API Rest, con los métodos CRUD correspondientes. Este proyecto es un sistema de gestión para un hotel que permite manejar reservas, habitaciones, servicios, atracciones y clientes. 


## Pasos para hacer pruebas locales 🚀


1 Realiza un git clone:

```
git clone https://github.com/iancinti/hotel-g3-back/tree/develop
```

2)_Abre el archivo_ SpringJdbcConfig _donde debes indicar la URL de tu base de datos, el Usuario y el Password para la persistencia de los datos_

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

### Pre-requisitos 📋

_Es necesario tener esto instalado antes de ejecutar el proyecto de manera local_

- Git 
- Java 17

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

![](https://github.com/iancinti/hotel-g3-back/blob/develop/diagrams/Swagger-io.png)
![](https://github.com/iancinti/hotel-g3-back/blob/develop/diagrams/Swagger.png)

### http://localhost:8080/swagger-ui/index.html