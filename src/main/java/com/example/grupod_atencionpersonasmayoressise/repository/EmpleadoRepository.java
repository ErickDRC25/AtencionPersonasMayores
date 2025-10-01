package com.example.grupod_atencionpersonasmayoressise.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.grupod_atencionpersonasmayoressise.model.Empleado;

public interface EmpleadoRepository  extends JpaRepository<Empleado,Long>{
     public Page<Empleado> findAll(Pageable pageable);

    @Query(value = "SELECT e From Empleado e where LOWER(e.nombre) like LOWER(CONCAT('%',:search,'%'))")
    public Page<Empleado> paginado(@Param(value = "search") String search, Pageable pageable);
}
