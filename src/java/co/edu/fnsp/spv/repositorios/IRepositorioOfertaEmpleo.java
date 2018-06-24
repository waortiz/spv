/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.repositorios;

import co.edu.fnsp.spv.entidades.Documento;
import co.edu.fnsp.spv.entidades.OfertaEmpleo;
import co.edu.fnsp.spv.entidades.Telefono;
import java.util.List;

/**
 *
 * @author William
 */
public interface IRepositorioOfertaEmpleo {
    OfertaEmpleo ingresarOfertaEmpleo(OfertaEmpleo ofertaEmpleo);

    void eliminarTelefono(int idTelefono);
    
    void guardarTelefono(int idOfertaEmpleo, Telefono telefono);
            
    List<Telefono> obtenerTelefonos(int idOfertaEmpleo);
    
    public List<OfertaEmpleo> obtenerOfertasEmpleo();

    public OfertaEmpleo obtenerOfertaEmpleo(int idOfertaEmpleo);

    public Documento obtenerDocumentoOfertaEmpleo(int idOfertaEmpleo);
    
    void actualizarOfertaEmpleo(OfertaEmpleo ofertaEmpleo);

    String obtenerCodigoOfertaEmpleo(int idOfertaEmpleoValidar);
}
