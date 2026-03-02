# Parcial 1 - Manejo de Excepciones
**Experiencia Educativa:** Programación para Aplicaciones de Escritorio  
**Universidad:** Universidad Veracruzana - Campus Coatzacoalcos  
**Programa Educativo:** Ingeniería de Software  
**Fecha:** 25 de febrero de 2026  

---

## 📌 Descripción del Proyecto

Este proyecto implementa un diagrama UML que incluye las siguientes clases:

- GeometricObject
- Triangle
- Rectangle
- Circle
- IllegalTriangleException

El objetivo principal es aplicar:

- Herencia
- Sobreescritura de métodos
- Manejo de excepciones personalizadas
- Uso de try-catch
- Aplicación de la Fórmula de Herón
- Validación de la regla del triángulo

---

## 📐 Regla del Triángulo

Un triángulo es válido cuando:

La suma de dos lados cualesquiera es mayor que el tercero.

Si esta regla no se cumple, se lanza la excepción personalizada:

`IllegalTriangleException`

---

## 🧮 Fórmula utilizada para el área del triángulo

Se aplicó la **Fórmula de Herón**:

s = (a + b + c) / 2  
Área = √( s (s - a)(s - b)(s - c) )

---

## ▶ Cómo ejecutar

1. Compilar todas las clases.
2. Ejecutar la clase `TestTriangle`.
3. Ingresar los valores solicitados:
   - Lado 1
   - Lado 2
   - Lado 3
   - Color
   - Si está relleno (true/false)

---

## 🧱 Estructura del Proyecto
src/
├── GeometricObject.java
├── Triangle.java
├── Rectangle.java
├── Circle.java
├── IllegalTriangleException.java
└── TestTriangle.java


---

## 🛠 Tecnologías usadas

- Java
- Programación Orientada a Objetos
- Manejo de Excepciones


