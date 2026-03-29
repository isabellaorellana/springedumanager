package cl.talento.otec.edumanager.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.talento.otec.edumanager.modelo.Estudiante; 

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    
    Optional<Estudiante> findByEmail(String email);
    List<Estudiante> findByEmailNot(String emailAdmin);
}