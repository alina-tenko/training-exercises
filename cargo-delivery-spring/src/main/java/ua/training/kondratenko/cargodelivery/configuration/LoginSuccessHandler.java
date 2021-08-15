package ua.training.kondratenko.cargodelivery.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Configuration
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private static final String ERROR_REDIRECT = "/login?error=true";

    private static final Map<String, String> ENDPOINTS = new HashMap<>();

    static {
        ENDPOINTS.put("ADMIN", "/admin");
        ENDPOINTS.put("USER", "/user");
    }

    @Override
    protected void handle(HttpServletRequest request,
                          HttpServletResponse response,
                          Authentication authentication)
            throws IOException {

        final String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            return;
        }

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        return authentication.getAuthorities()
                .stream()
                .map(authority -> authority.getAuthority())
                .filter(role -> ENDPOINTS.containsKey(role))
                .findFirst()
                .orElse(ERROR_REDIRECT);

    }
}
