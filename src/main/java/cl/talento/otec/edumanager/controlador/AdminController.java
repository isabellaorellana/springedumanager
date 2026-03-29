package cl.talento.otec.edumanager.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cl.talento.otec.edumanager.modelo.Curso;
import cl.talento.otec.edumanager.modelo.Estudiante;
import cl.talento.otec.edumanager.servicio.CursoService;
import cl.talento.otec.edumanager.servicio.EstudianteService;

@Controller
public class AdminController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/")
    public String index() {
        return "index"; 
    }


    @GetMapping("/admin/cursos")
    public String listarCursos(Model model) {
        model.addAttribute("listaCursos", cursoService.obtenerTodos());
        return "cursos"; 
    }

    @GetMapping("/admin/cursos/nuevo")
    public String formularioNuevoCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "home";
    }

    @PostMapping("/admin/cursos/guardar")
    public String guardarCurso(@ModelAttribute("curso") Curso curso) {
        cursoService.guardar(curso);
        return "redirect:/admin/cursos"; 
    }

    @GetMapping("/admin/estudiantes")
    public String listarEstudiantes(Model model) {
        model.addAttribute("listaEstudiantes", estudianteService.obtenerTodosLosEstudiantes());
        return "estudiantes"; 
    }

    @GetMapping("/admin/estudiantes/nuevo")
    public String formularioNuevoEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("listaCursos", cursoService.obtenerTodos());
        return "formulario-estudiante"; 
    }

    @PostMapping("/admin/estudiantes/guardar")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:/admin/estudiantes"; 
    }
}