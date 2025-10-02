package com.example.grupod_atencionpersonasmayoressise.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupod_atencionpersonasmayoressise.Dto.PacienteDto;
import com.example.grupod_atencionpersonasmayoressise.Mapppers.PacienteMapper;
import com.example.grupod_atencionpersonasmayoressise.iservices.IPacienteService;
import com.example.grupod_atencionpersonasmayoressise.model.Paciente;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("back/paciente")

public class ApiPaciente {

    @Autowired
    IPacienteService iPacienteService;

    @GetMapping("/listarDto")
    public List<PacienteDto> listarPacientesDto() {
        return iPacienteService.listarPacienteDtos();
    }

    @GetMapping("/listar")
    public List<Paciente> listarPaciente() {
        return iPacienteService.listar();
    }

    @GetMapping("/obtener")
    public Paciente obtenerPaciente(@RequestParam Long id) {
        return iPacienteService.obtenerPorId(id);
    }

    @GetMapping("/paginado")
    public Page<PacienteDto> paginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(value = "search", required = false) String search) {
        Page<Paciente> paciente = iPacienteService.paginado(search, PageRequest.of(page, size));
        return paciente.map(PacienteMapper::pacienteDto);
    }

}
