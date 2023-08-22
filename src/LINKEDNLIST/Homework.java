package LINKEDNLIST;

public class Homework {
    String descripcion;
    String fechaVencimiento;
    String asignadoA;

    public Homework(String descripcion, String fechaVencimiento, String asignadoA) {
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.asignadoA = asignadoA;
    }

    @Override
    public String toString() {
        return "Tarea: " + descripcion + ", Fecha de Vencimiento: " + fechaVencimiento + ", Asignado a: " + asignadoA;
    }
}
