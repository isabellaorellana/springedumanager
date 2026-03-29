package cl.talento.otec.edumanager.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.talento.otec.edumanager.modelo.Curso;
import cl.talento.otec.edumanager.modelo.Estudiante;
import cl.talento.otec.edumanager.repositorio.CursoRepository;
import cl.talento.otec.edumanager.repositorio.EstudianteRepository; 

@Controller
public class AdminController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; 

    @GetMapping("/")
    public String index() {
        return "index"; 
    }

    @GetMapping("/admin/dashboard")
    public String dashboardAdmin(Model model) {
        String correoAdmin = "admin@otec.cl";
        model.addAttribute("listaEstudiantes", estudianteRepository.findByEmailNot(correoAdmin));
        model.addAttribute("listaCursos", cursoRepository.findAll());
        return "admin-dashboard"; 
    }

    @GetMapping("/admin/cursos")
    public String listarCursos(Model model) {
        model.addAttribute("listaCursos", cursoRepository.findAll());
        return "cursos"; 
    }

    @GetMapping("/admin/cursos/nuevo")
    public String formularioNuevoCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "formulario-curso";
    }

    @GetMapping("/admin/cursos/editar/{id}")
    public String editarCurso(@PathVariable Long id, Model model) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        model.addAttribute("curso", curso);
        return "formulario-curso";
    }

    @PostMapping("/admin/cursos/guardar")
    public String guardarCurso(@ModelAttribute("curso") Curso curso, RedirectAttributes flash) {
        cursoRepository.save(curso);
        flash.addFlashAttribute("success", "¡Curso procesado con éxito!");
        return "redirect:/admin/cursos";
    }

    @GetMapping("/admin/cursos/eliminar/{id}")
    public String eliminarCurso(@PathVariable Long id, RedirectAttributes flash) {
        cursoRepository.deleteById(id);
        flash.addFlashAttribute("info", "El curso ha sido eliminado correctamente.");
        return "redirect:/admin/cursos";
    }

    @GetMapping("/admin/estudiantes")
    public String listarEstudiantes(Model model) {
        String correoAdmin = "admin@otec.cl";
        model.addAttribute("listaEstudiantes", estudianteRepository.findByEmailNot(correoAdmin));
        return "estudiantes"; 
    }

    @GetMapping("/admin/estudiantes/nuevo")
    public String formularioNuevoEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("listaCursos", cursoRepository.findAll());
        return "formulario-estudiante";
    }

    @GetMapping("/admin/estudiantes/editar/{id}")
    public String editarEstudiante(@PathVariable Long id, Model model) {
        Estudiante est = estudianteRepository.findById(id).orElseThrow();
        model.addAttribute("estudiante", est);
        model.addAttribute("listaCursos", cursoRepository.findAll());
        return "formulario-estudiante";
    }

    @PostMapping("/admin/estudiantes/guardar")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante, RedirectAttributes flash) {
        if (estudiante.getId() == null) {
            String passwordProvisoria = "123456"; 
            estudiante.setPassword(passwordEncoder.encode(passwordProvisoria));
            flash.addFlashAttribute("success", "Estudiante creado. Clave: " + passwordProvisoria);
        } else {
            Estudiante estExistente = estudianteRepository.findById(estudiante.getId()).get();
            estudiante.setPassword(estExistente.getPassword());
            flash.addFlashAttribute("success", "Datos actualizados.");
        }
        estudianteRepository.save(estudiante);
        return "redirect:/admin/estudiantes";
    }

    @GetMapping("/admin/estudiantes/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id, RedirectAttributes flash) {
        estudianteRepository.deleteById(id);
        flash.addFlashAttribute("info", "Estudiante dado de baja.");
        return "redirect:/admin/estudiantes";
    }

    @GetMapping("/portal")
    public String portal() {
        return "portal";
    }
}