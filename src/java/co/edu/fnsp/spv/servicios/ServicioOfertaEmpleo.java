/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.servicios;

import co.edu.fnsp.spv.entidades.Documento;
import co.edu.fnsp.spv.entidades.OfertaEmpleo;
import co.edu.fnsp.spv.entidades.Telefono;
import co.edu.fnsp.spv.repositorios.IRepositorioOfertaEmpleo;
import co.edu.fnsp.spv.utilidades.Mail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *
 * @author William
 */
@Service("servicioOfertaEmpleo")
public class ServicioOfertaEmpleo implements IServicioOfertaEmpleo {

    @Autowired
    private Mail mail;

    @Autowired
    private IRepositorioOfertaEmpleo repositorioOfertaEmpleo;

    @Override
    public int ingresarOfertaEmpleo(OfertaEmpleo ofertaEmpleo) {
        OfertaEmpleo nuevaOfertaEmpleo = repositorioOfertaEmpleo.ingresarOfertaEmpleo(ofertaEmpleo);
        if (ofertaEmpleo.getCorreoElectronicoPublicador() != null && ofertaEmpleo.getCorreoElectronicoPublicador().length() > 0) {
            try {
                new Thread(() -> {
                    mail.sendMail(ofertaEmpleo.getCorreoElectronicoPublicador(),
                            "Código Oferta Laboral",
                            "Se ha generado el código <b>" + nuevaOfertaEmpleo.getCodigo() + "</b> para modificar la oferta laboral");
                }).start();
            } catch (Exception exc) {
            }
        }

        return nuevaOfertaEmpleo.getId();
    }

    @Override
    public void actualizarOfertaEmpleo(OfertaEmpleo ofertaEmpleo) {
        repositorioOfertaEmpleo.actualizarOfertaEmpleo(ofertaEmpleo);
    }

    @Override
    public List<OfertaEmpleo> obtenerOfertasEmpleo() {
        return repositorioOfertaEmpleo.obtenerOfertasEmpleo();
    }

    @Override
    public OfertaEmpleo obtenerOfertaEmpleo(int idOfertaEmpleo) {
        return repositorioOfertaEmpleo.obtenerOfertaEmpleo(idOfertaEmpleo);
    }

    @Override
    public Documento obtenerDocumentoOfertaEmpleo(int idOfertaEmpleo) {
        return repositorioOfertaEmpleo.obtenerDocumentoOfertaEmpleo(idOfertaEmpleo);
    }

    @Override
    public boolean validarEdicionOfertaEmpleo(int idOfertaEmpleoValidar, String codigoOfertaEmpleoValidar) {
        String codigoOfertaEmpleo = repositorioOfertaEmpleo.obtenerCodigoOfertaEmpleo(idOfertaEmpleoValidar);
        return codigoOfertaEmpleo != null && codigoOfertaEmpleo.equalsIgnoreCase(codigoOfertaEmpleoValidar);
    }

    @Override
    public void eliminarTelefono(int idTelefono) {
        repositorioOfertaEmpleo.eliminarTelefono(idTelefono);
    }

    @Override
    public void guardarTelefono(int idOfertaEmpleo, Telefono telefono) {
        repositorioOfertaEmpleo.guardarTelefono(idOfertaEmpleo, telefono);
    }

    @Override
    public List<Telefono> obtenerTelefonos(int idOfertaEmpleo) {
        return repositorioOfertaEmpleo.obtenerTelefonos(idOfertaEmpleo);
    }
}
