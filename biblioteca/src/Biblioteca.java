public class Biblioteca {
    Libro lbr = null;
    Socio socio = null;
    Bibliotecario bibliotecario;
    int añoFundacion = 1978;

    void iniciarBiblioteca(){
        lbr = new Libro();
        lbr.autor = "Gabriel García Márquez";
        lbr.titulo = "Cien años de soledad";
        lbr.numeroPaginas = 800;

        socio = new Socio();
        socio.nombre = "Jhan Yuler";
        socio.fechaAfiliacion = "2024-07-25";
        socio.biblioteca = this;

        bibliotecario = new Bibliotecario();
        bibliotecario.nombre = "Fulanito";
        bibliotecario.bbl = this;
    }
    
    void mostrarLibros() {
        System.out.println("Titulo: " + lbr.titulo + " del autor " + lbr.autor + " EstadoPrestamo: " + lbr.actualmentePrestado );
    }
    
    void mostrarSocios() {
        System.out.println("Socio: " + socio.nombre + " afiliado desde " + socio.fechaAfiliacion );
    }
    
    void mostrarPrestamos(){}
    
    int numeroMaximoLibrosPrestamo(Socio socio) {
        return 1;
    }
    
    int numeroDiasPrestamo(Socio socio) {
        
        return 1;
    }
}
