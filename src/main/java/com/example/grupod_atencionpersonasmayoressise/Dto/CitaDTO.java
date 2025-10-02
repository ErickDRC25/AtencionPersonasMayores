package com.example.grupod_atencionpersonasmayoressise.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CitaDTO {
    public Long id_cita;
    public Long idPaciente;
    public Long idEmpleado;
    public String nombrePaciente;
    public String nombreEmpleado;
    public String motivo;
    public LocalDateTime fecha;
    public String estado;
}
