package cl.talento.otec.edumanager.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.talento.otec.edumanager.modelo.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}