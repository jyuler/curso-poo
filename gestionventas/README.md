# Sistema de gestión de ventas

Ejercicio de programación en Java para la materia de Programación Orientada a Objetos.

## Objetivo 
- Analizar un problema de la vida real y crear una solución usando los conocimientos adquiridos en el lenguaje Java hasta el momento.

## Descripción
La clase `co.edu.ean.poo.ventas.datos.Datos` tiene dos métodos que devuelven un String. 
- El método `getDatosVendedores` devuelve un String con los datos de los vendedores de la compañía. La información de cada vendedor está separada por un salto de línea `\n` y cada línea contiene los campos separados por coma `,`. Los campos son: Numero de vendedor, Nombre, Apellido y fecha de ingreso en formato `yyyy-MM-dd`.
- El método `getDatosVentas` devuelve un String con los datos de las ventas realizadas por los vendedores de la compañía. La información de cada venta está separada por un salto de línea `\n` y cada línea contiene los campos separados por coma `,`. Los campos son: Numero de vendedor, fecha de la venta en formato `yyyy-MM-dd` y Valor de la venta. 
Es posible que exista más de un registro para una fecha dada.

## Requerimientos
1. Crear una Clase que permita gestionar listas de objetos. Agregar y remover objetos, obtener el tamaño actual de la lista, obtener
   el i-ésimo elemento de la lista. Opcionalmente implementar la interfaz `java.util.Iterable` para sacar provecho de la instrucciòn 
   `for each` de Java para recorrer listas de elementos.
2. Crear las de clases necesarias para representar a los vendedores de la compañía y sus ventas.
3. Utilizar los métodos `Datos.getDatosVendedores` y `Datos.getDatosVentas` para cargar la información de los vendedores y sus ventas en la estructura definida.
4. Algunos registros de ventas presentan inconsistencias: Aparecen ventas con fecha anterior a la fecha de ingreso del vendedor. Se debe implementar un método que permita descartar las ventas que presenten esta inconsistencia.
5. Se debe implementar un método que permita calcular el valor total de las ventas realizadas por un vendedor en un rango de fechas dado.
6. Se debe implementar un método que permita calcular el valor de las comisiones a pagar a un vendedor en un rango de fechas dado. Las comisiones se calculan asi:
    - Si el vendedor lleva menos de 6 meses en la compañía, la comisión es del 2% del valor de sus ventas.
    - Si el vendedor lleva entre 6 y 12 meses en la compañía, la comisión es del 2.5% del valor de sus ventas.
    - Si el vendedor lleva más de 12 meses en la compañía, la comisión es del 3% del valor de las ventas.
    - En todos los casos, si la venta fue realizada en un día festivo, la comisión se incrementa en un 0.5% adicional.
7. Se debe implementar un método que permita calcular el valor total de las ventas realizadas por todos los vendedores en un rango de fechas dado.
8. Se debe implementar un método que permita calcular el valor total de las comisiones a pagar a todos los vendedores en un rango de fechas dado.
9. Se debe implementar un método que muestre el top 5 de los vendedores con mayor valor de ventas en un rango de fechas dado.