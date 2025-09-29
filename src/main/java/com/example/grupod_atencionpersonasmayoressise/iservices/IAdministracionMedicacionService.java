package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import com.example.grupod_atencionpersonasmayoressise.model.AdministracionMedicacion;

public interface IAdministracionMedicacionService {
    List<AdministracionMedicacion> listar();

    AdministracionMedicacion guardar(AdministracionMedicacion administracion);

    AdministracionMedicacion obtenerPorId(Long id);

    AdministracionMedicacion actualizar(AdministracionMedicacion administracion);
}
