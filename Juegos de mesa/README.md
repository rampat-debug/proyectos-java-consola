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
Juego para **2 jugadores**, donde deben colocar fichas `X` y `O` en un tablero 3x3.  
Gana el jugador que consiga **3 en línea** (horizontal, vertical o diagonal).

**Cómo jugar:**

1. Los jugadores se turnan (X comienza).
2. Introducir **fila (1–3)** y **columna (1–3)** para colocar la ficha.
3. El juego valida que la posición esté disponible.
4. Termina cuando un jugador gana o se llenan todas las casillas.

---

## 🟨 MasterMind

**Descripción:**  
Juego donde debes adivinar una **combinación secreta de 4 números**.

**Cómo jugar:**

1. Configura el número de **opciones posibles** y la **cantidad de intentos**.
2. Introduce una combinación de **4 números** en cada turno.
3. El juego indica:
   - Números en **posición correcta**
   - Números correctos **fuera de posición**
4. Termina cuando aciertas la combinación o se agotan los intentos.

---

## 📚 Conceptos aplicados

- Arrays y matrices
- Bucles `for` y `while`
- Condicionales y validación de datos
- Métodos y modularización
- Lógica de juego y control de turnos
- Interacción por consola
