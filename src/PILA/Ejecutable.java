package PILA;

import PILA.controler.Controler;
import PILA.model.Model;
import PILA.view.View;

public class Ejecutable {
        public static void main(String[] args) {
            Model modelo = new Model();
            View vista = new View();
            Controler presentador = new Controler(modelo, vista);

            presentador.iniciar();
        }
}
