package nt.logisticplatform.config;

import nt.logisticplatform.interceptor.TokenInterceptor;
import nt.logisticplatform.service.AccessTokenService;
import nt.logisticplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    AccessTokenService tokenService;

    @Autowired
    UserService userService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor(tokenService, userService))
                .excludePathPatterns("/api/auth/**", "/swagger-ui/**");
    }
}
