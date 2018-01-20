/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.entidadesVista;

import co.edu.fnsp.spv.entidades.Telefono;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author William
 */
public class OfertaEmpleo {

    private int id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaVigencia;
    private String nombreOfertante;
    private String empresa;
    private String ubicacion;
    private String cargo;
    private String titulo;
    private String perfilAspirante;
    private String descripcion;
    private String salario;
    private String experienciaMinina;
    private String nivelFormacion;
    private MultipartFile documento;
    private String correoElectronicoPublicador;
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
    public String getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(String salario) {
        this.salario = salario;
    }

    /**
     * @return the documento
     */
    public MultipartFile getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(MultipartFile documento) {
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
     * @return the experienciaMinina
     */
    public String getExperienciaMinina() {
        return experienciaMinina;
    }

    /**
     * @param experienciaMinina the experienciaMinina to set
     */
    public void setExperienciaMinina(String experienciaMinina) {
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
}
