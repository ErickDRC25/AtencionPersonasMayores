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
@Table(name = "familiares")
public class Familiar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_familiar;
    public String nombre;
    public String apellido;
    public String telefono;
    public String email;
    public String parentesco;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    public Paciente paciente;
    public int estado;
}
