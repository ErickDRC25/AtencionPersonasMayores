package com.example.grupod_atencionpersonasmayoressise.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupod_atencionpersonasmayoressise.iservices.IRolService;
import com.example.grupod_atencionpersonasmayoressise.model.Rol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("back/rol")
public class ApiRol {
    @Autowired
    IRolService iRolService;

    @GetMapping("/listarRol")
    public List<Rol> listar() {
        return iRolService.listar();
    }

    @GetMapping("/obtenerRol")
    public Rol obtenerPorId(@PathVariable Long id) {
        return iRolService.obtenerPorId(id);
    }

    @GetMapping("/paginado")
    public Page<Rol> paginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(value = "search", required = false) String search) {
        return iRolService.paginado(search, PageRequest.of(page, size));
    }
}
