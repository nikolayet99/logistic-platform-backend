package nt.logisticplatform.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nt.logisticplatform.model.AccessToken;
import nt.logisticplatform.model.User;
import nt.logisticplatform.service.AccessTokenService;
import nt.logisticplatform.service.UserService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Configurable
public class TokenInterceptor implements HandlerInterceptor {
    private final AccessTokenService tokenService;
    private final UserService userService;

    public TokenInterceptor(AccessTokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null)
            return false;

        AccessToken accessToken = tokenService.findToken(token);
        if (!isValidToken(accessToken)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return false;
        }

        User user = userService.findById(accessToken.getUser().getId());
        if (user.getRole().name().equalsIgnoreCase("CLIENT")) {
            String requestURI = request.getRequestURI();
            boolean grantClientAccess =
                    requestURI.startsWith("/api/package/all/sent/" + user.getId()) ||
                            requestURI.startsWith("/api/package/all/received/" + user.getId());
            if (!grantClientAccess) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
                return false;
            }
        }

        return true;
    }

    private boolean isValidToken(AccessToken token) {
        return token != null && token.getValidUntil().isAfter(LocalDateTime.now());
    }
}
