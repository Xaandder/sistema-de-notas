public class Profesor extends Persona {

    private String especialidad;

    public Profesor(String nombre, String documento, String especialidad) {
        super(nombre, documento);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Profesor: " + getNombre());
        System.out.println("Documento: " + getDocumento());
        System.out.println("Especialidad: " + especialidad);
    }
}
