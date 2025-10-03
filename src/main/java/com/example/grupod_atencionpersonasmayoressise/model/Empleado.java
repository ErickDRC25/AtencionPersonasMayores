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
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_empleado;
    public String nombre;
    public String apellido;
    public String telefono;
    public String email;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    public Rol rol;
    public int estado;
}
