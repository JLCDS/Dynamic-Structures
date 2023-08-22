package VECTOR;
import java.util.Scanner;
import java.util.Vector;

public class CCompras {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Vector<Articulo> carrito = new Vector<>();

            while (true) {
                System.out.println("Menú:");
                System.out.println("1. Agregar artículo al carrito");
                System.out.println("2. Mostrar contenido del carrito");
                System.out.println("3. Calcular precio total");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del artículo: ");
                        String nombre = scanner.next();
                        System.out.print("Ingrese el precio del artículo: ");
                        double precio = scanner.nextDouble();
                        carrito.add(new Articulo(nombre, precio));
                        break;
                    case 2:
                        mostrarContenido(carrito);
                        break;
                    case 3:
                        calcularPrecioTotal(carrito);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }

        public static void mostrarContenido(Vector<Articulo> carrito) {
            if (carrito.isEmpty()) {
                System.out.println("El carrito está vacío.");
            } else {
                System.out.println("Contenido del carrito:");
                for (Articulo articulo : carrito) {
                    System.out.println(articulo.nombre + " - Precio: $" + articulo.precio);
                }
            }
        }

        public static void calcularPrecioTotal(Vector<Articulo> carrito) {
            double precioTotal = 0.0;
            for (Articulo articulo : carrito) {
                precioTotal += articulo.precio;
            }
            System.out.println("Precio total del carrito: $" + precioTotal);
        }
}
