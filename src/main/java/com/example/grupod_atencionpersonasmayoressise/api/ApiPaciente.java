package com.example.grupod_atencionpersonasmayoressise.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupod_atencionpersonasmayoressise.Dto.PacienteDto;
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

    @GetMapping("/obtener")
    public Paciente obtenerPaciente(@RequestParam Long id) {
        return iPacienteService.obtenerPorId(id);
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<PacienteDto>> getPacientes(
            @RequestParam(required = false) String search,
            Pageable pageable) {

        Page<PacienteDto> pacientesDto = iPacienteService.paginado(search, pageable);

        return ResponseEntity.ok(pacientesDto);
    }
}
