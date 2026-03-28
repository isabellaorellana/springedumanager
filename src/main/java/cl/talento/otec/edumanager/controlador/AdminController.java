package cl.talento.otec.edumanager.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cl.talento.otec.edumanager.modelo.Curso;
import cl.talento.otec.edumanager.servicio.CursoService;

@Controller
public class AdminController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("curso", new Curso()); 
        return "home"; 
    }

    @PostMapping("/admin/cursos/guardar")
    public String guardarCurso(@ModelAttribute("curso") Curso curso) {
        cursoService.guardar(curso);
        return "redirect:/admin/cursos"; 
    }

    @GetMapping("/admin/cursos")
    public String listarCursos(Model model) {
        model.addAttribute("listaCursos", cursoService.obtenerTodos());
        return "cursos"; 
    }
}