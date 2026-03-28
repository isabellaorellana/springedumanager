package cl.talento.otec.edumanager.dto;

public class EstudianteDTO {
    private Integer id;
    private String nombre;
    private String email;
    private String curso;

    public EstudianteDTO(Integer id, String nombre, String email, String curso) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.curso = curso;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getCurso() { return curso; }
    
    public void setId(Integer id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setCurso(String curso) { this.curso = curso; }
}