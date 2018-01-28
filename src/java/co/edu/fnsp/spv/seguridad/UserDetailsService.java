/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.seguridad;

import co.edu.fnsp.spv.entidades.DetalleUsuario;
import co.edu.fnsp.spv.entidades.Usuario;
import co.edu.fnsp.spv.servicios.ServicioSeguridad;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author William
 */
public class UserDetailsService implements AuthenticationUserDetailsService<Authentication> {
    @Autowired
    private ServicioSeguridad servicioSeguridad;
    
    @Override
    public UserDetails loadUserDetails(Authentication authentication)
            throws UsernameNotFoundException {

        Usuario usuario = servicioSeguridad.obtenerUsuario(authentication.getName());
        if (usuario == null) {
            throw new UsernameNotFoundException("Could not load user : "
                    + authentication.getName());
        }
        
        Collection<? extends GrantedAuthority> privilegios = usuario.getPrivilegios();
        
        return new DetalleUsuario(usuario.getIdUsuario(), 
                usuario.getNombreUsuario(), 
                usuario.getClave(), 
                true, 
                true, 
                true, 
                true,
                privilegios);
    }
}
