package org.isai.api.stream.ejemplos.Ejercicios;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.isai.api.stream.ejemplos.models.Usuario;

public class EjemploStreamDistinctUsuarioSum {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        ejemplo01DistinSumcStream();
        ejemplo02DistincStream();
        ejemplo03Distinct();
    }

    public static void ejemplo01DistinSumcStream() {
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
        muestra la cantidad de caracteres que tiene el nombre de cada usuario
         */
        System.out.println("\tOperador Filter con Objetos");
        IntStream largoNombres = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia",
                        "Pato Guzman",
                        "Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt((u) -> u.toString().length())
                .peek(System.out::println);

        IntSummaryStatistics estasd = largoNombres.summaryStatistics();

        System.out.println("=Datos=");
        System.out.println("Total de elementos: " + estasd.getCount());
        System.out.println("Nombre mas largo:  " + estasd.getMax());
        System.out.println("Nombre menos  Largo:  " + estasd.getMin());
        System.out.println("Suma total:  " + estasd.getSum());
        System.out.println("Promedio:  " + estasd.getAverage());

    }

    public static void ejemplo03Distinct() {
        System.out.println("\tEjemplo Stream de Enteros");
        Stream<String> nombres = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia",
                        "Pato Guzman",
                        "Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .map((t) -> "Caracteres: " + t.toString().length());
        
        nombres.forEach(System.out::println);

    }
}
