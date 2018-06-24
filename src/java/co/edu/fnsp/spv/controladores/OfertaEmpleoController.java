/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.controladores;

import co.edu.fnsp.spv.entidades.Ciudad;
import co.edu.fnsp.spv.entidades.Departamento;
import co.edu.fnsp.spv.entidades.Documento;
import co.edu.fnsp.spv.entidades.NivelFormacion;
import co.edu.fnsp.spv.entidades.OfertaEmpleo;
import co.edu.fnsp.spv.entidades.Pais;
import co.edu.fnsp.spv.entidades.Telefono;
import co.edu.fnsp.spv.servicios.IServicioMaestro;
import co.edu.fnsp.spv.servicios.IServicioOfertaEmpleo;
import co.edu.fnsp.spv.utilidades.Util;
import com.google.gson.Gson;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author William
 */
@Controller
@RequestMapping(value = "/ofertasEmpleo")
public class OfertaEmpleoController {

    private static final Logger logger = LogManager.getLogger(OfertaEmpleoController.class.getName());
    
    @Autowired
    private IServicioOfertaEmpleo servicioOfertaEmpleo;

    @Autowired
    private IServicioMaestro servicioMaestro;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String obtenerOfertasEmpleo(Model model) {
        List<OfertaEmpleo> ofertasEmpleo = servicioOfertaEmpleo.obtenerOfertasEmpleo();

        model.addAttribute("ofertasEmpleo", ofertasEmpleo);

        return "ofertasEmpleo";
    }

    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String mostrarCreacionOfertaEmpleo(Model model) {
        List<Pais> paises = servicioMaestro.obtenerPaises();
        List<NivelFormacion> nivelesFormacion = servicioMaestro.obtenerNivelesFormacion();
        
        model.addAttribute("paises", paises);
        model.addAttribute("nivelesFormacion", nivelesFormacion);

        return "ofertasEmpleo/crear";
    }
    
    @RequestMapping(value = "/mostrarEdicion", method = RequestMethod.POST)
    public String mostrarEdicionOfertaEmpleo(@ModelAttribute co.edu.fnsp.spv.entidadesVista.EdicionOfertaEmpleo edicionOfertaEmpleo, Model model) {
        List<Pais> paises = servicioMaestro.obtenerPaises();
        List<NivelFormacion> nivelesFormacion = servicioMaestro.obtenerNivelesFormacion();
        OfertaEmpleo ofertaEmpleo = servicioOfertaEmpleo.obtenerOfertaEmpleo(edicionOfertaEmpleo.getIdOfertaEmpleoEdicion());
        
        model.addAttribute("paises", paises);
        model.addAttribute("nivelesFormacion", nivelesFormacion);
        if (ofertaEmpleo.getTelefonos().size() > 0) {
            model.addAttribute("telefonosJSON", Util.obtenerTelefonosJSON(ofertaEmpleo.getTelefonos()));
        }

        model.addAttribute("ofertaEmpleo", ofertaEmpleo);
        
        return "ofertasEmpleo/editar";
    }
   
    @RequestMapping(value = "/validarEdicion", method = RequestMethod.POST)
    public @ResponseBody String validarEdicionOfertaEmpleo(@ModelAttribute co.edu.fnsp.spv.entidadesVista.ValidarEdicionOfertaEmpleo validarEdicionOfertaEmpleo, Model model) {
        boolean puedeEditar = servicioOfertaEmpleo.validarEdicionOfertaEmpleo(validarEdicionOfertaEmpleo.getIdOfertaEmpleoValidar(),
                validarEdicionOfertaEmpleo.getCodigoOfertaEmpleoValidar());
        
        if(!puedeEditar) {
            return "El código ingresado no es válido. No se puede editar la oferta de empleo";
        }
        
        return "";
    }    
    
