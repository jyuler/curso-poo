package com.uber.persistencia;

import com.uber.excepciones.DatoInvalidoException;
import com.uber.modelo.Viaje;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar la escritura y lectura de archivos CSV relacionados con los viajes.
 */
public class GestorArchivoCSV {

    private final String rutaArchivo;

    public GestorArchivoCSV(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * Escribe una lista de viajes en un archivo CSV.
     */
    public void escribirViajes(List<Viaje> viajes) throws DatoInvalidoException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Viaje viaje : viajes) {
                String linea = viaje.getLocalidad() + "," +
                               viaje.getValor() + "," +
                               viaje.getHora() + "," +
                               viaje.getDuracion();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new DatoInvalidoException("Error al escribir el archivo: " + rutaArchivo, e);
        }
    }

    /**
     * Lee un archivo CSV y devuelve una lista de viajes.
     */
    public List<Viaje> leerViajes() throws DatoInvalidoException {
        List<Viaje> viajes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length != 4) {
                    throw new DatoInvalidoException("Formato inválido en línea: " + linea);
                }

                String localidad = partes[0];
                double valor = Double.parseDouble(partes[1]);
                int hora = Integer.parseInt(partes[2]);
                double duracion = Double.parseDouble(partes[3]);

                viajes.add(new Viaje(localidad, valor, hora, duracion));
            }
        } catch (FileNotFoundException e) {
            throw new DatoInvalidoException("Archivo no encontrado: " + rutaArchivo, e);
        } catch (IOException | NumberFormatException e) {
            throw new DatoInvalidoException("Error al leer el archivo: " + rutaArchivo, e);
        }

        return viajes;
    }
}
