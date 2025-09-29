package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import com.example.grupod_atencionpersonasmayoressise.model.Medicamento;

public interface IMedicamentoService {
    List<Medicamento> listar();

    Medicamento guardar(Medicamento medicamento);

    Medicamento obtenerPorId(Long id);

    Medicamento actualizar(Medicamento medicamento);

    Medicamento eliminarLogico(Long id);
}
