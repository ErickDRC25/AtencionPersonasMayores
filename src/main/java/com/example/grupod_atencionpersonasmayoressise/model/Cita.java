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
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_cita;
    public LocalDateTime fecha;
    public String motivo;
    
    

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    public Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    public Empleado empleado;
    
    public String estado;
}
