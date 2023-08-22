package HASH_SET.model;

import java.util.HashSet;
import java.util.Set;

public class Model {
    public Set<Set<Integer>> generarConjuntoPotencia(Set<Integer> conjuntoEntrada) {
        Set<Set<Integer>> conjuntoPotencia = new HashSet<>();
        conjuntoPotencia.add(new HashSet<>()); // Agrega el conjunto vacío

        for (Integer elemento : conjuntoEntrada) {
            Set<Set<Integer>> nuevosSubconjuntos = new HashSet<>();

            for (Set<Integer> conjunto : conjuntoPotencia) {
                Set<Integer> nuevoSubconjunto = new HashSet<>(conjunto);
                nuevoSubconjunto.add(elemento);
                nuevosSubconjuntos.add(nuevoSubconjunto);
            }

            conjuntoPotencia.addAll(nuevosSubconjuntos);
        }

        return conjuntoPotencia;
    }
}