package co.edu.universidadean.cursopoo;

import java.nio.ByteBuffer;

public class BinaryType {
    public static void main(String[] args) {
        byte datoByte = 127;
        datoByte++;
        System.out.println(datoByte);
        
        short datoShort = 32_767;
        datoShort++;
        System.out.println( datoShort );

        int datoInt = 2_147__483_647;
        datoInt++;
        System.out.println(datoInt);

        long datoLong =  9__223_372__036_854__775_807L;
        datoLong++;
        System.out.println( datoLong );

        System.out.println( Math.ceil(0.2) );
    }
}
