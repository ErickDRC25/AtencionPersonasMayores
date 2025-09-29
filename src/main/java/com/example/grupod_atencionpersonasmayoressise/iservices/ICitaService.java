package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import com.example.grupod_atencionpersonasmayoressise.model.Cita;

public interface ICitaService {
    List<Cita> listar();

    Cita guardar(Cita cita);

    Cita obtenerPorId(Long id);

    Cita actualizar(Cita cita);
}
