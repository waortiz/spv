package co.edu.fnsp.spv.controladores;

import co.edu.fnsp.spv.entidades.Usuario;
import co.edu.fnsp.spv.entidadesVista.RecuperacionClave;
import co.edu.fnsp.spv.servicios.IServicioSeguridad;
import co.edu.fnsp.spv.utilidades.CookieUtil;
import co.edu.fnsp.spv.utilidades.JwtUtil;
import co.edu.fnsp.spv.utilidades.Mail;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class LoginController {
    private static final Logger logger = LogManager.getLogger(LoginController.class.getName());
    
    @Autowired
    private IServicioSeguridad servicioSeguridad;
    
    @Autowired
    private Mail mail;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {

        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CookieUtil.clear(response, JwtUtil.jwtTokenCookieName, request.getServerName()); 
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
 
        return "redirect:/index";
    }
    
    @RequestMapping(value = "/login/recuperarClave", method = RequestMethod.POST)
    public @ResponseBody
    String recuperarClave(@ModelAttribute(value = "recuperacionClave") RecuperacionClave recuperacionClave, Model model) {
        String mensaje = "";
        Usuario usuarioActual = servicioSeguridad.obtenerUsuario(recuperacionClave.getNombreUsuario());
        if (usuarioActual != null) {
            try {
                mail.sendMail(usuarioActual.getCorreoElectronico(), "Clave Ingreso Sistema", "Para ingresar al sistema utilice como clave <b>" + usuarioActual.getClave() + "</b>");
                mensaje = "La clave ha sido enviada a su correo electrónico";
            } catch (Exception exc) {
                logger.error(exc);
                throw exc;
            }
        } else {
            mensaje = "El usuario no existe. por favor verifique";
        }

        return mensaje;
    }
}
