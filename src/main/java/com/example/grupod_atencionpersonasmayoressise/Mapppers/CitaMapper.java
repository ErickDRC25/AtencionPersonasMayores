package com.example.grupod_atencionpersonasmayoressise.Mapppers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.grupod_atencionpersonasmayoressise.Dto.CitaDTO;
import com.example.grupod_atencionpersonasmayoressise.model.Cita;

public class CitaMapper {
    public static CitaDTO toDto(Cita cita){
        if(cita==null){
            return null;
        }

        String nombrePaciente=cita.getPaciente().getNombre()+" "+cita.getPaciente().getApellido();
        String nombreEmpleado=cita.getEmpleado().getNombre()+" "+cita.getPaciente().getApellido();
        String estadoTexto = (cita.getEstado() == 1) ? "Activo" : "Inactivo";

        return new CitaDTO(
            cita.getId_cita(),
            nombrePaciente,
            nombreEmpleado,
            cita.motivo,
            cita.fecha,
            estadoTexto);

    }


    public static List<CitaDTO> toDtoList(List<Cita> citas){
        return citas.stream().map(CitaMapper::toDto)
                .collect(Collectors.toList());
    }
}
