public class Materia {

    private String nombre;
    private Profesor profesor;

    public Materia(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void mostrarMateria() {
        System.out.println("Materia: " + nombre);
        System.out.println("Profesor: " + profesor.getNombre());
    }
}
