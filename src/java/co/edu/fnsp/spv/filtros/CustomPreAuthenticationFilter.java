/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.filtros;

import co.edu.fnsp.spv.utilidades.JwtUtil;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 *
 * @author William
 */
public class CustomPreAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {

    /**
     *
     * @param request
     * @return
     */
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String principal = JwtUtil.getSubject(request, JwtUtil.jwtTokenCookieName, JwtUtil.signingKey);
        return principal;
    }

    /**
     * @param request
     * @return
     */
    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "";
    }

    @Override
    public void setAuthenticationDetailsSource(AuthenticationDetailsSource source) {
        super.setAuthenticationDetailsSource(source);
    }
}
