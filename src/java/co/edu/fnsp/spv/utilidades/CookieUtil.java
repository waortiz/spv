package co.edu.fnsp.spv.utilidades;

import org.springframework.web.util.WebUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static void create(HttpServletResponse httpServletResponse, String name, String value, Boolean secure, Integer maxAge, String domain) {
        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(secure);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);

        Cookie cookieSpv = new Cookie(name, value);
        cookieSpv.setSecure(secure);
        cookieSpv.setHttpOnly(true);
        cookieSpv.setMaxAge(maxAge);
        cookieSpv.setPath("/spv");
        cookieSpv.setDomain(domain);
        httpServletResponse.addCookie(cookieSpv);
    }

    public static void clear(HttpServletResponse httpServletResponse, String name, String domain) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        cookie.setDomain(domain);
        httpServletResponse.addCookie(cookie);

        Cookie cookieSpv = new Cookie(name, null);
        cookieSpv.setPath("/spv");
        cookieSpv.setHttpOnly(true);
        cookieSpv.setMaxAge(0);
        cookieSpv.setDomain(domain);
        httpServletResponse.addCookie(cookieSpv);
    }

    public static String getValue(HttpServletRequest httpServletRequest, String name) {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, name);
        return cookie != null ? cookie.getValue() : null;
    }
}
