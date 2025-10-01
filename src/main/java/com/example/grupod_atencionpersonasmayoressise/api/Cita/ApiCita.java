package com.example.grupod_atencionpersonasmayoressise.api.Cita;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupod_atencionpersonasmayoressise.model.Cita;
import com.example.grupod_atencionpersonasmayoressise.services.CitaService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("back/cita")
public class ApiCita {
    @Autowired
    CitaService citaService;

    @GetMapping("/listarCita")
    public List<Cita> listar() {
        return citaService.listar();
    }
    
}
