package cl.talento.otec.edumanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cl.talento.otec.edumanager.modelo.Estudiante;
import cl.talento.otec.edumanager.repositorio.EstudianteRepository;

@SpringBootApplication
public class EdumanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdumanagerApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(EstudianteRepository repo, BCryptPasswordEncoder encoder) {
        return args -> {
            repo.findByEmail("admin@otec.cl").ifPresent(adminViejo -> {
                repo.delete(adminViejo);
            });

            Estudiante admin = new Estudiante();
            admin.setNombre("Administrador");
            admin.setEmail("admin@otec.cl");
            
            admin.setPassword(encoder.encode("admin123")); 
            
            repo.save(admin);
            
            System.out.println("----------------------------------------------");
            System.out.println("✅ USUARIO ADMIN CREADO O ACTUALIZADO");
            System.out.println("📧 Correo: admin@otec.cl");
            System.out.println("🔑 Clave: admin123");
            System.out.println("----------------------------------------------");
        };
    }
}