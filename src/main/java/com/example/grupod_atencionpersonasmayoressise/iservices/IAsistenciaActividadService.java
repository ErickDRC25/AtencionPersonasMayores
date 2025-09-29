package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import com.example.grupod_atencionpersonasmayoressise.model.AsistenciaActividad;

public interface IAsistenciaActividadService {
    List<AsistenciaActividad> listar();

    AsistenciaActividad guardar(AsistenciaActividad asistencia);

    AsistenciaActividad obtenerPorId(Long id);

    AsistenciaActividad actualizar(AsistenciaActividad asistencia);
}
