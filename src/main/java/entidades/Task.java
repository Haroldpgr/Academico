package entidades;

public class Task {
    
    private int id ;
    private String nombre;
    private int codigo;
    private int creditos;
   
   
    public int getId() {
        return id;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", creditos=" + creditos + "]";
    }

    public Task(int id, String nombre, int codigo, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
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
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
}
