package org.isai.api.stream.ejemplos.Ejercicios;

import java.util.stream.Stream;
import org.isai.api.stream.ejemplos.models.Usuario;

public class EjemploStreamDistinctUsuario {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        ejemplo01DistincStream();
        ejemplo02DistincStream();
    }

    public static void ejemplo01DistincStream() {
        /*
        para el ejemplo agrupa los repetidos y solo muestra uno
         */
        System.out.println("\tOperador Filter con Objetos");
        Stream<Usuario> nombres = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia",
                        "Pato Guzman",
                        "Pato Guzman").
                distinct()
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]));
        nombres.forEach(System.out::println);
    }

    public static void ejemplo02DistincStream() {
        /*
        para el ejemplo agrupa los repetidos y solo muestra uno
         */
        System.out.println("\tOperador Filter con Objetos");
        Stream<Usuario> nombres = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia",
                        "Pato Guzman",
                        "Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct();
        nombres.forEach(System.out::println);
    }
}
