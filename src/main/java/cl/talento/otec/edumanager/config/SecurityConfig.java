package cl.talento.otec.edumanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import cl.talento.otec.edumanager.modelo.Estudiante;
import cl.talento.otec.edumanager.repositorio.EstudianteRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, DaoAuthenticationProvider authProvider) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        )
            .authenticationProvider(authProvider)
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/login", "/home", "/css/**", "/js/**", "/img/**", "/static/**").permitAll() 
            .requestMatchers("/admin/**").hasRole("ADMIN") 
            .requestMatchers("/estudiante/**").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()
            )

            .formLogin(form -> form
    .loginPage("/")
    .loginProcessingUrl("/login")
    .defaultSuccessUrl("/home", true)
    .failureHandler((request, response, exception) -> {
        System.out.println("❌ ERROR DE LOGIN: " + exception.getMessage());
        response.sendRedirect("/?error=true");
    })
    .permitAll()
)
.logout(logout -> logout
    .logoutUrl("/logout")
    .logoutSuccessUrl("/")
    .permitAll()
);
            
        return http.build();
    }

    @Bean
public UserDetailsService userDetailsService(EstudianteRepository repo) {
    return email -> {
        Estudiante est = repo.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        String role = est.getEmail().equals("admin@otec.cl") ? "ADMIN" : "USER";
        
        System.out.println("✅ VALIDADO: " + est.getNombre() + " | Rol: " + role);

        return User.builder()
            .username(est.getEmail())
            .password(est.getPassword())
            .roles(role)
            .build();
    };
}
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, BCryptPasswordEncoder encoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder);
        return authProvider;
    }
}