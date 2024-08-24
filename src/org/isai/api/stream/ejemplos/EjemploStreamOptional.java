package org.isai.api.stream.ejemplos;

import java.util.Optional;
import java.util.stream.Stream;
import org.isai.api.stream.ejemplos.models.Usuario;

public class EjemploStreamOptional {

    public static void main(String[] args) {

        System.out.println("\tHola Stream");
        //ejemplo01Optional();
        //ejemplo02OptionalExpresionLambda();
        //ejemplo03OptionalExpresionLambda();
        ejemplo05Optional();
    }

    public static void ejemplo01Optional() {

        System.out.println("\tUso del Optional");

        Stream<Usuario> nombres = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepeds"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();
        System.out.println(usuario.orElse(new Usuario("Jhon", "Doe")).getNombre());
        /*System.out.println(usuario.orElse(new Usuario("Jhon", "Doe")));*/

    }

    public static void ejemplo02OptionalExpresionLambda() {

        System.out.println("\tUso del Optional");

        Stream<Usuario> nombres = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("PepeZ"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();

        System.out.println(usuario.orElseGet(() -> new Usuario("John", "Doe")).getNombre());

    }

    public static void ejemplo03OptionalExpresionLambda() {

        System.out.println("\tUso del Optional");

        Stream<Usuario> nombres = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("PepeZ"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();

        //lanzar una excepcion
        System.out.println(usuario.orElseThrow());
    }

    public static void ejemplo05Optional() {

        System.out.println("\tUso del Optional");

        Stream<Usuario> nombres = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();

        //si esta presente lo mostramos
        if (usuario.isPresent()) {
            System.out.println("Resultado: "+usuario.get().getNombre());
        } else {
            System.out.println("No se encontro el objeto.");
        }
    }
}
