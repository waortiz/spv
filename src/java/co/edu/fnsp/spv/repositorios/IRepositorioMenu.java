/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.repositorios;

import co.edu.fnsp.spv.entidades.OpcionMenu;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public interface IRepositorioMenu {

    ArrayList<OpcionMenu> obtenerOpcionesMenuUsuario(long idUsuario);
}
