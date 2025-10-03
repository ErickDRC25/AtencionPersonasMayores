package com.example.grupod_atencionpersonasmayoressise.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpleadoDto {
    public Long idEmpleado;
    public String nombreEmpleado;
    public String telefono;
    public String email;
    public String rol;
    public int estado;
}
