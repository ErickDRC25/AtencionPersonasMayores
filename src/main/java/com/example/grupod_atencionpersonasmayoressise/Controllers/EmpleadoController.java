package com.example.grupod_atencionpersonasmayoressise.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.grupod_atencionpersonasmayoressise.iservices.IEmpleadoService;

@Controller
@RequestMapping("empleado")
public class EmpleadoController {
    @Autowired
    IEmpleadoService iEmpleadoService;

    @GetMapping("/listar")
    public String listarPacientes() {
        return "Empleado/listar_empleados";
    }
}
