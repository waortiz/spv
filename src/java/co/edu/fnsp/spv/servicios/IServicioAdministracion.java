/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.servicios;

import co.edu.fnsp.spv.entidades.Persona;
import co.edu.fnsp.spv.entidades.User;
import java.util.List;

/**
 *
 * @author jedag
 */
public interface IServicioAdministracion {
    void agregarUser(User user);
    List<User> obtenerUsuarios();
    User obtenerUsuario(String id);
    List<Persona> obtenerPersonas();
    Persona obtenerPersona(String id); 
    boolean validarEdicionUsuario(String nombreUsuario, int idUsuario);
}
