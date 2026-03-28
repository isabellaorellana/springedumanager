package cl.talento.otec.edumanager.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.talento.otec.edumanager.modelo.Curso;
import cl.talento.otec.edumanager.repositorio.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepositorio;

    public List<Curso> obtenerTodos() {
        return cursoRepositorio.findAll();
    }

    public void guardar(Curso curso) {
        cursoRepositorio.save(curso);
    }
}