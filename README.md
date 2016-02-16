# Perrera
Aplicación para gestionar perros en adopcion.

La aplicacion en su primera versión v1.0.1 consiste en un proyecto principal perrera.pom (mavenizado) compuesto de los siguientes modulos:

1/ MODULO WEB. Proyecto perrera_web.war (Capa web + capa coontroladora (servlets))

2/ MODULO SERVICIOS. Proyecto perrera_service.jar (Capa servicios)

3/ MODULO MODELO. Proyecto perrera_model.jar (Capa modelo (DAOs + POJOs))

------------------------------------------------------------------------------

BASE DE DATOS MySql

Para poder crear la base de datos "santisvs" debemos ejecutar el script "createBBDD.sql".

Ruta: perrera/script

La base de datos consiste en:

1/ 1 Tabla "perro"
  - Id
  - Nombre
  - Raza
  - Sexo
  - 

2/ 5 Procesos Almacenados
  - getAll
  - getById
  - insertReg
  - updateReg
  - deleteById


