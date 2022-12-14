package hico.group.assessment.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hico.group.assessment.demo.middleware.JwtMiddleware;

@EnableWebSecurity
@Configuration
public class MiddlewareInjector implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PATCH", "DELETE", "OPTIONS");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtMiddleware())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/authenticate", "/api/verifyToken", "/static/**", "/login/**", "/api-docs/**",
                        "/swagger-ui/**", "/index.html", "/")
                .pathMatcher(new AntPathMatcher());
    }
}
