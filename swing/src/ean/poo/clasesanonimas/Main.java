package ean.poo.clasesanonimas;

public interface Main {
    public  static final int contador = 5;
    public static void main(String[] args) {
        
    }

    private static void procesarArchivo( ProcesadorDocumentos pd ) {
        System.out.println("haciendo un monton de cosas antes de procesar el archivo");
        pd.procesar();
        System.out.println("Termine de procesar el archivo pero ahora tengo que hacer otro monton de cosas");
    }
}
