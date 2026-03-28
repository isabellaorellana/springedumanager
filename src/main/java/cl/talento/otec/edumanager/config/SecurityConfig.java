package cl.talento.otec.edumanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

   @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/api/**").permitAll()
            .anyRequest().authenticated()
        )
        .formLogin(login -> login
            .defaultSuccessUrl("/", true) 
            .permitAll()
        )
        .logout(logout -> logout
            .logoutSuccessUrl("/login?logout")
            .permitAll()
        );
    
    return http.build();
}

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("123456")
            .roles("ADMIN")
            .build();
        UserDetails student = User.withDefaultPasswordEncoder()
            .username("estudiante@otec.cl")
            .password("123456")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(admin, student);
    }
}