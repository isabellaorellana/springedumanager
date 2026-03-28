package cl.talento.otec.edumanager.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstudianteController {

@GetMapping("/estudiantes/home")
public String homeEstudiante(Model model) {
    return "estudiantes"; 
}
}