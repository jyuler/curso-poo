package com.uber.persistencia;

import com.uber.modelo.Transporte;

import java.util.List;

public interface IPersistencia {

    // Método para guardar una lista de objetos Transporte en el archivo
    void guardarDatos(List<Transporte> viajes) throws Exception;

    // Método para cargar los objetos Transporte desde el archivo
    List<Transporte> cargarDatos() throws Exception;
}
