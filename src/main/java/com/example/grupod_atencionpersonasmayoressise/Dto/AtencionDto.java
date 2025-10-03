package com.example.grupod_atencionpersonasmayoressise.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AtencionDto {
    public Long id_atencion;
    public String nombrePaciente;
    public String nombreEmpleado;
    public LocalDateTime fecha;
    public String diagnostico;
    public String tratamiento;
    public String observaciones;
}