# Actividad 3 — Programación Orientada a Objetos

**Universidad Nacional de Colombia — Sede Medellín**  
**Asignatura:** Programación Orientada a Objetos (2026-2)  
**Docente:** Walter Hugo Arboleda Mazo  
**Estudiante:** Daniel Ossa Velásquez  
**Entrega:** individual (10 %) — 22 de octubre de 2026  
**Repositorio:** https://github.com/DOVRC/Actividad-3-POO-2026-2

## Descripción

Este repositorio corresponde a la Actividad 3. Se trabajan dos ejercicios del capítulo 8 del libro *Ejercicios de programación orientada a objetos con Java y UML*, de Leonardo Bermón Angarita, usando Java y Swing.

Cada ejercicio incluye el código fuente, diagramas UML (clases, objetos y casos de uso), capturas de la interfaz y un README con la explicación y la forma de ejecutarlo. También se desarrollan los ejercicios propuestos al final de cada sección.

## Contenido del repositorio

| Elemento | Descripción |
| --- | --- |
| Código fuente Java | Paquetes `Notas` (8.2) y `Figuras` (8.3) |
| Diagramas UML | Clases, objetos y casos de uso (PlantUML e imágenes PNG) |
| Capturas de interfaz | Evidencias reales de ejecución en cada ejercicio |
| Recursos gráficos | Imágenes de las figuras geométricas del ejercicio 8.3 |

## Ejercicios

| Ejercicio | Tema | Páginas impresas |
| --- | --- | --- |
| [8.2](ejercicio_8_2/) | Componentes Swing — cálculo de notas | 480–494 (enunciado p. 483) |
| [8.3](ejercicio_8_3/) | Gestión de eventos — figuras geométricas | 494–517 (enunciado p. 495) |

Los ejercicios están en carpetas independientes para poder compilarlos y ejecutarlos por separado.

## Requisitos de ejecución

- JDK 21 (o compatible), con `java` y `javac` en el PATH.
- No se usan Maven, Gradle ni otras bibliotecas externas.
- Compilación con UTF-8.

Ejercicio 8.2 (desde `ejercicio_8_2/`):

```text
javac -encoding UTF-8 -d out src/Notas/*.java
java -cp out Notas.Principal
```

Ejercicio 8.3 (desde `ejercicio_8_3/`, con recursos gráficos):

```text
javac -encoding UTF-8 -d out src/Figuras/*.java
java -cp "out;resources" Figuras.Principal
```

En Linux o macOS usar `out:resources` en el classpath.

## Referencia

Bermón Angarita, L. (2021). *Ejercicios de programación orientada a objetos con Java y UML*. Editorial Universidad Nacional de Colombia.
