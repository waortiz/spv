/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.entidades;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author William
 */
public class DetalleUsuario extends User {

    private long idUsuario;
    
    public DetalleUsuario(long idUsuario, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super( username,  password,  enabled, accountNonExpired, credentialsNonExpired,  accountNonLocked,  authorities);
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idUsuario
     */
    public long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }    
}
