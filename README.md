# Validador de Correos Electrónicos en Java

Aplicación desarrollada en **Java** con interfaz gráfica utilizando **Swing** que permite validar direcciones de correo electrónico mediante **expresiones regulares** y verificar si el dominio y la extensión pertenecen a listas permitidas.

## Descripción

El programa analiza un correo electrónico ingresado por el usuario y divide la dirección en diferentes **tokens** como:

* Usuario
* Arroba (@)
* Dominio
* Punto (.)
* Extensión

Posteriormente verifica si el **dominio** y la **extensión** pertenecen a listas de valores permitidos.

## Funcionalidades

* Validación de correos electrónicos mediante **expresiones regulares**.
* Identificación de los **componentes del correo**.
* Visualización de los tokens en una **tabla**.
* Verificación semántica de **dominios permitidos**.
* Verificación semántica de **extensiones permitidas**.
* Opciones para mostrar listas de dominios y extensiones válidas.

## Tecnologías utilizadas

* Java
* Java Swing
* Expresiones Regulares (Regex)

## Funcionamiento

El usuario ingresa una dirección de correo electrónico en el campo de texto y presiona **Verificar**.

El sistema:

1. Analiza la estructura del correo.
2. Divide la dirección en tokens.
3. Muestra los componentes en una tabla.
4. Verifica si el dominio y la extensión son válidos.

Si el correo cumple con todas las condiciones, el sistema muestra un mensaje indicando que el **correo es válido**.

## Autor

Ian Marcel Castrejón Cuevas
Ingeniería en Sistemas Computacionales
