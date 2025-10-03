package com.example.grupod_atencionpersonasmayoressise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grupod_atencionpersonasmayoressise.iservices.IAdministracionMedicacionService;
import com.example.grupod_atencionpersonasmayoressise.model.AdministracionMedicacion;
import com.example.grupod_atencionpersonasmayoressise.repository.AdministracionMedicacionRepository;

@Service
public class AdministracionMedicacionService implements IAdministracionMedicacionService {
    @Autowired
    AdministracionMedicacionRepository adminMedicacionRepository;

    @Override
    public List<AdministracionMedicacion> listar() {
        return adminMedicacionRepository.findAll();
    }

    @Override
    public AdministracionMedicacion guardar(AdministracionMedicacion administracion) {
        return adminMedicacionRepository.save(administracion);
    }

    @Override
    public AdministracionMedicacion obtenerPorId(Long id) {
        return adminMedicacionRepository.findById(id).orElse(null);
    }

    @Override
    public AdministracionMedicacion actualizar(AdministracionMedicacion administracion) {
        return adminMedicacionRepository.save(administracion);
    }
}
