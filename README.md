# Diseño de Patrones en un programa de Asistencias
=====================================

Este proyecto es un ejemplo de aplicación de diseño de patrones en un sistema de asistencia estudiantil. El objetivo es demostrar cómo se pueden aplicar principios de diseño de patrones para crear un sistema más escalable, mantenible y fácil de entender.

## Patrones utilizados
--------------------

* **MVC (Model-View-Controller)**: se utiliza para separar la lógica de negocio de la presentación y la interacción con el usuario.
* **DAO (Data Access Object)**: se utiliza para encapsular la lógica de acceso a datos y proporcionar una interfaz uniforme para interactuar con la base de datos.
* **Factory**: se utiliza para crear objetos de manera dinámica y evitar la creación de instancias de manera explícita.
* **Observer**: se utiliza para notificar a los objetos que dependen de otros objetos cuando cambian sus estados.

## Estructura del proyecto
-------------------------

* **Modelos**: contiene las clases que representan los objetos de negocio, como Alumno, Profesor, Curso, etc.
* **DAO**: contiene las clases que encapsulan la lógica de acceso a datos.
* **Controladores**: contiene las clases que manejan la lógica de negocio y la interacción con el usuario.
* **Vistas**: contiene las clases que se encargan de presentar la información al usuario.

## Beneficios del diseño de patrones
---------------------------------

* **Escalabilidad**: el sistema es más fácil de escalar ya que se pueden agregar nuevos componentes sin afectar la estructura general del sistema.
* **Mantenibilidad**: el sistema es más fácil de mantener ya que se pueden modificar componentes individuales sin afectar el resto del sistema.
* **Legibilidad**: el sistema es más fácil de entender ya que se utiliza una estructura y un lenguaje común para describir los componentes y su interacción.

## Conclusión
------------

Este proyecto demuestra cómo se pueden aplicar principios de diseño de patrones para crear un sistema de asistencia estudiantil más escalable, mantenible y fácil de entender. Se espera que este proyecto sirva como ejemplo para futuros proyectos y que ayude a los desarrolladores a entender la importancia del diseño de patrones en la creación de sistemas de software.

## Tecnologías utilizadas
-----------------------

* Java
* Maven
* SQLite

## Licencia
---------

Este proyecto está licenciado bajo la licencia [MIT](LICENSE.md).
