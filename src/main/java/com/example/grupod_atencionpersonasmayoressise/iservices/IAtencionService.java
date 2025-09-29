package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import com.example.grupod_atencionpersonasmayoressise.model.Atencion;

public interface IAtencionService {
    List<Atencion> listar();

    Atencion guardar(Atencion atencion);

    Atencion obtenerPorId(Long id);

    Atencion actualizar(Atencion atencion);
}
