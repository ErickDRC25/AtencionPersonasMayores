package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import com.example.grupod_atencionpersonasmayoressise.model.Actividad;

public interface IActividadService {
    List<Actividad> listar();

    Actividad guardar(Actividad actividad);

    Actividad obtenerPorId(Long id);

    Actividad actualizar(Actividad actividad);

    Actividad eliminarLogico(Long id);
}
