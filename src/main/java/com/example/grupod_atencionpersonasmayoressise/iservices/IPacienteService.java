package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.grupod_atencionpersonasmayoressise.Dto.PacienteDto;
import com.example.grupod_atencionpersonasmayoressise.model.Paciente;

public interface IPacienteService {
    List<Paciente> listar();

    Paciente guardar(Paciente paciente);

    Paciente obtenerPorId(Long id);

    Paciente actualizar(Paciente paciente);

    Paciente eliminarLogico(Long id); 

    public List<PacienteDto> listarPacienteDtos();

    public Page<Paciente> paginado(String search, Pageable pageable);



}
