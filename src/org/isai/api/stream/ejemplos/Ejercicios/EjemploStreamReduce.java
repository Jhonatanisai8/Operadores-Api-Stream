package org.isai.api.stream.ejemplos.Ejercicios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamDistinct {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        //ejemplo01distinctStream();
        //ejemplo02distinctStream();
        //ejemplo03List();
        ejemplo04ListInteger();
    }

    public static void ejemplo01distinctStream() {

        System.out.println("\tOperador distinct");

        /*todo lo que esta repetido lo agrupa y muestra uno solo */
        Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia",
                        "Paco Gonzales",
                        "Paco Gonzales",
                        "Paco Gonzales",
                        "Pepe Mena")
                .distinct()
                .forEach(System.out::println);

    }

    public static void ejemplo02distinctStream() {
        System.out.println("\tOperador distinct");

        /*todo lo que esta repetido lo agrupa y muestra uno solo */
        Stream<String> nombres = Stream.of("Pato Guzman",
                "Paco Gonzales",
                "Pepa Gutierrez",
                "Pepe Mena",
                "Pepe Garcia",
                "Paco Gonzales",
                "Paco Gonzales",
                "Paco Gonzales")
                .distinct();
        nombres.forEach(System.out::println);

    }

    public static void ejemplo03List() {
        System.out.println("\tEjemplo distinct Lista");
        List<String> nombres = Arrays.asList("uno", "dos", "tres", "cuatro", "dos", "dos", "dos", "dos", "dos");
        // Usar distinct() para eliminar duplicados
        List<String> nombresDistintos = nombres.stream().distinct().collect(Collectors.toList());
        nombresDistintos.forEach(System.out::println);
    }

    public static void ejemplo04ListInteger() {
        System.out.println("\tEjemplo distinct Lista Enteros");
        List<Integer> nombres = Arrays.asList(1, 45, 56, 7, 3, 1, 2, 3, 45, 76, 54, 34, 56);
        System.out.println("Lista con duplicados: ");
        nombres.forEach(System.out::println);
        // Usar distinct() para eliminar duplicados
        List<Integer> nombresDistintos = nombres.stream().distinct().collect(Collectors.toList());
        System.out.println("Lista sin duplicados: ");
        nombresDistintos.forEach(System.out::println);
    }

}
