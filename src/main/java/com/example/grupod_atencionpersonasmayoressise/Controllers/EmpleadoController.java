package com.example.grupod_atencionpersonasmayoressise.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.grupod_atencionpersonasmayoressise.iservices.IEmpleadoService;
import com.example.grupod_atencionpersonasmayoressise.iservices.IRolService;
import com.example.grupod_atencionpersonasmayoressise.model.Empleado;

@Controller
@RequestMapping("empleado")
public class EmpleadoController {
    @Autowired
    IEmpleadoService iEmpleadoService;

    @Autowired
    IRolService iRolService;

    @GetMapping("/listar")
    public String listarPacientes() {
        return "Empleado/listar_empleados";
    }

    @GetMapping("/ver")
    public String verEmpleado(@RequestParam Long id, Model model) {
        Empleado empleado = iEmpleadoService.obtenerPorId(id);
        model.addAttribute("empleado", empleado);
        return "empleado/ver_mas_empleado";
    }

    @GetMapping("/actualizar/{id}")
    public String formularioActualizar(@PathVariable("id") Long id, Model model) {
        Empleado empleado = iEmpleadoService.obtenerPorId(id);
        model.addAttribute("empleado", empleado);
        model.addAttribute("roles", iRolService.listar());
        return "empleado/actualizar";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(Empleado empleado, Model model) {
        model.addAttribute("empleado", empleado);
        iEmpleadoService.guardar(empleado);
        return "redirect:/empleado/listar";
    }

    @GetMapping("/nuevo")
    public String nuevoEmpleado(Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("roles", iRolService.listar());
        return "empleado/guardar";
    }

}
