public class Estudiante extends Persona {

    private String codigo;

    public Estudiante(String nombre, String documento, String codigo) {
        super(nombre, documento);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Estudiante: " + getNombre());
        System.out.println("Documento: " + getDocumento());
        System.out.println("Código: " + codigo);
    }
}
