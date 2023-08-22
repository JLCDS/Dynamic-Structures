package PILA.view;
import java.util.Scanner;
public class View {
        public String obtenerExpresionDelUsuario() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese una expresión matemática: ");
            return scanner.nextLine();
        }

        public void mostrarResultado(double resultado) {
            System.out.println("El resultado es: " + resultado);
        }
}
