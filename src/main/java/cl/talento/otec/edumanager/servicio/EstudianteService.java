package cl.talento.otec.edumanager.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.talento.otec.edumanager.modelo.Estudiante;
import cl.talento.otec.edumanager.repositorio.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    public void guardarEstudiante(Estudiante estudiante) {
        if (estudiante.getPassword() != null && !estudiante.getPassword().isEmpty()) {
            estudiante.setPassword(passwordEncoder.encode(estudiante.getPassword()));
        }

        if (estudiante.getProgreso() == null) {
            estudiante.setProgreso(0.0);
        }
        estudianteRepository.save(estudiante);
    }

    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudianteRepository.findById(id);
    }

    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    public Estudiante buscarPorEmail(String email) {
        return estudianteRepository.findByEmail(email).orElse(null);
    }
}