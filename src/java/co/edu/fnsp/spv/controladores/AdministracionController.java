
package co.edu.fnsp.spv.controladores;


import co.edu.fnsp.spv.entidades.User;
import co.edu.fnsp.spv.entidades.Persona;
import co.edu.fnsp.spv.servicios.IServicioAdministracion;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/administracion")
public class AdministracionController {
    
     private static final Logger logger = LogManager.getLogger(OfertaEmpleoController.class.getName());
    
    @Autowired
    private IServicioAdministracion servicioAdministracion;
    
    @RequestMapping(value = "/userIndex", method = RequestMethod.GET)
    public String userIndex(Model model) {
        List<User> usuarios = servicioAdministracion.obtenerUsuarios();

        model.addAttribute("usuarios", usuarios);
        
        return "administracion/userIndex";
    }
    
    
  
    @RequestMapping(value = "/crearUsuario", method = RequestMethod.GET)
    public String usuarios(Model model) {
        List<Persona> personas = servicioAdministracion.obtenerPersonas();

        model.addAttribute("personas", personas);
        return "administracion/crearUsuario";
    }
    
    
  @RequestMapping(value = "/crearUsuario", method = RequestMethod.POST)
    public @ResponseBody
    String crearUsuario(@ModelAttribute co.edu.fnsp.spv.entidadesVista.User user, Model model) throws ParseException, IOException {
        try {
            User userIngresar = new co.edu.fnsp.spv.entidades.User();
            userIngresar.setId(user.getPersona());
            userIngresar.setPerfil(user.getPerfil());
            userIngresar.setClave(user.getClave());
            
            Persona persona = servicioAdministracion.obtenerPersona(user.getPersona());
            
            userIngresar.setNombres(persona.getNombres());
            userIngresar.setApellidos(persona.getApellidos());
            userIngresar.setCorreo(persona.getCorreo());
                       
            
            servicioAdministracion.agregarUser(userIngresar);
            
            return "administracion/usuarios";
            
            
        } catch (Exception exc) {
            logger.error(exc);
            throw exc;
        }
    }
    
    @RequestMapping(value = "/validarEdicion", method = RequestMethod.POST)
    public @ResponseBody
    String validarUsuario(@ModelAttribute co.edu.fnsp.spv.entidadesVista.ValidarEdicionUsuario userValidar, Model model) throws ParseException, IOException {
        
        boolean puedeEditar = servicioAdministracion.validarEdicionUsuario(userValidar.getNombreUsuario(), userValidar.getIdUsuario());
        
        if(!puedeEditar) {
            return "El código ingresado no es válido. No se puede editar la oferta de empleo";
        }
        
        return "";
    }
    
    
    
    
    
    
    @RequestMapping(value = "/editarUsuario", method = RequestMethod.GET)
    public String editarUsuario(Model model) {
        List<User> usuarios = servicioAdministracion.obtenerUsuarios();

        model.addAttribute("usuarios", usuarios);
        
        return "administracion/editarUsuario";
    }
}
