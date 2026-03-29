package cl.talento.otec.edumanager.controlador;

import cl.talento.otec.edumanager.modelo.Estudiante;
import cl.talento.otec.edumanager.repositorio.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping("/home")
public String home(Authentication auth) {
    if (auth == null) return "redirect:/"; 

    boolean isAdmin = auth.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

    if (isAdmin) {
        return "redirect:/admin/dashboard"; 
    } else {
        return "redirect:/estudiante/dashboard"; 
    }
}

@GetMapping("/estudiante/dashboard")
public String estudianteDashboard(Model model, Authentication auth) {
    if (auth == null) return "redirect:/"; 

    String email = auth.getName();
    Estudiante estudiante = estudianteRepository.findByEmail(email).orElse(null);
    
    if (estudiante != null) {
        model.addAttribute("estudiante", estudiante);
    }
    
    return "estudiante-dashboard"; 
}
}