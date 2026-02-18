# Práctica pair programming

Este proyecto contiene una serie de ejercicios enfocados en el manejo de excepciones en Java.

Cada clase representa un ejercicio diferente donde se aplican conceptos básicos y avanzados del manejo de errores.

## Descripción de los Ejercicios
# Ejercicio1

Se utiliza un bloque try-catch para capturar la excepción y mostrar el mensaje del error usando:

e.getMessage()

## Ejercicio2

Se realiza nuevamente el mismo código pero en este caso
Se imprime el stack trace con:
e.printStackTrace(System.out);


Se agrega un bloque finally que imprime:
Programa finalizado.

## Ejercicio3

Aquí se crea una excepción personalizada:
public class Ejercicio3 extends Exception

Esta clase recibe un mensaje en su constructor y lo envía a la clase padre usando super(mensaje).

## Ejercicio4

Se crea un método que lanza la excepción personalizada:
public void metodoExcepcion() throws Ejercicio3

En el main, se:
- Crea una instancia del objeto.
- Se invoca el método.
- Se captura la excepción personalizada.

## Ejercicio5

En este ejercicio:
Ejercicio4 prueba = null;


Se asigna null a la variable y luego se intenta llamar un método.
Esto provoca una excepción porque el objeto no existe realmente en memoria.

## Ejercicio6

Este ejercicio demuestra la propagación de excepciones.
Se tienen dos métodos:

- a() → Lanza la excepción personalizada.
- b() → Llama a a(), captura la excepción y lanza una nueva excepción diferente.
- main() → Captura la excepción final y muestra el stack trace.

### Flujo del programa:
main → b() → a()


Con este ejercicio se comprende cómo las excepciones pueden:
- Ser capturadas.
- Ser relanzadas.
- Viajar entre métodos.
