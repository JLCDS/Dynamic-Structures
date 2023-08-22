package PRIORITY_QUEUE;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Medico {
    public static void main(String[] args) {
        PriorityQueue<Paciente> colaDeTurnos = new PriorityQueue<>(Comparator.comparingInt(Paciente::getGravedad));

        colaDeTurnos.add(new Paciente("Juan", 1));
        colaDeTurnos.add(new Paciente("Tatiana", 5));
        colaDeTurnos.add(new Paciente("Nicolas", 3));
        colaDeTurnos.add(new Paciente("Camilo", 2));

        while (!colaDeTurnos.isEmpty()) {
            Paciente pacienteActual = colaDeTurnos.poll();
            System.out.println("Atendiendo a " + pacienteActual);
        }
    }
}
