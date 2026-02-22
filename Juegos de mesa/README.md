# 🎮 Juegos en Java: Tres en Raya & MasterMind

Este proyecto contiene dos juegos clásicos programados en Java:

- 🟦 **Tres en Raya**
- 🟨 **MasterMind**

Ambos se ejecutan por consola y utilizan entrada por teclado mediante `Scanner`.

---

## 📁 Estructura del proyecto


/Proyecto
│
├── TresRaya.java
├── MasterMind.java
└── README.md


---

# 🟦 Tres en Raya

## 📌 Descripción

Juego clásico para dos jugadores donde deben colocar sus fichas (`X` y `O`) en un tablero 3x3.

Gana el jugador que consiga:

- 3 en línea horizontal
- 3 en línea vertical
- 3 en diagonal

---

## ▶ Cómo ejecutar

Compilar:

```bash
javac TresRaya.java

Ejecutar:

java TresRaya
🎯 Cómo jugar

El jugador X empieza.

Se introduce:

Fila (1–3)

Columna (1–3)

El juego valida:

Que la fila y columna existan

Que la posición no esté ocupada

El juego termina cuando:

Un jugador gana

Se acaban los turnos (empate)

🧠 Lógica implementada

Matriz char[3][3] como tablero

Control de turnos alternando con variable turnos

Método comprobarGanar() que verifica:

3 filas

3 columnas

2 diagonales

🟨 MasterMind
📌 Descripción

Juego donde el jugador debe adivinar una combinación secreta de 4 números.

El jugador elige:

Número de opciones posibles

Número de intentos

Después debe intentar acertar la combinación.

▶ Cómo ejecutar

Compilar:

javac MasterMind.java

Ejecutar:

java MasterMind
🎯 Cómo jugar

Se define:

Cantidad de números posibles

Número de intentos

El programa genera una combinación aleatoria.

En cada turno se introduce una combinación de 4 números.

El sistema indica:

Cuántos números están en la posición correcta

Cuántos están correctos pero en posición incorrecta

El juego termina cuando:

Se aciertan las 4 posiciones

Se acaban los intentos

🧠 Lógica implementada

Array int[4] para combinación ganadora

Matriz int[intentos][4] para guardar historial

Control correcto de números repetidos

Validación de entradas

🛠 Requisitos

Java JDK 8 o superior

Terminal o IDE (Eclipse, IntelliJ, VSCode…)

Comprobar versión instalada:

java -version
📚 Conceptos trabajados

Arrays y matrices

Bucles for y while

Condicionales

Métodos

Validación de datos

Lógica de juego

Interacción por consola

🚀 Posibles mejoras futuras

Interfaz gráfica (JavaFX o Swing)

Sistema de puntuación

Reinicio automático de partida

Inteligencia artificial para Tres en Raya

Sistema de colores en MasterMind

👨‍💻 Autor

Proyecto académico de práctica de programación en Java.


---

Si quieres, puedo hacer una **versión más resumida y profesional**, lista para subir a **GitHub**, con badges de compilación y “how to play” en un solo vistazo.  

¿Quieres que haga esa versión?
si

Perfecto 😎, aquí tienes una versión profesional y resumida del README lista para GitHub, con formato limpio, badges opcionales y todo en un vistazo:

# 🎮 Juegos en Java: Tres en Raya & MasterMind

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Consola](https://img.shields.io/badge/Plataforma-Consola-blue?style=for-the-badge)

Este proyecto contiene dos juegos clásicos programados en Java:

- 🟦 **Tres en Raya**
- 🟨 **MasterMind**

Ambos juegos se ejecutan por **consola** y usan entrada por teclado (`Scanner`).

---

## 📁 Estructura del proyecto


/Proyecto
├── TresRaya.java
├── MasterMind.java
└── README.md


---

## 🟦 Tres en Raya

**Descripción:**  
Juego para 2 jugadores, donde deben colocar fichas `X` y `O` en un tablero 3x3.  
Gana quien consiga 3 en línea (horizontal, vertical o diagonal).

**Ejecución:**

```bash
javac TresRaya.java
java TresRaya

Cómo jugar:

Turnos alternos (X empieza).

Introducir fila (1–3) y columna (1–3).

El juego valida posición y turno.

Termina al ganar un jugador o al completarse los turnos.

🟨 MasterMind

Descripción:
Juego donde debes adivinar una combinación secreta de 4 números.

Ejecución:

javac MasterMind.java
java MasterMind

Cómo jugar:

Elegir número de opciones posibles y cantidad de intentos.

Introducir una combinación de 4 números por turno.

El juego indica:

Números en posición correcta.

Números correctos fuera de posición.

Termina al acertar la combinación o al agotarse los intentos.

🛠 Requisitos

Java JDK 8 o superior

Terminal o IDE (Eclipse, IntelliJ, VSCode…)

java -version
📚 Conceptos aplicados

Arrays y matrices

Bucles for y while

Condicionales y validación de datos

Métodos y modularización

Lógica de juego y control de turnos

Interacción por consola

🚀 Mejoras posibles

Interfaz gráfica (JavaFX o Swing)

Inteligencia artificial para Tres en Raya

Sistema de puntuación y ranking

Colores para MasterMind como en el juego original

Reinicio automático de partida