    /**
     *
     * @param ofertaEmpleo
     * @param model
     * @return
     * @throws java.text.ParseException
     * @throws java.io.IOException
     */
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public @ResponseBody
    String crearOfertaEmpleo(@ModelAttribute co.edu.fnsp.spv.entidadesVista.OfertaEmpleo ofertaEmpleo, Model model) throws ParseException, IOException {
        try {
            OfertaEmpleo ofertaEmpleoIngresar = new OfertaEmpleo();
            ofertaEmpleoIngresar.setId(ofertaEmpleo.getId());
            ofertaEmpleoIngresar.setCargo(ofertaEmpleo.getCargo());
            ofertaEmpleoIngresar.setDescripcion(ofertaEmpleo.getDescripcion());
            ofertaEmpleoIngresar.setEmpresa(ofertaEmpleo.getEmpresa());
            ofertaEmpleoIngresar.setFechaVigencia(ofertaEmpleo.getFechaVigencia());
            ofertaEmpleoIngresar.setNombreOfertante(ofertaEmpleo.getNombreOfertante());
            ofertaEmpleoIngresar.setTitulo(ofertaEmpleo.getTitulo());
            ofertaEmpleoIngresar.setPerfilAspirante(ofertaEmpleo.getPerfilAspirante());
            if (ofertaEmpleo.getSalario().length() > 0) {
                ofertaEmpleoIngresar.setSalario(Util.obtenerNumeroDecimal(ofertaEmpleo.getSalario()));
            }
            if (ofertaEmpleo.getExperienciaMinina().length() > 0) {
                ofertaEmpleoIngresar.setExperienciaMinina(Util.obtenerEntero(ofertaEmpleo.getExperienciaMinina()));
            }
            if (ofertaEmpleo.getNivelFormacion().length() > 0) {
                ofertaEmpleoIngresar.setNivelFormacion(ofertaEmpleo.getNivelFormacion());
            }
            ofertaEmpleoIngresar.setUbicacion(ofertaEmpleo.getUbicacion());
            ofertaEmpleoIngresar.setCorreoElectronicoPublicador(ofertaEmpleo.getCorreoElectronicoPublicador());

            Documento documento = null;
            if (ofertaEmpleo.getDocumento() != null && ofertaEmpleo.getDocumento().getBytes().length > 0) {
                documento = new Documento();
                documento.setContenido(ofertaEmpleo.getDocumento().getBytes());
                documento.setNombre(ofertaEmpleo.getDocumento().getOriginalFilename());
                documento.setTipoContenido(ofertaEmpleo.getDocumento().getContentType());
                ofertaEmpleoIngresar.setDocumento(documento);
            }
            int id = ofertaEmpleo.getId();
            if(ofertaEmpleo.getId() == 0) {
                id = servicioOfertaEmpleo.ingresarOfertaEmpleo(ofertaEmpleoIngresar);
            } else {
                servicioOfertaEmpleo.actualizarOfertaEmpleo(ofertaEmpleoIngresar);
            }

            return "{\"id\":" + id + "}";
        } catch (Exception exc) {
            logger.error(exc);
            throw exc;
        }
    }

       /**
     *
     * @param ofertaEmpleo
     * @param model
     * @return
     * @throws java.text.ParseException
     * @throws java.io.IOException
     */
    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarOfertaEmpleo(@ModelAttribute co.edu.fnsp.spv.entidadesVista.OfertaEmpleo ofertaEmpleo, Model model) throws ParseException, IOException {
        try {
            OfertaEmpleo ofertaEmpleoActualizar = new OfertaEmpleo();
            ofertaEmpleoActualizar.setId(ofertaEmpleo.getId());
            ofertaEmpleoActualizar.setCargo(ofertaEmpleo.getCargo());
            ofertaEmpleoActualizar.setDescripcion(ofertaEmpleo.getDescripcion());
            ofertaEmpleoActualizar.setEmpresa(ofertaEmpleo.getEmpresa());
            ofertaEmpleoActualizar.setFechaVigencia(ofertaEmpleo.getFechaVigencia());
            ofertaEmpleoActualizar.setNombreOfertante(ofertaEmpleo.getNombreOfertante());
            ofertaEmpleoActualizar.setTitulo(ofertaEmpleo.getTitulo());
            ofertaEmpleoActualizar.setPerfilAspirante(ofertaEmpleo.getPerfilAspirante());
            if (ofertaEmpleo.getSalario().length() > 0) {
                ofertaEmpleoActualizar.setSalario(Util.obtenerNumeroDecimal(ofertaEmpleo.getSalario()));
            }
            if (ofertaEmpleo.getExperienciaMinina().length() > 0) {
                ofertaEmpleoActualizar.setExperienciaMinina(Util.obtenerEntero(ofertaEmpleo.getExperienciaMinina()));
            }
            if (ofertaEmpleo.getNivelFormacion().length() > 0) {
                ofertaEmpleoActualizar.setNivelFormacion(ofertaEmpleo.getNivelFormacion());
            }
            ofertaEmpleoActualizar.setUbicacion(ofertaEmpleo.getUbicacion());
            ofertaEmpleoActualizar.setCorreoElectronicoPublicador(ofertaEmpleo.getCorreoElectronicoPublicador());

            Documento documento = null;
            if (ofertaEmpleo.getDocumento() != null && ofertaEmpleo.getDocumento().getBytes().length > 0) {
                documento = new Documento();
                documento.setContenido(ofertaEmpleo.getDocumento().getBytes());
                documento.setNombre(ofertaEmpleo.getDocumento().getOriginalFilename());
                documento.setTipoContenido(ofertaEmpleo.getDocumento().getContentType());
                ofertaEmpleoActualizar.setDocumento(documento);
            }
            servicioOfertaEmpleo.actualizarOfertaEmpleo(ofertaEmpleoActualizar);

            return "";
        } catch (Exception exc) {
            logger.error(exc);
            throw exc;
        }
    }

