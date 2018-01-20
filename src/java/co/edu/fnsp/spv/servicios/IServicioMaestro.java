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
import java.util.List;

/**
 *
 * @author William
 */
public interface IServicioMaestro {

    List<Pais> obtenerPaises();
    
    List<Departamento> obtenerDepartamentos(int idPais);
    
    List<Ciudad> obtenerCiudades(String codigoDepartamento);

    List<NivelFormacion> obtenerNivelesFormacion();
}
