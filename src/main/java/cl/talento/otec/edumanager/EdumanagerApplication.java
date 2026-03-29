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
            repo.findByEmail("admin@otec.cl").ifPresent(repo::delete);

            Estudiante admin = new Estudiante();
            admin.setNombre("Administrador");
            admin.setEmail("admin@otec.cl");
            admin.setPassword(encoder.encode("admin123")); 
            
            repo.save(admin);
            
            System.out.println("----------------------------------------------");
            System.out.println("🚀 ADMIN RE-CREADO CON ÉXITO");
            System.out.println("📧 Usuario: admin@otec.cl");
            System.out.println("🔑 Clave: admin123");
            System.out.println("----------------------------------------------");

            repo.findByEmail("elenanito@gmail.com").ifPresent(elena -> {
            elena.setPassword(encoder.encode("elena123"));
            repo.save(elena);
            System.out.println("✅ ELENA SINCRONIZADA: Ahora puede entrar con elena123");
        });
        repo.findByEmail("elsapatito@gmail.com").ifPresent(elsa -> {
            elsa.setPassword(encoder.encode("elsa123"));
            repo.save(elsa);
            System.out.println("✅ ELSA SINCRONIZADA: Ahora puede entrar con elena123");
        });
        
    };
} };
    
