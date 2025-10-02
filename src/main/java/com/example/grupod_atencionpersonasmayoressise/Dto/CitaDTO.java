package com.example.grupod_atencionpersonasmayoressise.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CitaDTO {
    private Long id_cita;
    private String nombrePaciente;
    private String nombreEmpleado;
    private String motivo;
    private LocalDateTime fecha;
    private String estado;
}
