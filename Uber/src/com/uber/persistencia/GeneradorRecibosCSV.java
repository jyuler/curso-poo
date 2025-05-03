package com.uber.persistencia;

import com.uber.modelo.Transporte;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeneradorRecibosCSV {
    private final String rutaArchivo;

    public GeneradorRecibosCSV(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        crearDirectorioSiNoExiste();
    }

    private void crearDirectorioSiNoExiste() {
        File archivo = new File(rutaArchivo);
        File directorio = archivo.getParentFile();
        if (directorio != null && !directorio.exists()) {
            directorio.mkdirs();
        }
    }

    public void generarRecibo(Transporte viaje) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo, true))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = LocalDateTime.now().format(formatter);
            writer.printf("%s,%s,%.2f,%d,%.2f\n",
                    timestamp,
                    viaje.getLocalidad(),
                    viaje.getValor(),
                    viaje.getHora(),
                    viaje.getDuracion());
        } catch (IOException e) {
            System.out.println("Error al generar el recibo: " + e.getMessage());
        }
    }
}

    

