package HASH_SET.view;
import java.util.*;

public class View {

        public void mostrarConjuntoPotencia(Set<Set<Integer>> conjuntoPotencia) {
            for (Set<Integer> subset : conjuntoPotencia) {
                System.out.println(subset);
            }
        }
        public Set<Integer> obtenerEntradaUsuario() {
            Scanner scanner = new Scanner(System.in);
            Set<Integer> conjuntoEntrada = new HashSet<>();

            System.out.print("Ingrese un número (o ingrese cualquier letra para terminar): ");
            while (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                conjuntoEntrada.add(numero);

                System.out.print("Ingrese otro número (o ingrese cualquier letra para terminar): ");
            }

            return conjuntoEntrada;
        }
}
