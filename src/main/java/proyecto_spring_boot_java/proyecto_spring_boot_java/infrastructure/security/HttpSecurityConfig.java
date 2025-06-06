package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.security;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {
    @Autowired
    private AuthenticationProvider daoAuthProvider;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(daoAuthProvider)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.POST, "/customers").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/customers").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/auth/register").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/auth/validate-token").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/products").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/api/Tools").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/suppliers").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/api/Tools").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/api/Reservations").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/api/Reservations").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/api/Reservations/user/**").permitAll();
                     auth.requestMatchers(HttpMethod.GET, "/api/Tools/proveedor/**").permitAll(); 
                     auth.requestMatchers(HttpMethod.DELETE, "/api/Reservations/**").permitAll();
                     auth.requestMatchers(HttpMethod.GET, "/api/Reservations/*/pdf").permitAll();
                   auth.requestMatchers(HttpMethod.DELETE, "/api/Tools/**").permitAll();
          
                    auth.requestMatchers(HttpMethod.GET, "/suppliers").permitAll();
                    auth.anyRequest().authenticated();
                })
                .cors(withDefaults());
        return http.build();
    }

 
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://127.0.0.1:5500")); 
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
