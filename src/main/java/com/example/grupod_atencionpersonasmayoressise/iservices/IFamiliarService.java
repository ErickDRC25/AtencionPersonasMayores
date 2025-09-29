package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import com.example.grupod_atencionpersonasmayoressise.model.Familiar;

public interface IFamiliarService {
    List<Familiar> listar();

    Familiar guardar(Familiar familiar);

    Familiar obtenerPorId(Long id);

    Familiar actualizar(Familiar familiar);
    
    Familiar eliminarLogico(Long id);
}