    @RequestMapping(value = {"/telefono"}, method = RequestMethod.POST)
    public @ResponseBody
    String guardarTelefono(@ModelAttribute(value = "telefono") Telefono telefono, Model model) throws Exception {
        String json = "";
        try {
            servicioOfertaEmpleo.guardarTelefono(telefono.getIdOfertaEmpleo(), telefono);
            List<Telefono> telefonos = servicioOfertaEmpleo.obtenerTelefonos(telefono.getIdOfertaEmpleo());
            json = Util.obtenerTelefonosJSON(telefonos);
        } catch (Exception exc) {
            logger.error(exc);
            throw exc;
        }

        return json;
    }

    @RequestMapping(value = "/eliminarTelefono/{idOfertaEmpleo}/{idTelefono}", method = RequestMethod.GET)
    public @ResponseBody
    String eliminarTelefono(@PathVariable("idOfertaEmpleo") int idOfertaEmpleo, @PathVariable("idTelefono") int idTelefono, Model model) {
        String json = "";
        try {
            servicioOfertaEmpleo.eliminarTelefono(idTelefono);
            List<Telefono> telefonos = servicioOfertaEmpleo.obtenerTelefonos(idOfertaEmpleo);
            json = Util.obtenerTelefonosJSON(telefonos);
        } catch (Exception exc) {
            logger.error(exc);
            throw exc;
        }

        return json;
    }
    
    @RequestMapping(value = "/{idOfertaEmpleo}", method = RequestMethod.GET)
    public @ResponseBody
    String obtenerOfertaEmpleo(@PathVariable int idOfertaEmpleo, Model model) {
        OfertaEmpleo ofertaEmpleo = servicioOfertaEmpleo.obtenerOfertaEmpleo(idOfertaEmpleo);
        Gson gson = new Gson();

        return gson.toJson(ofertaEmpleo);
    }

    @RequestMapping(value = "/departamentosPais/{idPais}", method = RequestMethod.GET)
    public @ResponseBody
    String obtenerDepartamentos(@ModelAttribute(value = "idPais") int idPais, Model model) {
        List<Departamento> departamentos = servicioMaestro.obtenerDepartamentos(idPais);
        Gson gson = new Gson();

        return gson.toJson(departamentos);
    }

    @RequestMapping(value = "/ciudadesDepartamento/{codigoDepartamento}", method = RequestMethod.GET)
    public @ResponseBody
    String obtenerCiudades(@ModelAttribute(value = "codigoDepartamento") String codigoDepartamento, Model model) {
        List<Ciudad> ciudades = servicioMaestro.obtenerCiudades(codigoDepartamento);
        Gson gson = new Gson();

        return gson.toJson(ciudades);
    }

    @RequestMapping(value = "/documento/{idOfertaEmpleo}", method = RequestMethod.GET)
    public void obtenerDocumentoOfertaEmpleo(@PathVariable("idOfertaEmpleo") int idOfertaEmpleo, HttpServletResponse response) throws IOException {
        Documento documento = servicioOfertaEmpleo.obtenerDocumentoOfertaEmpleo(idOfertaEmpleo);
        if (documento != null) {
            response.reset();
            response.resetBuffer();
            response.setHeader("Pragma", "No-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType(documento.getTipoContenido());
            response.setContentLength(documento.getContenido().length);
            response.setHeader("Content-Disposition", "attachment; filename=\"" + documento.getNombre() + "\"");
            FileCopyUtils.copy(documento.getContenido(), response.getOutputStream());
        }
    }
}
