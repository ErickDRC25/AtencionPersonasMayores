package com.example.grupod_atencionpersonasmayoressise.model;

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
@Table(name = "asistencia_actividades")
public class AsistenciaActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_asistencia;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    public Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_actividad")
    public Actividad actividad;

    public int asistencia;
}
