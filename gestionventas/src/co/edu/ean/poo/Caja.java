package co.edu.ean.poo;

public class Caja<T> {
    private T objeto;

    public void guardar(T obj) {
        objeto = obj;
    }
    public T sacar() {
        return objeto;
    }

    public static void main(String[] args) {
        Integer valor = Integer.valueOf(5);
        var caja = new Caja<Integer>();
        caja.guardar(valor);
        Integer vlr = caja.sacar();
        vlr.intValue();
    }
}

