package PILA.controler;

import PILA.model.Model;
import PILA.view.View;

public class Controler {
        private Model modelo;
        private View vista;

        public Controler(Model modelo, View vista) {
            this.modelo = modelo;
            this.vista = vista;
        }
        public void iniciar() {
            String expresion = vista.obtenerExpresionDelUsuario();
            try {
                double resultado = modelo.evaluarExpresion(expresion);
                vista.mostrarResultado(resultado);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
}
