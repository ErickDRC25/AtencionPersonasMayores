package com.example.grupod_atencionpersonasmayoressise.Mapppers;

import java.util.List;
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

        return new EmpleadoDto(
                empleado.getId_empleado(),
                nombreCompleto,
                empleado.getTelefono(),
                empleado.getEmail(),
                rolNombre,
                empleado.estado);
    }

    public static List<EmpleadoDto> toDtoList(List<Empleado> empleados) {
        return empleados.stream()
                .map(EmpleadoMapper::toDto)
                .collect(Collectors.toList());

    }
}
