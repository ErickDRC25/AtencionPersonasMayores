package com.example.grupod_atencionpersonasmayoressise.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupod_atencionpersonasmayoressise.Dto.AtencionDto;
import com.example.grupod_atencionpersonasmayoressise.iservices.IAtencionService;
import com.example.grupod_atencionpersonasmayoressise.model.Atencion;

@RestController
@RequestMapping("back/atencion")
public class ApiAtencion {
    @Autowired
    private IAtencionService atencionService;

    @GetMapping("/paginado")
    public Page<AtencionDto> paginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(value = "search", required = false) String search) {
        return atencionService.paginado(search, PageRequest.of(page, size));
    }

    @GetMapping("/obtener")
    public Atencion obtenerAtencionPorId(@RequestParam Long id) {
        return atencionService.obtenerPorId(id);
    }
}
