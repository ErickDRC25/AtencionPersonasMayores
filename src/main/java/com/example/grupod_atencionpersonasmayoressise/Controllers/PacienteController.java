package com.example.grupod_atencionpersonasmayoressise.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.grupod_atencionpersonasmayoressise.iservices.IPacienteService;
import com.example.grupod_atencionpersonasmayoressise.model.Paciente;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    IPacienteService iPacienteService;

    @GetMapping("/listar")
    public String listarPacientes() {
        return "Paciente/listar_paciente";
    }

    @GetMapping("/obtener")
    public String obtenerPaciente(@RequestParam Long id, Model model) {
        model.addAttribute("paciente", iPacienteService.obtenerPorId(id));
        return "Paciente/ver_paciente";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam Long id, Model model) {
        model.addAttribute("paciente", iPacienteService.obtenerPorId(id));
        return "Paciente/editar_paciente";
    }

    @RequestMapping ("/agregar")
    public String guardarPaciente(Paciente paciente) {
        iPacienteService.guardar(paciente);
        return "Paciente/guardar_paciente";
    }

}
