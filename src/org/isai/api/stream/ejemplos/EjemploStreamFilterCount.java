package org.isai.api.stream.ejemplos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.isai.api.stream.ejemplos.models.Usuario;

/*
El operador count en Streams de Java es una operación terminal 
que se utiliza para contar el número de elementos en el Stream.
Es útil cuando necesitas saber cuántos elementos hay en un Stream 
después de aplicar una serie de operaciones intermedias, como 
filtrado, mapeo, etc.
 */
public class EjemploStreamFilterCount {

    public static void main(String[] args) {
        System.out.println("\n\tHola Stream");
        ejemplo06CountList();
    }

    public static void ejemplo04count() {

        System.out.println("\tEJEMPLO ANY MATCH");

        long cantidad = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))/*opcional*/
                .peek(System.out::println)/*opcional*/
                .count();
        System.out.println("CANTIDAD DE ELEMENTOS: " + cantidad);

    }

    public static void ejemplo05Countlista() {

        System.out.println("\n\tEJEMPLO COUNT CON LISTA");
        List<Usuario> listaUsuarios = Arrays.asList(
                new Usuario("Pato", "Guzman"),
                new Usuario("Paco", "Gonsales"),
                new Usuario("Pepa", "Gutierrez"),
                new Usuario("Pepe", "Mena"),
                new Usuario("Pepe", "Garcia"));

        //uso del count
        long cantidad = listaUsuarios.stream().count();
        System.out.println("CANTIDAD DE ELEMENTOS DE LA LISTA " + cantidad);

    }

    public static void ejemplo06CountList() {

        int numero = 5;
        long cantidad = Stream.of(1, 4, 5, 6, 7, 34, 56, 78, 90)
                .filter(n -> n > 5)
                .count();
        System.out.println("ELEMENTOS TOTALES MAYORES A " + numero + ": " + cantidad);
    }
}
