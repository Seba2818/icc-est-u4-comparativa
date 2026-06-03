# Práctica de Comparación de Algoritmos de Ordenamiento
## Universidad Politécnica Salesiana
### Nombre: Sebastian Muñoz
### Fecha: 02/06/2026
### Grupo: 1 
###  Tutor: Pablo Torres
---

## Descripción

Este proyecto tiene como objetivo comparar el rendimiento de los algoritmos de ordenamiento **Insertion Sort** y **Quick Sort** utilizando arreglos de objetos `Persona`.

La práctica consiste en generar conjuntos de datos de distintos tamaños, ordenarlos mediante ambos algoritmos y medir sus tiempos de ejecución para analizar cuál ofrece un mejor desempeño.

---

# Descripción de las Clases

## Persona

Representa una persona mediante dos atributos:

- Nombre
- Edad

Además, contiene un criterio de ordenamiento que combina ambos valores para facilitar la comparación entre objetos.

## GeneradorPersonas

Genera arreglos de objetos `Persona` con edades aleatorias.

## SortPersonaMethods

Contiene la implementación de los algoritmos:

- Insertion Sort
- Quick Sort

## Benchmarking

Permite medir el tiempo de ejecución utilizando `System.nanoTime()`.

## Resultado

Almacena los resultados obtenidos durante las pruebas de rendimiento.

---

# Criterio de Ordenamiento

El ordenamiento de las personas se realiza mediante el siguiente criterio:

```java
return edad * 10000 + valorNombre;
```

Donde:

- La edad es el criterio principal.
- El valor acumulado de los caracteres del nombre funciona como criterio secundario.

---

# Algoritmos Implementados

## Insertion Sort

### Características

- Complejidad promedio: **O(n²)**
- Complejidad en el peor caso: **O(n²)**
- Fácil de implementar.
- Adecuado para arreglos pequeños o casi ordenados.

### Ventajas

- Implementación sencilla.
- Buen rendimiento en arreglos pequeños.

### Desventajas

- Muy lento para grandes cantidades de datos.

---

## Quick Sort

### Características

- Complejidad promedio: **O(n log n)**
- Utiliza particiones recursivas.
- Excelente rendimiento en arreglos grandes.

### Ventajas

- Muy eficiente para grandes volúmenes de datos.
- Escala mejor que Insertion Sort.

### Desventajas

- Implementación más compleja.
- Puede degradarse en ciertos casos específicos.

---

# Resultados Obtenidos

### Escenario 1: Arreglo completamente desordenado

| Tamaño de muestra | Insertion Sort (ms) | Quick Sort (ms) | Algoritmo más rápido |
|------------------|---------------------|-----------------|----------------------|
| 10.000 | 26.52 | 3.16 | Quick Sort |
| 50.000 | 974.26 | 13.70 | Quick Sort |
| 100.000 | 2942.23 | 53.08 | Quick Sort |

---

### Escenario 2: Arreglo casi ordenado (ordenado + 1 elemento fuera de lugar)

| Tamaño de muestra | Insertion Sort (ms) | Quick Sort (ms) | Algoritmo más rápido |
|------------------|---------------------|-----------------|----------------------|
| 10.001 | 0.1073 | 0.7982 | Insertion Sort |
| 50.001 | 0.2665 | 15.5555 | Insertion Sort |
| 100.001 | 1.0149 | 55.9813 | Insertion Sort |

---

# Análisis de Resultados

### Escenario 1: Datos completamente desordenados

En este escenario, Quick Sort presenta un mejor rendimiento en todos los tamaños de muestra evaluados.

Insertion Sort muestra un crecimiento cuadrático en el tiempo de ejecución, lo que coincide con su complejidad O(n^2), lo que lo hace ineficiente para grandes volúmenes de datos.

---

### Escenario 2: Datos casi ordenados

En este escenario, Insertion Sort presenta un rendimiento significativamente mejor debido a que su complejidad mejora considerablemente cuando los datos están casi ordenados.

Quick Sort presenta un rendimiento inferior debido a la degradación del particionado cuando el pivote no divide de forma equilibrada el arreglo.

---

# Comparación General

| Característica | Insertion Sort | Quick Sort |
|---------------|---------------|------------|
| Facilidad de implementación | Alta | Media |
| Rendimiento en arreglos pequeños | Bueno | Bueno |
| Rendimiento en arreglos grandes | Bajo | Excelente |
| Complejidad promedio | O(n²) | O(n log n) |
| Uso recomendado | Datos pequeños o casi ordenados | Grandes volúmenes de datos |

---

# Conclusiones

## Conclusión 1

Quick Sort presentó el mejor rendimiento en todas las pruebas realizadas, obteniendo tiempos considerablemente menores que Insertion Sort para cada tamaño de muestra evaluado.

## Conclusión 2

El crecimiento del tiempo de ejecución de Insertion Sort fue mucho más pronunciado a medida que aumentó el tamaño del arreglo, lo que confirma las limitaciones de su complejidad temporal **O(n²)**.

## Conclusión 3

Quick Sort mantuvo tiempos relativamente bajos incluso con 100.000 elementos, demostrando ser una alternativa más eficiente para aplicaciones que requieren procesar grandes cantidades de información.

## Conclusión 4

La práctica permitió comprobar experimentalmente cómo la complejidad algorítmica influye directamente en el rendimiento de un programa y en la selección de la estrategia de ordenamiento más adecuada.

