package dto;

public class AsignaturaDTO {
    private int id;
    private String nombre;
    private String curso;
    private String tasa;
    private String activo;

    public AsignaturaDTO(int id, String nombre, String curso, String tasa, String activo) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.tasa = tasa;
        this.activo = activo;
    }

    public AsignaturaDTO(int id, String nombre, String curso) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
    }

    public AsignaturaDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTasa() {
        return tasa;
    }

    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}