package com.example.grupod_atencionpersonasmayoressise.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.grupod_atencionpersonasmayoressise.iservices.IRolService;

import com.example.grupod_atencionpersonasmayoressise.model.Rol;

@Controller
@RequestMapping("rol")
public class RolController {

     @Autowired
    IRolService irolService;
     @RequestMapping("/paginado")
    public String listarRolesPage() {
        return "Rol/listar_roles"; 
    }

@GetMapping("/agregar")
public String mostrarFormularioAgregar(Model model, @RequestParam(required = false) String error) {
    model.addAttribute("rol", new Rol()); 
    if (error != null) {
        model.addAttribute("error", error); 
    }
    return "Rol/guardar_roles"; 
}


@RequestMapping(value = "/agregar", method = RequestMethod.POST)
public String guardarRol(Rol rol) {
    if (rol.getNombre() == null || rol.getNombre().trim().isEmpty()) {
        return "redirect:/rol/agregar?error=ElNombreEsObligatorio";
    }
    irolService.guardar(rol);
    return "redirect:/rol/paginado"; 
}


     @GetMapping("/obtener")
    public String obtenerRol(@RequestParam Long id, Model model) {
        Rol rol = irolService.obtenerPorId(id);
        if (rol == null) return "redirect:/rol/paginado";
        model.addAttribute("rol", rol);
        return "Rol/ver_rol"; 
    }
    
    @GetMapping("/editar")
    public String editar(@RequestParam Long id, Model model) {
        Rol rol = irolService.obtenerPorId(id);
        if (rol == null) {
            return "redirect:/rol/paginado";
        }
        model.addAttribute("rol", rol);
        return "Rol/editar_roles";
    }
     @PostMapping("/actualizar")
    public String actualizarRol(Rol rol, Model model) {
        if (rol.getNombre() == null || rol.getNombre().trim().isEmpty()) {
            model.addAttribute("error", "El nombre del rol es obligatorio");
            model.addAttribute("rol", rol);
            return "Rol/editar_roles";
        }
        irolService.actualizar(rol); 
        return "redirect:/rol/paginado";
    }
}

