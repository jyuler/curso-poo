package ean.poo.clasesanonimas;

public interface Main {
    public  static final int contador = 5;
    public static void main(String[] args) {
        ProcesadorDocumentos pd = new ProcesadorPDF();
        procesarArchivo(pd, "mitesis.pdf");

        procesarArchivo( new ProcesadorDocumentos() {
                //private int contador = 0;

                public void procesar(String nombreArchivo) {
                    pd.procesar("unPDFQuenoEsperaba");
                    System.out.println(contador + " procesando archivo word " + nombreArchivo);
                }
            },  "miTesis.docx"
        );
    }

    private static void procesarArchivo( ProcesadorDocumentos pd, String nombreArchivo ) {
        System.out.println("haciendo un monton de cosas anes de procesar el archivo");
        pd.procesar(nombreArchivo);
        System.out.println("Termine de procesar el archivo pero ahora tengo que hacer otro monton de cosas");
    }
}
