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
public class Documento {
    private String nombre;
    private String tipoContenido;
    private byte[] contenido;
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipoContenido
     */
    public String getTipoContenido() {
        return tipoContenido;
    }

    /**
     * @param tipoContenido the tipoContenido to set
     */
    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    /**
     * @return the contenido
     */
    public byte[] getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
}
