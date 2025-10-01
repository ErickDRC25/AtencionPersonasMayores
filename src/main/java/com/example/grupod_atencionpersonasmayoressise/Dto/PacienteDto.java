package com.example.grupod_atencionpersonasmayoressise.Dto;

public class PacienteDto {
    public Long id;
    public String nombreCompleto;
    public String dni;
    public String telefono;
    // public String alergias;
    // public String enfermedades_cronicas;
    public int estado;

    public PacienteDto(Long id, String nombreCompleto, String dni, String telefono, int estado) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}