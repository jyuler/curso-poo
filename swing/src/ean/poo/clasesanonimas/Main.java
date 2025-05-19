package ean.poo.clasesanonimas;

import java.io.File;

public interface Main {
    public  static final int contador = 5;
    public static void main(String[] args) {
        File f = new File("notas.pdf");
        ProcesadorDocumento ppdf = new ProcesadorDocumento() {

            @Override
            public void procesar() {
                System.out.println("procesando documento " + f);
            }
            
        };
        procesarArchivo(ppdf);
    }

    private static void procesarArchivo( ProcesadorDocumento pd ) {
        System.out.println("haciendo un monton de cosas antes de procesar el archivo");
        pd.procesar();
        System.out.println("Termine de procesar el archivo pero ahora tengo que hacer otro monton de cosas");
    }
}
