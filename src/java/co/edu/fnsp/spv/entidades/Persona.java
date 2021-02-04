/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.entidades;

/**
 *
 * @author jedag
 */
public class Persona {
    
    private String id;
    private String nombres;
    private String apellidos;
    private String tipoId;
    private String identificacion;
    private boolean empleado;

    public Persona() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String nombreApellido(){
        String nomApe = nombres + " " + apellidos;
        return nomApe;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public boolean getEmpleado() {
        return empleado;
    }

    public void setEmpleado(boolean emleado) {
        this.empleado = emleado;
    }
    
}
