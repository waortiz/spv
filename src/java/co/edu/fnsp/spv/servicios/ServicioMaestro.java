/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.servicios;

import co.edu.fnsp.spv.entidades.Ciudad;
import co.edu.fnsp.spv.entidades.Departamento;
import co.edu.fnsp.spv.entidades.NivelFormacion;
import co.edu.fnsp.spv.entidades.Pais;
import co.edu.fnsp.spv.repositorios.IRepositorioMaestro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William
 */
@Service("servicioMaestro")
public class ServicioMaestro implements IServicioMaestro {

    @Autowired
    private IRepositorioMaestro repositorioMaestro;

    @Override
    public List<Pais> obtenerPaises() {
        return repositorioMaestro.obtenerPaises();
    }

    @Override
    public List<Departamento> obtenerDepartamentos(int idPais) {
        return repositorioMaestro.obtenerDepartamentos(idPais);
    }

    @Override
    public List<Ciudad> obtenerCiudades(String codigoDepartamento) {
        return repositorioMaestro.obtenerCiudades(codigoDepartamento);
    }

    @Override
    public List<NivelFormacion> obtenerNivelesFormacion() {
        return repositorioMaestro.obtenerNivelesFormacion();
    }

 
}
