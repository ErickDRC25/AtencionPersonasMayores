package com.example.grupod_atencionpersonasmayoressise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grupod_atencionpersonasmayoressise.iservices.IAsistenciaActividadService;
import com.example.grupod_atencionpersonasmayoressise.model.AsistenciaActividad;
import com.example.grupod_atencionpersonasmayoressise.repository.AsistenciaActividadRepository;

@Service
public class AsistenciaActividadService implements IAsistenciaActividadService {
    @Autowired
    AsistenciaActividadRepository actividadRepository;

    @Override
    public List<AsistenciaActividad> listar() {
        return actividadRepository.findAll();
    }

    @Override
    public AsistenciaActividad guardar(AsistenciaActividad asistencia) {
        return actividadRepository.save(asistencia);
    }

    @Override
    public AsistenciaActividad obtenerPorId(Long id) {
        return actividadRepository.findById(id).orElse(null);
    }

    @Override
    public AsistenciaActividad actualizar(AsistenciaActividad asistencia) {
        return actividadRepository.save(asistencia);
    }
}
