
package com.example.grupod_atencionpersonasmayoressise.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupod_atencionpersonasmayoressise.Dto.EmpleadoDto;
import com.example.grupod_atencionpersonasmayoressise.Mapppers.EmpleadoMapper;
import com.example.grupod_atencionpersonasmayoressise.iservices.IEmpleadoService;
import com.example.grupod_atencionpersonasmayoressise.model.Empleado;

@RestController
@RequestMapping("back/empleado")
public class ApiEmpleado {
    @Autowired
    IEmpleadoService iEmpleadoService;

    @GetMapping("/paginado")
    public Page<EmpleadoDto> paginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(value = "search", required = false) String search) {
        Page<Empleado> empleados = iEmpleadoService.paginado(search, PageRequest.of(page, size));
        return empleados.map(EmpleadoMapper::toDto);
    }

    @GetMapping("/obtener")
    public Empleado obtenerEmpleadoPorId(@RequestParam Long id) {
        return iEmpleadoService.obtenerPorId(id);
    }
}
