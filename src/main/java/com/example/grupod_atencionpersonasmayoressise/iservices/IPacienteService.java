package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import com.example.grupod_atencionpersonasmayoressise.model.Paciente;

public interface IPacienteService {
    List<Paciente> listar();

    Paciente guardar(Paciente paciente);

    Paciente obtenerPorId(Long id);

    Paciente actualizar(Paciente paciente);

    Paciente eliminarLogico(Long id); 

}
