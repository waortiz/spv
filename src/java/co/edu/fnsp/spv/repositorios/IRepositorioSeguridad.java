/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.repositorios;

import co.edu.fnsp.spv.entidades.Usuario;

/**
 *
 * @author William
 */
public interface IRepositorioSeguridad {

    Usuario obtenerUsuario(String nombreUsuario);
}
