package com.example.grupod_atencionpersonasmayoressise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grupod_atencionpersonasmayoressise.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long>{
    
}
