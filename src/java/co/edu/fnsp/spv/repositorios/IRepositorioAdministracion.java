/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.repositorios;

import co.edu.fnsp.spv.entidades.Persona;
import co.edu.fnsp.spv.entidades.User;
import java.util.List;

/**
 *
 * @author jedag
 */
public interface IRepositorioAdministracion {
    User ingresarUser(User user);
    List<Persona> obtenerPersonas();
    Persona obtenerPersona(String id);
}
