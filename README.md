# Ejercicios del curso de Programación Orientada a Objetos

La biblioteca desea una aplicación que le ayude a gestionar los préstamos de libros a cada socio de la biblioteca.  La cantidad de libros que un socio puede pedir en préstamo de manera simultánea y las fechas de vencimiento para su devolución depende de la antigüedad de la membresía de cada socio a la biblioteca. Los bibliotecarios llevan el control de los libros en préstamos cuya fecha de devolución está a punto de vencer y realizan llamadas a los socios para recordarles que deben realizar la devolución prontamente. 


```mermaid
---
title: Gestión de préstamos de libros en una biblioteca
---
classDiagram
	class Biblioteca {
		determinarNumeroDiasPrestamo( Socio socio )
		determinarNumeroMaxLibrosPrestamo( Socio socio )
	}
	class Libro {
		String título
		String autor
		int numeroPaginas
		boolean actualmentePrestado
	}
	class Prestamo {
		LocalDate fecha
		int diasPrestamo
	}
	class Bibliotecario {
		String nombre
		verificarPrestamosVencidos()
		prestarLibro( Libro libro, Socio socio )
		llamarSocio( Socio socio )
	}
	class Socio {
		String nombre
		LocalDate fechaAfiliacion
		solicitarPrestamo( Libro libro )
	}
	Biblioteca "1" *-- "1..n" Bibliotecario
	Biblioteca "1" o-- "1..n" Libro
	Biblioteca "1" *-- "1..n" Socio
	Biblioteca "1" *-- "1..n" Prestamo
	Prestamo "1" *-- "1" Libro 
	Prestamo "1" *-- "1" Socio
	Bibliotecario --> Prestamo : gestiona
	Socio --> Libro : solicitaEnPrestamo
```

