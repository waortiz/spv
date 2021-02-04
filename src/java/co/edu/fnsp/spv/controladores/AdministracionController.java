
package co.edu.fnsp.spv.controladores;


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
        List<Persona> personas = servicioAdministracion.obtenerPersonas();

        model.addAttribute("personas", personas);
        
        return "administracion/userIndex";
    }
    
    
  
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public String usuarios(Model model) {
        List<Persona> personas = servicioAdministracion.obtenerPersonas();

        model.addAttribute("personas", personas);
        return "administracion/usuarios";
    }
    
    
  @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public @ResponseBody
    String crearOfertaEmpleo(@ModelAttribute co.edu.fnsp.spv.entidadesVista.User user, Model model) throws ParseException, IOException {
        try {
            co.edu.fnsp.spv.entidades.User userIngresar = new co.edu.fnsp.spv.entidades.User();
            userIngresar.setPersona(servicioAdministracion.obtenerPersona(user.getPersona()).nombreApellido());
            userIngresar.setPerfil(user.getPersona());
            userIngresar.setClave(user.getClave());
            
            servicioAdministracion.agregarUser(userIngresar);
            
            return "administracion/usuarios";
            
            
        } catch (Exception exc) {
            logger.error(exc);
            throw exc;
        }
    }
}
