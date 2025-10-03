package com.example.grupod_atencionpersonasmayoressise.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupod_atencionpersonasmayoressise.Dto.CitaDTO;
import com.example.grupod_atencionpersonasmayoressise.Mapppers.CitaMapper;
import com.example.grupod_atencionpersonasmayoressise.iservices.ICitaService;
import com.example.grupod_atencionpersonasmayoressise.model.Cita;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("back/cita")
public class ApiCita {
    @Autowired
    ICitaService icitaService;

    @GetMapping("/paginado")
    public Page<CitaDTO> paginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(value = "search", required = false) Long search) {

        Page<Cita> citas = icitaService.paginado(search, PageRequest.of(page, size));
        return citas.map(CitaMapper::toDto);
    }

    @GetMapping("/obtener")
    public Cita obtenerEmpleadoPorId(@RequestParam Long id) {
        return icitaService.obtenerPorId(id);
    }
}
