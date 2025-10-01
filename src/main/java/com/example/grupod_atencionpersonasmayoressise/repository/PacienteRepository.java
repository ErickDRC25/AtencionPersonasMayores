package com.example.grupod_atencionpersonasmayoressise.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.grupod_atencionpersonasmayoressise.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long>{

    public Page<Paciente> findAll(Pageable pageable);

    @Query(value = "SELECT p FROM Paciente p WHERE LOWER(p.dni) like LOWER(CONCAT('%', :search, '%'))")
    public Page<Paciente> paginado(@Param(value = "search") String search, Pageable pageable);



    
}
