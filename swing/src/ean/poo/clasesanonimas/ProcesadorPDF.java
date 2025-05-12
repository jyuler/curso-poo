package ean.poo.clasesanonimas;

public class ProcesadorPDF implements ProcesadorDocumentos{

    @Override
    public void procesar(String na) {
       System.out.println("Procesando el PDF con nombre " + na);
    }
}
