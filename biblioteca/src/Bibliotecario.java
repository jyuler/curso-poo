public class Bibliotecario {
    String nombre;
    Biblioteca bbl;

    void verificarPrestamosVencidos(){}
    
    void prestarLibro(Libro libro, Socio socio) {
        if ( libro.actualmentePrestado ) {
            System.out.println("Lo siento, este libro ya esta prestado");
            return;
        }
        Prestamo prs = new Prestamo();
        prs.lbr = libro;
        prs.socio = socio;
        prs.fecha = "2025-02-06";
        prs.diasPrestamo = bbl.numeroDiasPrestamo(socio);

        System.out.println("Se acaba de prestar el libro " + libro.titulo + " a " + socio.nombre + " durante " + prs.diasPrestamo + " dias");
    }


    void llamarSocio(Socio socio){}
}
