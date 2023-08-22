package PRIORITY_QUEUE;

public class Paciente {
        String nombre;
        int gravedad;

        public Paciente(String nombre, int gravedad) {
            this.nombre = nombre;
            this.gravedad = gravedad;
        }

        // Getter para la gravedad
        public int getGravedad() {
            return gravedad;
        }

        @Override
        public String toString() {
            return nombre + " (Gravedad: " + gravedad + ")";
        }
}
