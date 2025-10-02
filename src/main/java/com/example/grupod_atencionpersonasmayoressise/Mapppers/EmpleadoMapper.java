package com.example.grupod_atencionpersonasmayoressise.Mapppers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.grupod_atencionpersonasmayoressise.Dto.EmpleadoDto;
import com.example.grupod_atencionpersonasmayoressise.model.Empleado;

public class EmpleadoMapper {
    public static EmpleadoDto toDto(Empleado empleado) {
        if (empleado == null) {
            return null;
        }

        String nombreCompleto = empleado.getNombre() + " " + empleado.getApellido();
        String rolNombre = (empleado.getRol() != null) ? empleado.getRol().getNombre() : "Sin rol";
        String estadoTexto = (empleado.getEstado() == 1) ? "Activo" : "Inactivo";

        return new EmpleadoDto(
                empleado.getId_empleado(),
                nombreCompleto,
                empleado.getTelefono(),
                empleado.getEmail(),
                rolNombre,
                estadoTexto);
    }

    public static List<EmpleadoDto> toDtoList(List<Empleado> empleados) {
        return empleados.stream()
                .map(EmpleadoMapper::toDto)
                .collect(Collectors.toList());

    }
}
