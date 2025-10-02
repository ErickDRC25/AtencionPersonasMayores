package com.example.grupod_atencionpersonasmayoressise.Controllers;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.grupod_atencionpersonasmayoressise.iservices.ICitaService;
import com.example.grupod_atencionpersonasmayoressise.iservices.IEmpleadoService;
import com.example.grupod_atencionpersonasmayoressise.iservices.IPacienteService;
import com.example.grupod_atencionpersonasmayoressise.model.Cita;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("citas")
public class CitaController {
    @Autowired
    ICitaService iCitaService;

    @Autowired
    IEmpleadoService iEmpleadoService;

    @Autowired
    IPacienteService iPacienteService;

    @GetMapping("/listar")
    public String listarCitas() {
        return "Cita/listar_citas";
    }

    @GetMapping("/ver")
    public String verCita(@RequestParam Long id, Model model) {
        Cita cita = iCitaService.obtenerPorId(id);
        model.addAttribute("cita", cita);
        return "Cita/ver_mas_cita";
    }

    @GetMapping("/nuevo")
    public String nuevaCita(Cita cita, Model model) {
        model.addAttribute("cita", cita);
        model.addAttribute("empleado", iEmpleadoService.listar());
        model.addAttribute("paciente", iPacienteService.listar());
        return "Cita/guardar";
    }

    @PostMapping("/guardar")
    public String guardarCita(Cita cita) {

        iCitaService.guardar(cita);

        return "redirect:/citas/listar";
    }

    @GetMapping("/actualizar")
    public String actualizarCita(@RequestParam Long id, Model model) {

        Cita cita = iCitaService.obtenerPorId(id);
        DateTimeFormatter fechaformat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String fechaHoraInput = cita.getFecha().format(fechaformat);

        model.addAttribute("cita", cita);
        model.addAttribute("empleados", iEmpleadoService.listar());
        model.addAttribute("pacientes", iPacienteService.listar());
        model.addAttribute("fechaHoraInput", fechaHoraInput);

        return "Cita/actualizar";
    }
}
