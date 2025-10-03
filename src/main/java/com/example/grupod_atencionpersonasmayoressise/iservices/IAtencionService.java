package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.grupod_atencionpersonasmayoressise.Dto.AtencionDto;
import com.example.grupod_atencionpersonasmayoressise.model.Atencion;

public interface IAtencionService {
    List<Atencion> listar();

    Atencion guardar(Atencion atencion);

    Atencion obtenerPorId(Long id);

    Atencion actualizar(Atencion atencion);
    
    Page<AtencionDto> paginado(String search, Pageable pageable);
}
