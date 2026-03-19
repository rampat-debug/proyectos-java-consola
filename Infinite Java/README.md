# ⚔️ Infinite Java – RPG en Consola  
Proyecto académico desarrollado como **práctica grupal de clase** para trabajar lógica de juego, estructuras de datos y Programación Orientada a Objetos.  
Simula un RPG por turnos en consola donde el jugador combate contra enemigos, sube de nivel y gestiona inventario.

---

## 🎯 Objetivos de aprendizaje  
A través de este proyecto se trabajaron los siguientes conceptos:

- Programación Orientada a Objetos (POO)  
- Uso de colecciones (`ArrayList`)  
- Encapsulamiento y clases (`Personaje`, `Protagonista`, `Enemigo`, `Item`)  
- Herencia conceptual y composición de objetos  
- Lógica de combate por turnos  
- Generación aleatoria (`Math.random`)  
- Entrada y salida por consola (`Scanner`)  
- Control de errores con excepciones (`InputMismatchException`)  
- Gestión de inventario y sistema de tienda  

---

## 📂 Funcionalidades  

- Crear y modificar personajes (protagonistas o enemigos)  
- Crear y editar objetos (curativos o equipables)  
- Sistema de combate por turnos contra múltiples enemigos  
- Daño variable con posibilidad de golpe crítico  
- Sistema de rondas con dificultad progresiva  
- Enemigos escalados según la ronda  
- Sistema de inventario (bolsa)  
- Uso de objetos curativos durante el combate  
- Sistema de equipamiento (armaduras) que mejora estadísticas  
- Tienda entre rondas para comprar objetos  
- Sistema de oro como recompensa tras combates  
- Posibilidad de huir con penalización  
- Selección de dificultad (fácil o difícil)  
- Menú interactivo en consola  

---

## 🛠️ Tecnologías utilizadas  

- Java  
- Programación Orientada a Objetos  
- Colecciones (`ArrayList`)  
- Entrada y salida por consola  
- Manejo de excepciones  
- Generación aleatoria  

---

## 🎮 Mecánicas del juego  

- Cada ronda genera enemigos aleatorios  
- El jugador puede:
  - Atacar  
  - Usar objetos  
  - Huir  
- Los enemigos atacan automáticamente tras el turno del jugador  
- Al ganar:
  - Obtienes oro  
  - Subes estadísticas  
  - Accedes a una tienda  
- El juego termina cuando el protagonista muere  

---

## 🧱 Estructura del proyecto  

- `Personaje` → Clase base con estadísticas (ATK, DEF, HP)  
- `Protagonista` → Jugador con inventario, oro y equipo  
- `Enemigo` → NPCs con recompensa de oro  
- `Item` → Objetos (curativos o armadura)  
- `Tipo` → Enum para diferenciar tipos de objetos  
- `App` → Lógica principal del juego y menú  