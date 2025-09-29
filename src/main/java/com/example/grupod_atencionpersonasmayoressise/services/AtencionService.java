package com.example.grupod_atencionpersonasmayoressise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grupod_atencionpersonasmayoressise.iservices.IAtencionService;
import com.example.grupod_atencionpersonasmayoressise.model.Atencion;
import com.example.grupod_atencionpersonasmayoressise.repository.AtencionRepository;
@Service
public class AtencionService implements IAtencionService{
    @Autowired
    AtencionRepository atencionRepository;

    @Override
    public List<Atencion> listar() {
        return atencionRepository.findAll();
    }

    @Override
    public Atencion guardar(Atencion atencion) {
       return atencionRepository.save(atencion);
    }

    @Override
    public Atencion obtenerPorId(Long id) {
        return atencionRepository.findById(id).orElse(null);
    }

    @Override
    public Atencion actualizar(Atencion atencion) {
        return atencionRepository.save(atencion);
    }
    
}
