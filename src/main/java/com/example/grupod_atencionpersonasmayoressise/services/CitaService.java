package com.example.grupod_atencionpersonasmayoressise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.grupod_atencionpersonasmayoressise.iservices.ICitaService;
import com.example.grupod_atencionpersonasmayoressise.model.Cita;
import com.example.grupod_atencionpersonasmayoressise.repository.CitaRepository;

@Service
public class CitaService implements ICitaService {

    @Autowired
    CitaRepository citaRepository;

    @Override
    public List<Cita> listar() {
        return citaRepository.findAll();
    }

    @Override
    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Cita obtenerPorId(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public Cita actualizar(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Page<Cita> paginado(Long search, Pageable pageable) {
        if (search == null) {
            return citaRepository.findAll(pageable);
        }
        return citaRepository.paginado(search, pageable);
    }
}
