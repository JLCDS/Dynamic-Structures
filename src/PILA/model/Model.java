package PILA.model;

import java.util.*;
import java.lang.Math;

public class Model {
    private static int posicion = 0;
    private static String expresion= "";

        public static double evaluarExpresion (String expresion){
            Stack<Double> numeros = new Stack<>();
            Stack<Character> operadores = new Stack<>();

            for (posicion = 0; posicion < expresion.length(); posicion++) {
                char caracter = expresion.charAt(posicion);

                if (Character.isDigit(caracter)) {
                    StringBuilder numero = new StringBuilder();
                    while (posicion < expresion.length() && (Character.isDigit(caracter) || caracter == '.')) {
                        numero.append(caracter);
                        posicion++;
                        if (posicion < expresion.length()) {
                            caracter = expresion.charAt(posicion);
                        }
                    }
                    numeros.push(Double.parseDouble(numero.toString()));
                    posicion--; // Retroceder una posición para manejar el próximo carácter adecuadamente.
                } else if (esOperador(caracter)) {
                    while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(caracter)) {
                        calcularOperacion(numeros, operadores);
                    }
                    operadores.push(caracter);
                } else if (caracter == '(') {
                    operadores.push(caracter);
                } else if (caracter == ')') {
                    while (!operadores.isEmpty() && operadores.peek() != '(') {
                        calcularOperacion(numeros, operadores);
                    }
                    if (!operadores.isEmpty() && operadores.peek() == '(') {
                        operadores.pop(); // Eliminar el paréntesis de apertura correspondiente.
                    } else {
                        throw new IllegalArgumentException("Expresión incorrecta: paréntesis desequilibrados.");
                    }
                } else if (Character.isLetter(caracter)) {
                    StringBuilder funcion = new StringBuilder();
                    while (Character.isLetter(caracter)) {
                        funcion.append(caracter);
                        posicion++;
                        if (posicion < expresion.length()) {
                            caracter = expresion.charAt(posicion);
                        }
                    }

                    String funcionLowerCase = funcion.toString().toLowerCase(); // Convertir a minúsculas

                    if (esFuncion(funcionLowerCase)) {
                        if (caracter == '(') {
                            int inicioArgumento = posicion + 1;
                            int finArgumento = encontrarFinArgumento(expresion);
                            if (finArgumento != -1) {
                                String argumento = expresion.substring(inicioArgumento, finArgumento);
                                double valor = evaluarExpresion(expresion);

                                double resultadoFuncion = 0.0;

                                // Evaluar todas las funciones trigonométricas
                                switch (funcionLowerCase) {
                                    case "sin":
                                        resultadoFuncion = Math.sin(Math.toRadians(valor));
                                        break;
                                    case "cos":
                                        resultadoFuncion = Math.cos(Math.toRadians(valor));
                                        break;
                                    case "tan":
                                        resultadoFuncion = Math.tan(Math.toRadians(valor));
                                        break;
                                    case "cot":
                                        resultadoFuncion = 1.0 / Math.tan(Math.toRadians(valor));
                                        break;
                                    case "sec":
                                        resultadoFuncion = 1.0 / Math.cos(Math.toRadians(valor));
                                        break;
                                    case "csc":
                                        resultadoFuncion = 1.0 / Math.sin(Math.toRadians(valor));
                                        break;
                                }

                                numeros.push(resultadoFuncion);
                                posicion = finArgumento;
                            } else {
                                throw new IllegalArgumentException("Expresión incorrecta: argumento de función incompleto.");
                            }
                        } else {
                            throw new IllegalArgumentException("Expresión incorrecta: falta paréntesis después de la función.");
                        }
                    } else {
                        throw new IllegalArgumentException("Función no reconocida: " + funcion.toString());
                    }
                } else if (caracter == ' ') {
                    // Ignorar espacios en blanco.
                } else {
                    throw new IllegalArgumentException("Carácter no reconocido: " + caracter);
                }
            }

            while (!operadores.isEmpty()) {
                calcularOperacion(numeros, operadores);
            }

            if (numeros.size() == 1 && operadores.isEmpty()) {
                return numeros.pop();
            } else {
                throw new IllegalArgumentException("Expresión incorrecta: no se pudo evaluar completamente.");
            }
        }

    public static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0; // Para otros caracteres, como paréntesis.
        }
    }
    public static int encontrarFinArgumento(String expresion) {
        int contadorParentesis = 0;
        for (int i = posicion + 1; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (c == '(') {
                contadorParentesis++;
            } else if (c == ')') {
                if (contadorParentesis == 0) {
                    return i;
                }
                contadorParentesis--;
            }
        }
        return -1;
    }
    public static boolean esFuncion(String funcion) {
        String funcionLowerCase = funcion.toLowerCase();
        return funcionLowerCase.equals("sin") || funcionLowerCase.equals("cos") || funcionLowerCase.equals("tan")
                || funcionLowerCase.equals("cot") || funcionLowerCase.equals("sec") || funcionLowerCase.equals("csc");
    }
    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void calcularOperacion(Stack<Double> numeros, Stack<Character> operadores) {
        if (numeros.size() < 2 || operadores.isEmpty()) {
            throw new IllegalArgumentException("Expresión incorrecta: no se pueden calcular operaciones.");
        }
        double b = numeros.pop();
        double a = numeros.pop();
        char operador = operadores.pop();
        double resultado;
        switch (operador) {
            case '+':
                resultado = a + b;
                break;
            case '-':
                resultado = a - b;
                break;
            case '*':
                resultado = a * b;
                break;
            case '/':
                resultado = a / b;
                break;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
        numeros.push(resultado);
    }

}
