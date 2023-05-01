package org.education.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.education.cookie.ActionWithCookie;
import org.education.jwt.ActionWithJwt;
import org.education.security.AuthenticationUserImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ConfigurationFilter extends GenericFilterBean {

    private final ActionWithCookie actionWithCookie;
    private final ActionWithJwt actionWithJwt;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = actionWithCookie.getTokenFromRequest((HttpServletRequest) request);

        if (token != null && actionWithJwt.validateToken(token)) {
            AuthenticationUserImpl authenticationUser = new AuthenticationUserImpl();
            authenticationUser.setEmail(actionWithJwt.getEmailByToken(token));
            authenticationUser.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(authenticationUser);

        }

        chain.doFilter(request, response);
    }
}
