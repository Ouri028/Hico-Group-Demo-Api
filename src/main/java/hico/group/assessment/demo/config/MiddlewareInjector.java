package hico.group.assessment.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hico.group.assessment.demo.middleware.JwtMiddleware;

@EnableWebSecurity
@Configuration
public class MiddlewareInjector implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtMiddleware())
                .addPathPatterns("/**")
                .excludePathPatterns("/authenticate", "/verifyToken", "/static/**", "/login", "/api-docs/**",
                        "/swagger-ui/**")
                .pathMatcher(new AntPathMatcher());
    }
}
