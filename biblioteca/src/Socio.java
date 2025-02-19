public class Socio {
    String nombre;
    String fechaAfiliacion;
    Biblioteca biblioteca;


    void solicitarPrestamo( Libro libro) {
        biblioteca.bibliotecario.prestarLibro(libro, this);
    }
}
