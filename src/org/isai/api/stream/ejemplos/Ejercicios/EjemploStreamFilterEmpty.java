package org.isai.api.stream.ejemplos.Ejercicios;

import java.util.stream.Stream;

public class EjemploStreamFilterEmpty {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        ejemplo01FiltrerStream();
    }

    public static void ejemplo01FiltrerStream() {

        System.out.println("\tOperador Filter con Objetos");
        
        /*filtramos todos los objetos vacios y mostramos su cantidad*/
        long count = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "",
                        "Pepe Mena",
                        "")
                .filter(String::isEmpty)
                .peek(System.out::println)
                .count();
        System.out.println("Cantidad de objetos vacios: "+count);

    }
}
