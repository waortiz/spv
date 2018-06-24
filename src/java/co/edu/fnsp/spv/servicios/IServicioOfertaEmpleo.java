/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.servicios;

import co.edu.fnsp.spv.entidades.Documento;
import co.edu.fnsp.spv.entidades.OfertaEmpleo;
import co.edu.fnsp.spv.entidades.Telefono;
import java.util.List;

/**
 *
 * @author William
 */
public interface IServicioOfertaEmpleo {
    int ingresarOfertaEmpleo(OfertaEmpleo ofertaEmpleo);

    List<OfertaEmpleo> obtenerOfertasEmpleo();
    
    OfertaEmpleo obtenerOfertaEmpleo(int idOfertaEmpleo);

    void eliminarTelefono(int idTelefono);
    
    void guardarTelefono(int idOfertaEmpleo, Telefono telefono);
            
    List<Telefono> obtenerTelefonos(int idOfertaEmpleo);
    
    public Documento obtenerDocumentoOfertaEmpleo(int idOfertaEmpleo);
    
    void actualizarOfertaEmpleo(OfertaEmpleo ofertaEmpleo);

    boolean validarEdicionOfertaEmpleo(int idOfertaEmpleoValidar, String codigoOfertaEmpleoValidar);
    
}
