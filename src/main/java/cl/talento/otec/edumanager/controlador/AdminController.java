package cl.talento.otec.edumanager.controlador;

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
}