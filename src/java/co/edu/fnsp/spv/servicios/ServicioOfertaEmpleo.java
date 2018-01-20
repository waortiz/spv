/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.servicios;

import co.edu.fnsp.spv.entidades.Documento;
import co.edu.fnsp.spv.entidades.OfertaEmpleo;
import co.edu.fnsp.spv.repositorios.IRepositorioOfertaEmpleo;
import co.edu.fnsp.spv.utilidades.Mail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
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

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public void ingresarOfertaEmpleo(OfertaEmpleo ofertaEmpleo) {
        TransactionDefinition txDef = new DefaultTransactionDefinition();
        TransactionStatus txStatus = transactionManager.getTransaction(txDef);
        try {
            String codigo = repositorioOfertaEmpleo.ingresarOfertaEmpleo(ofertaEmpleo);
            transactionManager.commit(txStatus);

            if (ofertaEmpleo.getCorreoElectronicoPublicador() != null && ofertaEmpleo.getCorreoElectronicoPublicador().length() > 0) {
                mail.sendMail(ofertaEmpleo.getCorreoElectronicoPublicador(),
                        "Código Oferta Laboral",
                        "Se ha generado el código <b>" + codigo + "</b> para modificar la oferta laboral");
            }
        } catch (TransactionException exc) {
            transactionManager.rollback(txStatus);
            throw exc;
        }
    }

    @Override
    public void actualizarOfertaEmpleo(OfertaEmpleo ofertaEmpleo) {
        TransactionDefinition txDef = new DefaultTransactionDefinition();
        TransactionStatus txStatus = transactionManager.getTransaction(txDef);
        try {
            repositorioOfertaEmpleo.actualizarOfertaEmpleo(ofertaEmpleo);
            transactionManager.commit(txStatus);
        } catch (TransactionException exc) {
            transactionManager.rollback(txStatus);
            throw exc;
        }
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
        return codigoOfertaEmpleo!= null && codigoOfertaEmpleo.equalsIgnoreCase(codigoOfertaEmpleoValidar); 
    }
}
