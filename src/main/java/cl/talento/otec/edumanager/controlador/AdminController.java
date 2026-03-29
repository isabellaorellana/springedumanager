package cl.talento.otec.edumanager.controlador;

import cl.talento.otec.edumanager.modelo.Estudiante;
import cl.talento.otec.edumanager.repositorio.EstudianteRepository;
import cl.talento.otec.edumanager.repositorio.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/estudiantes")
    public String gestionarEstudiantes(Model model) {
        List<Estudiante> lista = estudianteRepository.findAll();
        model.addAttribute("estudiantes", lista);
        return "admin-estudiantes";
    }

    @GetMapping("/cursos")
    public String gestionarCursos(Model model) {
        model.addAttribute("cursos", cursoRepository.findAll());
        return "admin-cursos";
    }
}