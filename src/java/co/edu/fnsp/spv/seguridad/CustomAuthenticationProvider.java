/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.fnsp.spv.seguridad;

import co.edu.fnsp.spv.entidades.Usuario;
import co.edu.fnsp.spv.servicios.ServicioSeguridad;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author William
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private ServicioSeguridad servicioSeguridad;

    /**
     *
     * @param authentication
     * @return
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Usuario usuario = servicioSeguridad.obtenerUsuario(username);
        if (usuario == null) {
            throw new BadCredentialsException("Usuario no existe");
        }

        if (!password.equals(usuario.getClave())) {
            throw new BadCredentialsException("Clave incorrecta");
        }

        Collection<? extends GrantedAuthority> privilegios = usuario.getPrivilegios();
        
        return new UsernamePasswordAuthenticationToken(usuario, password, privilegios);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
