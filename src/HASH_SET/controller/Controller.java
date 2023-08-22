package HASH_SET.controller;

import HASH_SET.model.Model;
import HASH_SET.view.View;

import java.util.Set;
public class Controller {
        private Model model;
        private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void ejecutar() {
            Set<Integer> conjuntoEntrada = view.obtenerEntradaUsuario();
            Set<Set<Integer>> conjuntoPotencia = model.generarConjuntoPotencia(conjuntoEntrada);
            view.mostrarConjuntoPotencia(conjuntoPotencia);
        }
}
