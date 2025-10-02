package com.example.grupod_atencionpersonasmayoressise.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_paciente;
    public String nombre;
    public String apellido;
    public String dni;
    public Date fecha_nacimiento;
    public String direccion;
    public String telefono;
    public String alergias;
    public String enfermedades_cronicas;
    public int estado;

}
