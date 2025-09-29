package com.example.grupod_atencionpersonasmayoressise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grupod_atencionpersonasmayoressise.model.Empleado;

public interface EmpleadoRepository  extends JpaRepository<Empleado,Long>{
    
}
