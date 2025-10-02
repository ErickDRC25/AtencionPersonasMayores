package com.example.grupod_atencionpersonasmayoressise.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "atenciones")
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_atencion;
    public LocalDateTime fecha;
    public String diagnostico;
    public String tratamiento;
    public String observaciones;


    @ManyToOne
    @JoinColumn(name="id_paciente")
    public Paciente paciente;

    @ManyToOne
    @JoinColumn (name = "id_empleado")
    public Empleado empleado;


}
