/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class Usuario implements Serializable {
        
    private long idUsuario;
    private String nombres;
    private String apellidos;
    private String nombreUsuario;
    private String clave;
    private String correoElectronico;
    private ArrayList<Privilegio> privilegios = new ArrayList<>();
    private ArrayList<OpcionMenu> opcionesMenu = new ArrayList<>();
        
    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the idUsuario
     */
    public long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the opcionesMenu
     */
    public ArrayList<OpcionMenu> getOpcionesMenu() {
        return opcionesMenu;
    }

    /**
     * @param opcionesMenu the opcionesMenu to set
     */
    public void setOpcionesMenu(ArrayList<OpcionMenu> opcionesMenu) {
        this.opcionesMenu = opcionesMenu;
    }

    /**
     * @return the privilegios
     */
    public ArrayList<Privilegio> getPrivilegios() {
        return privilegios;
    }

    /**
     * @param privilegios the privilegios to set
     */
    public void setPrivilegios(ArrayList<Privilegio> privilegios) {
        this.privilegios = privilegios;
    }
}
