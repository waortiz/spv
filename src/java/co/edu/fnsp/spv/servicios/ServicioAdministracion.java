/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.servicios;

import co.edu.fnsp.spv.entidades.Persona;
import co.edu.fnsp.spv.entidades.User;
import co.edu.fnsp.spv.repositorios.IRepositorioAdministracion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jedag
 */
@Service("servicioAdministracion")
public class ServicioAdministracion implements IServicioAdministracion{
    
    @Autowired
    private IRepositorioAdministracion repositorioAdministracion;
    
    @Override
    public void agregarUser(User user){
        repositorioAdministracion.ingresarUser(user);
    }
    
    @Override
    public List<Persona> obtenerPersonas() {
        return repositorioAdministracion.obtenerPersonas();
    }

    
}
