
public class App {
    public static void main(String[] args) throws Exception {
        Biblioteca bbl = new Biblioteca();
        bbl.iniciarBiblioteca();
        bbl.socio.solicitarPrestamo(bbl.lbr);
        bbl.socio.solicitarPrestamo(bbl.lbr);
    }
}
