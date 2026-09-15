import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAcademico {

    static Scanner entrada = new Scanner(System.in);

    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Profesor> profesores = new ArrayList<>();
    static ArrayList<Materia> materias = new ArrayList<>();
    static ArrayList<Calificacion> calificaciones = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;

        do {

            System.out.println("\n=================================");
            System.out.println("       SISTEMA ACADÉMICO");
            System.out.println("=================================");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar profesor");
            System.out.println("3. Registrar materia");
            System.out.println("4. Calificar estudiante");
            System.out.println("5. Ver calificaciones");
            System.out.println("6. Ver estudiantes");
            System.out.println("7. Ver profesores");
            System.out.println("8. Ver materias");
            System.out.println("0. Salir");
            System.out.println("=================================");

            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    registrarEstudiante();
                    break;

                case 2:
                    registrarProfesor();
                    break;

                case 3:
                    registrarMateria();
                    break;

                case 4:
                    calificarEstudiante();
                    break;

                case 5:
                    verCalificaciones();
                    break;

                case 6:
                    verEstudiantes();
                    break;

                case 7:
                    verProfesores();
                    break;

                case 8:
                    verMaterias();
                    break;

                case 0:
                    System.out.println("\nGracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("\nOpción no válida.");
            }

        } while (opcion != 0);

        entrada.close();
    }


    public static void registrarEstudiante() {

        System.out.println("\n--- REGISTRAR ESTUDIANTE ---");

        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Documento: ");
        String documento = entrada.nextLine();

        System.out.print("Código estudiantil: ");
        String codigo = entrada.nextLine();

        Estudiante estudiante = new Estudiante(nombre, documento, codigo);

        estudiantes.add(estudiante);

        System.out.println("\nEstudiante registrado correctamente.");
    }

   

    public static void registrarProfesor() {

        System.out.println("\n--- REGISTRAR PROFESOR ---");

        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Documento: ");
        String documento = entrada.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = entrada.nextLine();

        Profesor profesor = new Profesor(nombre, documento, especialidad);

        profesores.add(profesor);

        System.out.println("\nProfesor registrado correctamente.");
    }

    

    public static void registrarMateria() {

        if (profesores.isEmpty()) {
            System.out.println("\nPrimero debe registrar un profesor.");
            return;
        }

        System.out.println("\n--- REGISTRAR MATERIA ---");

        System.out.print("Nombre de la materia: ");
        String nombre = entrada.nextLine();

        System.out.println("\nProfesores disponibles:");

        for (int i = 0; i < profesores.size(); i++) {
            System.out.println((i + 1) + ". " + profesores.get(i).getNombre());
        }

        System.out.print("\nSeleccione el profesor: ");
        int posicion = entrada.nextInt();
        entrada.nextLine();

        if (posicion < 1 || posicion > profesores.size()) {
            System.out.println("Profesor no válido.");
            return;
        }

        Profesor profesor = profesores.get(posicion - 1);

        Materia materia = new Materia(nombre, profesor);

        materias.add(materia);

        System.out.println("\nMateria registrada correctamente.");
    }



    public static void calificarEstudiante() {

        if (estudiantes.isEmpty()) {
            System.out.println("\nNo hay estudiantes registrados.");
            return;
        }

        if (profesores.isEmpty()) {
            System.out.println("\nNo hay profesores registrados.");
            return;
        }

        if (materias.isEmpty()) {
            System.out.println("\nNo hay materias registradas.");
            return;
        }

        String continuar;

        do {

            System.out.println("\n--- CALIFICAR ESTUDIANTE ---");

            Profesor profesor = seleccionarProfesor();

            if (profesor != null) {

                Materia materia = seleccionarMateria(profesor);

                if (materia != null) {

                    Estudiante estudiante = seleccionarEstudiante();

                    if (estudiante != null) {

                        System.out.print("\nNota de 1 a 5: ");
                        int nota = entrada.nextInt();
                        entrada.nextLine();

                        if (nota < 1 || nota > 5) {

                            System.out.println("La nota debe estar entre 1 y 5.");

                        } else {

                            System.out.print("Comentario: ");
                            String comentario = entrada.nextLine();

                            Calificacion calificacion =
                                    new Calificacion(profesor, estudiante, materia, nota, comentario);

                            calificaciones.add(calificacion);

                            System.out.println("\nNota registrada correctamente en " +
                                    materia.getNombre() + ".");
                        }
                    }
                }
            }

            System.out.print("\n¿Desea registrar otra nota? (s/n): ");
            continuar = entrada.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }

 
    private static Profesor seleccionarProfesor() {

        System.out.println("\nProfesores:");
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println((i + 1) + ". " + profesores.get(i).getNombre());
        }

        System.out.print("\nSeleccione el profesor: ");
        int pos = entrada.nextInt();
        entrada.nextLine();

        if (pos < 1 || pos > profesores.size()) {
            System.out.println("Profesor no válido.");
            return null;
        }

        return profesores.get(pos - 1);
    }

    private static Materia seleccionarMateria(Profesor profesor) {

        ArrayList<Materia> materiasDelProfesor = new ArrayList<>();

        for (Materia m : materias) {
            if (m.getProfesor() == profesor) {
                materiasDelProfesor.add(m);
            }
        }

        if (materiasDelProfesor.isEmpty()) {
            System.out.println("Este profesor no tiene materias asignadas.");
            return null;
        }

        System.out.println("\nMaterias de " + profesor.getNombre() + ":");
        for (int i = 0; i < materiasDelProfesor.size(); i++) {
            System.out.println((i + 1) + ". " + materiasDelProfesor.get(i).getNombre());
        }

        System.out.print("\nSeleccione la materia: ");
        int pos = entrada.nextInt();
        entrada.nextLine();

        if (pos < 1 || pos > materiasDelProfesor.size()) {
            System.out.println("Materia no válida.");
            return null;
        }

        return materiasDelProfesor.get(pos - 1);
    }

    
    private static Estudiante seleccionarEstudiante() {

        System.out.println("\nEstudiantes:");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre());
        }

        System.out.print("\nSeleccione el estudiante: ");
        int pos = entrada.nextInt();
        entrada.nextLine();

        if (pos < 1 || pos > estudiantes.size()) {
            System.out.println("Estudiante no válido.");
            return null;
        }

        return estudiantes.get(pos - 1);
    }

    
    private static void pausar() {
        System.out.print("\nPresiona ENTER para volver al menú...");
        entrada.nextLine();
    }


    public static void verCalificaciones() {

        System.out.println("\n--- CALIFICACIONES ---");

        if (calificaciones.isEmpty()) {

            System.out.println("No existen calificaciones.");

        } else {

            for (Estudiante estudiante : estudiantes) {

                ArrayList<Calificacion> notasEstudiante = new ArrayList<>();

                for (Calificacion c : calificaciones) {
                    if (c.getEstudiante() == estudiante) {
                        notasEstudiante.add(c);
                    }
                }

                if (!notasEstudiante.isEmpty()) {

                    System.out.println("\nEstudiante: " + estudiante.getNombre());

                    for (Materia materia : materias) {

                        ArrayList<Calificacion> notasMateria = new ArrayList<>();

                        for (Calificacion c : notasEstudiante) {
                            if (c.getMateria() == materia) {
                                notasMateria.add(c);
                            }
                        }

                        if (!notasMateria.isEmpty()) {

                            System.out.println("  " + materia.getNombre() + ":");

                            double suma = 0;

                            for (Calificacion c : notasMateria) {

                                System.out.println("    - Nota: " + c.getNota() +
                                        " | Comentario: " + c.getComentario());

                                suma += c.getNota();
                            }

                            double promedio = suma / notasMateria.size();

                            System.out.printf("    Promedio en %s: %.2f%n", materia.getNombre(), promedio);
                        }
                    }

                    System.out.println("--------------------------------");
                }
            }
        }

        pausar();
    }

    
    public static void verEstudiantes() {

        System.out.println("\n--- ESTUDIANTES ---");

        if (estudiantes.isEmpty()) {

            System.out.println("No hay estudiantes registrados.");

        } else {

            for (Estudiante estudiante : estudiantes) {
                estudiante.mostrarInformacion();
                System.out.println("--------------------------------");
            }
        }

        pausar();
    }

   
    public static void verProfesores() {

        System.out.println("\n--- PROFESORES ---");

        if (profesores.isEmpty()) {

            System.out.println("No hay profesores registrados.");

        } else {

            for (Profesor profesor : profesores) {
                profesor.mostrarInformacion();
                System.out.println("--------------------------------");
            }
        }

        pausar();
    }

 
    public static void verMaterias() {

        System.out.println("\n--- MATERIAS ---");

        if (materias.isEmpty()) {

            System.out.println("No hay materias registradas.");

        } else {

            for (Materia materia : materias) {
                materia.mostrarMateria();
                System.out.println("--------------------------------");
            }
        }

        pausar();
    }
}
