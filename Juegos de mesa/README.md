# 🎮 Juegos en Java: Tres en Raya & MasterMind

Este proyecto contiene dos juegos clásicos programados en Java:

- 🟦 **Tres en Raya**
- 🟨 **MasterMind**

Ambos juegos se ejecutan por **consola** y usan entrada por teclado (`Scanner`).

---

## 📁 Estructura del proyecto


/src
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


