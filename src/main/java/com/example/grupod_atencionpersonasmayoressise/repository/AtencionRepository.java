package com.example.grupod_atencionpersonasmayoressise.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.grupod_atencionpersonasmayoressise.model.Atencion;

public interface AtencionRepository extends JpaRepository<Atencion, Long> {
    public Page<Atencion> findAll(Pageable pageable);

    @Query("SELECT a FROM Atencion a WHERE " +
            "LOWER(a.paciente.nombre) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(a.paciente.apellido) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(a.empleado.nombre) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(a.diagnostico) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Atencion> paginado(@Param("search") String search, Pageable pageable);
}
