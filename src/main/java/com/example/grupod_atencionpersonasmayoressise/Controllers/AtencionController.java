package com.example.grupod_atencionpersonasmayoressise.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.grupod_atencionpersonasmayoressise.iservices.IAtencionService;
import com.example.grupod_atencionpersonasmayoressise.iservices.IEmpleadoService;
import com.example.grupod_atencionpersonasmayoressise.iservices.IPacienteService;
import com.example.grupod_atencionpersonasmayoressise.model.Atencion;

@Controller
@RequestMapping("atenciones")
public class AtencionController {

    @Autowired
    private IAtencionService atencionService;

    @Autowired
    private IEmpleadoService empleadoService;

    @Autowired
    private IPacienteService pacienteService;

    @GetMapping("/listar")
    public String listarAtenciones() {
        return "Atencion/listar_atenciones";
    }

    @GetMapping("/ver")
    public String verAtencion(@RequestParam Long id, Model model) {
        Atencion atencion = atencionService.obtenerPorId(id);
        model.addAttribute("atencion", atencion);
        return "Atencion/ver_atencion";
    }

    @GetMapping("/nuevo")
    public String nuevaAtencion(Model model) {
        model.addAttribute("atencion", new Atencion());
        model.addAttribute("empleados", empleadoService.listar());
        model.addAttribute("pacientes", pacienteService.listar());
        return "Atencion/guardar_atencion";
    }

    @PostMapping("/guardar")
    public String guardarAtencion(Atencion atencion) {
        if (atencion.getId_atencion() != null) {
            atencionService.actualizar(atencion);
        } else {
            atencionService.guardar(atencion);
        }
        return "redirect:/atenciones/listar";
    }

    @GetMapping("/editar")
    public String editarAtencion(@RequestParam Long id, Model model) {
        Atencion atencion = atencionService.obtenerPorId(id);
        model.addAttribute("atencion", atencion);
        model.addAttribute("empleados", empleadoService.listar());
        model.addAttribute("pacientes", pacienteService.listar());
        return "Atencion/editar_atencion";
    }
}
