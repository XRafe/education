package org.education.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ActionWithCookie {

    public void createCookie(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(3600);
        cookie.setPath("/");

        response.setContentType("cookie/token");
        response.addCookie(cookie);
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        if (request.getCookies() == null)
            return null;
        if (Arrays.stream(request.getCookies())
                .filter(f -> f.getName().equals("token"))
                .toList()
                .isEmpty()) {
            return null;
        }

        return Arrays.stream(request.getCookies())
                .filter(f -> f.getName().equals("token"))
                .map(Cookie::getValue)
                .findFirst().orElseThrow();
    }
}
