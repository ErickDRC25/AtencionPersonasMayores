package com.example.grupod_atencionpersonasmayoressise.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.grupod_atencionpersonasmayoressise.iservices.ICitaService;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("cita")
public class CitaController {
    @Autowired
    ICitaService iCitaService;

    @GetMapping("/listar")
    public String listarCitas() {
        return "Cita/listar_citas";
    }
    
}
