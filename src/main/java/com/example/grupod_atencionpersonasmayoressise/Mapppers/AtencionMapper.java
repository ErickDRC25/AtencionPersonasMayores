package com.example.grupod_atencionpersonasmayoressise.Mapppers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.grupod_atencionpersonasmayoressise.Dto.AtencionDto;
import com.example.grupod_atencionpersonasmayoressise.model.Atencion;

public class AtencionMapper {

    public static AtencionDto toDto(Atencion atencion) {
        if (atencion == null) {
            return null;
        }

        String nombrePaciente = atencion.getPaciente().getNombre() + " " + atencion.getPaciente().getApellido();
        String nombreEmpleado = atencion.getEmpleado().getNombre() + " " + atencion.getEmpleado().getApellido();

        return new AtencionDto(
                atencion.getId_atencion(),
                nombrePaciente,
                nombreEmpleado,
                atencion.getFecha(),
                atencion.getDiagnostico(),
                atencion.getTratamiento(),
                atencion.getObservaciones());
    }

    public static List<AtencionDto> toDtoList(List<Atencion> atenciones) {
        return atenciones.stream()
                .map(AtencionMapper::toDto)
                .collect(Collectors.toList());
    }
}
