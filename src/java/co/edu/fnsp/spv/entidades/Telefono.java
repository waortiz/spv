/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.entidades;

/**
 *
 * @author William
 */
public class Telefono {

    private int id;
    private int idOfertaEmpleo;
    private int consecutivo;
    private String nombreContacto;
    private String numero;
    private String correoElectronico;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombreContacto
     */
    public String getNombreContacto() {
        return nombreContacto;
    }

    /**
     * @param nombreContacto the nombreContacto to set
     */
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
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
     * @return the consecutivo
     */
    public int getConsecutivo() {
        return consecutivo;
    }

    /**
     * @param consecutivo the consecutivo to set
     */
    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return the idOfertaEmpleo
     */
    public int getIdOfertaEmpleo() {
        return idOfertaEmpleo;
    }

    /**
     * @param idOfertaEmpleo the idOfertaEmpleo to set
     */
    public void setIdOfertaEmpleo(int idOfertaEmpleo) {
        this.idOfertaEmpleo = idOfertaEmpleo;
    }
}
