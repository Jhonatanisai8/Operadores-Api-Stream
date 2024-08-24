package org.isai.api.stream.ejemplos.Ejercicios;

import java.util.stream.Stream;

public class EjemploStreamReduceEnteros {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        ejemplo02reduceStream();
    }

    public static void ejemplo01reduceStream() {
        System.out.println("\tOperador distinct");

        /*Ejemplo con el operador reduce mostrando la suma total de los elementos del Stream*/
        Stream<Integer> numeros = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int suma = numeros.reduce(0, (a, b) -> a + b);
        System.out.println("La suma total de los elementos del Stream es: " + suma);
    }

    public static void ejemplo02reduceStream() {
        System.out.println("\tOperador distinct");

        /*Ejemplo con el operador reduce mostrando la suma total de los elementos del Stream*/
        Stream<Integer> numeros = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //otra forma de sumar
        //  int suma = numeros.reduce(0, (a, b) -> Integer.sum(a, b));
        int suma02 = numeros.reduce(0, Integer::sum);

        //  System.out.println("La suma total de los elementos del Stream es: " + suma);
        System.out.println("La suma total es: " + suma02);
    }

}
