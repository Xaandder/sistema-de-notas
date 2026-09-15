public class Calificacion {

    private Profesor profesor;
    private Estudiante estudiante;
    private Materia materia;
    private int nota;
    private String comentario;

    public Calificacion(
            Profesor profesor,
            Estudiante estudiante,
            Materia materia,
            int nota,
            String comentario) {

        this.profesor = profesor;
        this.estudiante = estudiante;
        this.materia = materia;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void mostrarCalificacion() {

        System.out.println("Materia: " + materia.getNombre());
        System.out.println("Profesor: " + profesor.getNombre());
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Nota: " + nota);
        System.out.println("Comentario: " + comentario);
    }
}
