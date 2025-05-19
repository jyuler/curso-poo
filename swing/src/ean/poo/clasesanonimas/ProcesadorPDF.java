package ean.poo.clasesanonimas;

import java.io.File;

public class ProcesadorPDF implements ProcesadorDocumento{
    private File f;

    public ProcesadorPDF( File archivo ) {
        f = archivo;
    }

    @Override
    public void procesar() {
        System.out.println("Procesando documento " + f);
    }
    
}
