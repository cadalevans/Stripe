package tn.esprit.demotransaction.ressource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200","http://localhost:8100","http://localhost:57843","*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS","*")
                .allowedHeaders("Content-Type", "Authorization","X-Requested-With", "observe","*")
                .allowCredentials(false)
                .maxAge(3600);
    }
}