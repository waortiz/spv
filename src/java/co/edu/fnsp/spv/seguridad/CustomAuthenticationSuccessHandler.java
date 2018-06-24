/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.seguridad;

import co.edu.fnsp.spv.entidades.DetalleUsuario;
import co.edu.fnsp.spv.utilidades.CookieUtil;
import co.edu.fnsp.spv.utilidades.JwtUtil;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author William
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    protected final Log logger = LogFactory.getLog(this.getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    protected CustomAuthenticationSuccessHandler() {
        super();
    }

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
        String token = JwtUtil.generateToken(JwtUtil.signingKey, ((DetalleUsuario)authentication.getPrincipal()).getUsername());
        CookieUtil.create(response, JwtUtil.jwtTokenCookieName, token, false, -1, request.getServerName());
        handle(request, response, authentication);
    }

    protected void handle(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
        final String targetUrl = "/index";

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
