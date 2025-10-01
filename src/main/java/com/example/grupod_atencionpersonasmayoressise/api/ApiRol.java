package com.example.grupod_atencionpersonasmayoressise.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupod_atencionpersonasmayoressise.model.Rol;
import com.example.grupod_atencionpersonasmayoressise.services.RolService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("back/rol")
public class ApiRol {
    @Autowired
    RolService rolService;


    @GetMapping("/listarRol")
    public List<Rol>listar() {
        return  rolService.listar();
    }

    @GetMapping("/obtenerRol")
    public Rol obtenerPorId(@PathVariable Long id) {
        return rolService.obtenerPorId(id);
    }
    
    
}
