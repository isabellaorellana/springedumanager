package cl.talento.otec.edumanager.controlador;

import cl.talento.otec.edumanager.modelo.Curso;
import cl.talento.otec.edumanager.modelo.Estudiante;
import cl.talento.otec.edumanager.repositorio.EstudianteRepository;
import cl.talento.otec.edumanager.repositorio.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Estudiante> soloAlumnos = lista.stream()
                .filter(e -> e.getEmail() != null && !e.getEmail().equals("admin@otec.cl"))
                .collect(Collectors.toList());
        model.addAttribute("estudiantes", soloAlumnos);
        return "estudiantes";
    }

    @GetMapping("/estudiantes/nuevo")
    public String formularioNuevoEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("cursos", cursoRepository.findAll());
        return "formulario-estudiante";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String formularioEditarEstudiante(@PathVariable("id") Long id, Model model) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("cursos", cursoRepository.findAll());
        return "formulario-estudiante";
    }

    @PostMapping("/estudiantes/guardar")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return "redirect:/admin/estudiantes";
    }

    @GetMapping("/estudiantes/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable("id") Long id) {
        estudianteRepository.deleteById(id);
        return "redirect:/admin/estudiantes";
    
    }

@GetMapping("/cursos")
public String gestionarCursos(Model model) {
    model.addAttribute("cursos", cursoRepository.findAll());
    return "cursos";
}

@GetMapping("/cursos/nuevo")
public String formularioNuevoCurso(Model model) {
    model.addAttribute("curso", new Curso());
    return "formulario-curso";
}

@GetMapping("/cursos/editar/{id}")
public String formularioEditarCurso(@PathVariable("id") Long id, Model model) {
    Curso curso = cursoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de curso inválido: " + id));
    model.addAttribute("curso", curso);
    return "formulario-curso";
}

@PostMapping("/cursos/guardar")
public String guardarCurso(@ModelAttribute("curso") Curso curso) {
    cursoRepository.save(curso);
    return "redirect:/admin/cursos";
}

@GetMapping("/cursos/eliminar/{id}")
public String eliminarCurso(@PathVariable("id") Long id) {
    cursoRepository.deleteById(id);
    return "redirect:/admin/cursos";
}
}