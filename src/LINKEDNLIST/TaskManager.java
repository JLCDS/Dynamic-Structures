package LINKEDNLIST;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskManager {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            LinkedList<Homework> listaTareas = new LinkedList<>();

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Agregar tarea");
                System.out.println("2. Ver tareas asignadas a un usuario");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese la descripción de la tarea: ");
                        String descripcion = scanner.nextLine();
                        System.out.print("Ingrese la fecha de vencimiento: ");
                        String fechaVencimiento = scanner.nextLine();
                        System.out.print("Ingrese el nombre del usuario asignado: ");
                        String asignadoA = scanner.nextLine();
                        listaTareas.add(new Homework(descripcion, fechaVencimiento, asignadoA));
                        break;
                    case 2:
                        System.out.print("Ingrese el nombre del usuario para ver sus tareas: ");
                        String usuario = scanner.nextLine();
                        verTareasAsignadas(listaTareas, usuario);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }

        public static void verTareasAsignadas(LinkedList<Homework> listaTareas, String usuario) {
            System.out.println("Tareas asignadas a " + usuario + ":");
            for (Homework homework : listaTareas) {
                if (homework.asignadoA.equalsIgnoreCase(usuario)) {
                    System.out.println(homework);
                }
            }
        }
}