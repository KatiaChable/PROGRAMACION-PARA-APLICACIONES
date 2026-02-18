## Calculadoras 

Este repositorio contiene dos versiones de una calculadora básica en consola para comparar cómo se pueden gestionar los errores de entrada de datos en Java. Ambos programas piden dos números y un operador para realizar una operación aritmética.

## 3Contenido del Repositorio
1. calculadoraConExcep.java
En esta versión se utiliza el bloque try-catch. El programa intenta convertir la entrada del usuario a un número entero directamente. Si el usuario escribe algo que no es un número, Java lanza una excepción de tipo NumberFormatException, el programa la captura y muestra un mensaje de error en lugar de cerrarse por completo.

## 2. calculadoraSinExcep.java
En esta versión no se usan excepciones para validar los datos. Se incluye un método manual llamado esEntero que revisa la cadena de texto carácter por carácter. Si detecta que algún carácter no es un dígito (o un signo menos al principio), determina que la entrada no es válida mediante una estructura if-else antes de intentar cualquier conversión.

## Funcionamiento General
Ambos códigos siguen el mismo flujo de ejecución:

Solicitan el primer operando.
Solicitan el operador (+, -, *, /).
Solicitan el segundo operando.
Validan que los operandos sean numéricos (cada uno con su método).
Realizan la operación mediante un switch.
Imprimen el resultado por pantalla.

 ## Diferencias Técnicas
Manejo de errores: Uno confía en el sistema de excepciones de Java para detectar fallos, mientras que el otro utiliza lógica de programación preventiva para evitar que el fallo ocurra.
Estructura: El código con excepciones suele ser más corto, mientras que el que no las usa requiere métodos auxiliares para comprobar los datos manualmente.
