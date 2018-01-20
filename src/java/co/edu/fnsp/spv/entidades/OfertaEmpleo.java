/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author William
 */
public class OfertaEmpleo {

    private int id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaVigencia;
    private String fechaVigenciaFormateada;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaPublicacion;
    private String fechaPublicacionFormateada;
    private String nombreOfertante;
    private String empresa;
    private String nombreUbicacion;
    private String ubicacion;
    private String cargo;
    private String titulo;
    private String perfilAspirante;
    private String descripcion;
    private Double salario;
    private String salarioFormateado;
    private boolean habilitado;
    private Documento documento;
    private int experienciaMinina;
    private String nivelFormacion;    
    private String nombreNivelFormacion;    
    private String correoElectronicoPublicador;
    private boolean tieneDocumento;
    private String codigo;
    private List<Telefono> telefonos = new ArrayList<>();

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
     * @return the fechaPublicacion
     */
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * @return the fechaVigencia
     */
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * @param fechaVigencia the fechaVigencia to set
     */
    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    /**
     * @return the fechaVigenciaFormateada
     */
    public String getFechaVigenciaFormateada() {
        return fechaVigenciaFormateada;
    }

    /**
     * @param fechaVigenciaFormateada the fechaVigenciaFormateada to set
     */
    public void setFechaVigenciaFormateada(String fechaVigenciaFormateada) {
        this.fechaVigenciaFormateada = fechaVigenciaFormateada;
    }

    /**
     * @return the fechaPublicacionFormateada
     */
    public String getFechaPublicacionFormateada() {
        return fechaPublicacionFormateada;
    }

    /**
     * @param fechaPublicacionFormateada the fechaPublicacionFormateada to set
     */
    public void setFechaPublicacionFormateada(String fechaPublicacionFormateada) {
        this.fechaPublicacionFormateada = fechaPublicacionFormateada;
    }
    
    /**
     * @return the nombreOfertante
     */
    public String getNombreOfertante() {
        return nombreOfertante;
    }

    /**
     * @param nombreOfertante the nombreOfertante to set
     */
    public void setNombreOfertante(String nombreOfertante) {
        this.nombreOfertante = nombreOfertante;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the perfilAspirante
     */
    public String getPerfilAspirante() {
        return perfilAspirante;
    }

    /**
     * @param perfilAspirante the perfilAspirante to set
     */
    public void setPerfilAspirante(String perfilAspirante) {
        this.perfilAspirante = perfilAspirante;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * @return the salarioFormateado
     */
    public String getSalarioFormateado() {
        return salarioFormateado;
    }

    /**
     * @param salarioFormateado the salarioFormateado to set
     */
    public void setSalarioFormateado(String salarioFormateado) {
        this.salarioFormateado = salarioFormateado;
    }

    /**
     * @return the habilitado
     */
    public boolean isHabilitado() {
        return habilitado;
    }

    /**
     * @param habilitado the habilitado to set
     */
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    /**
     * @return the documento
     */
    public Documento getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    /**
     * @return the telefonos
     */
    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    /**
     * @param telefonos the telefonos to set
     */
    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    /**
     * @return the correoElectronicoPublicador
     */
    public String getCorreoElectronicoPublicador() {
        return correoElectronicoPublicador;
    }

    /**
     * @param correoElectronicoPublicador the correoElectronicoPublicador to set
     */
    public void setCorreoElectronicoPublicador(String correoElectronicoPublicador) {
        this.correoElectronicoPublicador = correoElectronicoPublicador;
    }

    /**
     * @param tieneDocumento the tieneDocumento to set
     */
    public void setTieneDocumento(boolean tieneDocumento) {
        this.tieneDocumento = tieneDocumento;
    }
    
    /**
     * @return the tieneDocumento
     */
    public boolean isTieneDocumento() {
        return tieneDocumento;
    }

    /**
     * @return the experienciaMinina
     */
    public int getExperienciaMinina() {
        return experienciaMinina;
    }

    /**
     * @param experienciaMinina the experienciaMinina to set
     */
    public void setExperienciaMinina(int experienciaMinina) {
        this.experienciaMinina = experienciaMinina;
    }

    /**
     * @return the nivelFormacion
     */
    public String getNivelFormacion() {
        return nivelFormacion;
    }

    /**
     * @param nivelFormacion the nivelFormacion to set
     */
    public void setNivelFormacion(String nivelFormacion) {
        this.nivelFormacion = nivelFormacion;
    }

    /**
     * @return the nombreNivelFormacion
     */
    public String getNombreNivelFormacion() {
        return nombreNivelFormacion;
    }

    /**
     * @param nombreNivelFormacion the nombreNivelFormacion to set
     */
    public void setNombreNivelFormacion(String nombreNivelFormacion) {
        this.nombreNivelFormacion = nombreNivelFormacion;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the nombreUbicacion
     */
    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    /**
     * @param nombreUbicacion the nombreUbicacion to set
     */
    public void setNombreUbicacion(String nombreUbicacion) {
        this.nombreUbicacion = nombreUbicacion;
    }
}
