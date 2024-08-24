package org.isai.api.stream.ejemplos.Ejercicios;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamReduce {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        ejemplo04ListInteger();
    }

    public static void ejemplo01reduceStream() {
        System.out.println("\tOperador distinct");

        /*en este ejemplo el reduce agrupa en una sola linea todos los elementos que hay en el stream*/
        Stream<String> nombres = Stream.of("Pato Guzman",
                "Paco Gonzales",
                "Pepa Gutierrez",
                "Pepe Mena",
                "Pepe Garcia",
                "Paco Gonzales",
                "Paco Gonzales",
                "Paco Gonzales")
                .distinct();

        String resultado = nombres.reduce("Resultado: ", (a, b) -> a + ", " + b);
        System.out.println(resultado);
    }

    public static void ejemplo03List() {
        System.out.println("\tEjemplo distinct Lista");
        List<String> nombres = Arrays.asList("uno", "dos", "tres", "cuatro", "dos", "dos", "dos", "dos", "dos");
        // Usar distinct() para eliminar duplicados
        String nombresReduce = nombres.stream().reduce("Numeros: ", (t, u) -> t + " -" + u);
        System.out.println(nombresReduce);
    }

    public static void ejemplo04ListInteger() {
        System.out.println("\tEjemplo distinct Lista Enteros");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Usar reduce() para sumar los números
        int sum = numbers.stream()
                .reduce(0, (subtotal, element) -> subtotal + element);

        System.out.println("Suma: " + sum); // Salida: Suma: 15
    }

    public static void ejemplo05ListInteger() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Usar reduce() para multiplicar todos los números
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("Producto: " + product); // Salida: Producto: 120
    }

    public static void ejemplo06() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Usar reduce() para encontrar el valor máximo
        /* Un Optional es una clase contenedora que puede 
        o no contener un valor (es útil para evitar NullPointerException).*/
        Optional<Integer> max = numbers.stream()
                .reduce((a, b) -> a > b ? a : b);

        max.ifPresent(value -> System.out.println("Máximo: " + value)); // Salida: Máximo: 5

    }
}
