package com.example.grupod_atencionpersonasmayoressise.Mapppers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.grupod_atencionpersonasmayoressise.Dto.PacienteDto;
import com.example.grupod_atencionpersonasmayoressise.model.Paciente;

public class PacienteMapper {

    public static PacienteDto pacienteDto(Paciente paciente) {
        if (paciente == null) {
            return null;
        }
        return new PacienteDto(
                paciente.id_paciente,
                paciente.nombre + ' ' + paciente.apellido,
                paciente.dni,
                paciente.telefono,
                paciente.estado);
    }

    public static List<PacienteDto> pacienteDtos(List<Paciente> pacientes) {
        return pacientes.stream()
                .map(PacienteMapper::pacienteDto)
                .collect(Collectors.toList());
    }

}
