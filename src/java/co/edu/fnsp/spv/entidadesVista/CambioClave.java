/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.entidadesVista;

import java.io.Serializable;
/**
 *
 * @author William
 */
public class CambioClave implements Serializable {
            
    private String claveAnterior;
    private String claveNueva;
    
    /**
     * @return the claveAnterior
     */
    public String getClaveAnterior() {
        return claveAnterior;
    }

    /**
     * @param claveAnterior the claveAnterior to set
     */
    public void setClaveAnterior(String claveAnterior) {
        this.claveAnterior = claveAnterior;
    }

    /**
     * @return the claveNueva
     */
    public String getClaveNueva() {
        return claveNueva;
    }

    /**
     * @param claveNueva the claveNueva to set
     */
    public void setClaveNueva(String claveNueva) {
        this.claveNueva = claveNueva;
    }
   
}
