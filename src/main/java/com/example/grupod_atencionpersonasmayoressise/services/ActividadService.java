package com.example.grupod_atencionpersonasmayoressise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grupod_atencionpersonasmayoressise.iservices.IActividadService;
import com.example.grupod_atencionpersonasmayoressise.model.Actividad;
import com.example.grupod_atencionpersonasmayoressise.repository.ActividadRepository;

@Service
public class ActividadService implements IActividadService {
    @Autowired
    ActividadRepository actividadRepository;

    @Override
    public List<Actividad> listar() {
        return actividadRepository.findAll();
    }

    @Override
    public Actividad guardar(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    @Override
    public Actividad obtenerPorId(Long id) {
        return actividadRepository.findById(id).orElse(null);
    }

    @Override
    public Actividad actualizar(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    @Override
    public Actividad eliminarLogico(Long id) {
        Actividad actividad = actividadRepository.findById(id).orElse(null);
        if (actividad != null) {
            actividad.setEstado(0);
            return actividadRepository.save(actividad);
        }
        return null;
    }
}
