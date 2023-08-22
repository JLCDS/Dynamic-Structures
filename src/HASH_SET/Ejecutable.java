package HASH_SET;

import HASH_SET.controller.Controller;
import HASH_SET.model.Model;
import HASH_SET.view.View;

public class Ejecutable {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.ejecutar();
    }
}
