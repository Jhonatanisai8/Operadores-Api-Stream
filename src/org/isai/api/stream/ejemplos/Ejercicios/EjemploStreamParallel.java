package org.isai.api.stream.ejemplos.Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.isai.api.stream.ejemplos.models.Usuario;

public class EjemploStreamParallel {

    public static void main(String[] args) {
        System.out.println("\tHOLA STREAM");
        ejemplo06Parallel();
    }

    public static void ejemplo01() {

        //creamos una lista de tipo Usuario
        List<Usuario> listaUsuarios = new ArrayList<>();

        listaUsuarios.add(new Usuario("Andrez", "Guzman"));
        listaUsuarios.add(new Usuario("Luci", "Martinez"));
        listaUsuarios.add(new Usuario("Pepe", "Fernandez"));
        listaUsuarios.add(new Usuario("Cata", "Perez"));
        listaUsuarios.add(new Usuario("Lalo", "Mena"));
        listaUsuarios.add(new Usuario("Exequiel", "Doe"));

        //creamos la lista a un stream de tipo usuario
        listaUsuarios.stream()
                .map(u
                        -> u.getNombre().toUpperCase()
                        .concat(" ")
                        .concat(u.getApellido().toUpperCase())
                )
                .forEach(System.out::println);

    }

    public static void ejemplo02() {

        //creamos una lista de tipo Usuario
        List<Usuario> listaUsuarios = new ArrayList<>();

        listaUsuarios.add(new Usuario("Andrez", "Guzman"));
        listaUsuarios.add(new Usuario("Luci", "Martinez"));
        listaUsuarios.add(new Usuario("Pepe", "Fernandez"));
        listaUsuarios.add(new Usuario("Cata", "Perez"));
        listaUsuarios.add(new Usuario("Lalo", "Mena"));
        listaUsuarios.add(new Usuario("Exequiel", "Doe"));
        listaUsuarios.add(new Usuario("Bruce", "Lee"));
        listaUsuarios.add(new Usuario("Bruce", "wills"));

        /*
        Si el nombre completo (en mayúsculas) contiene la cadena
        "BRUCE" (independientemente de las mayúsculas/minúsculas 
        gracias a toUpperCase()), se retorna un Stream que contiene 
        nombre.
        Si el nombre no contiene "BRUCE", se retorna un Stream.empty(), es decir, 
        un Stream vacío.
         */
        listaUsuarios.stream()
                .map(u
                        -> u.getNombre().toUpperCase()
                        .concat(" ")
                        .concat(u.getApellido().toUpperCase())
                ).flatMap(nombre -> {
                    if (nombre.contains("bruce".toUpperCase())) {
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .map(String::toLowerCase)
                .forEach(System.out::println);

    }

    public static void ejemplo03() {
        //creamos una lista de tipo Usuario
        List<Usuario> listaUsuarios = new ArrayList<>();

        listaUsuarios.add(new Usuario("Andrez", "Guzman"));
        listaUsuarios.add(new Usuario("Luci", "Martinez"));
        listaUsuarios.add(new Usuario("Pepe", "Fernandez"));
        listaUsuarios.add(new Usuario("Cata", "Perez"));
        listaUsuarios.add(new Usuario("Lalo", "Mena"));
        listaUsuarios.add(new Usuario("Exequiel", "Doe"));
        listaUsuarios.add(new Usuario("Bruce", "Lee"));
        listaUsuarios.add(new Usuario("Bruce", "wills"));

        long t1 = System.currentTimeMillis();

        String streamListaUsuarios = listaUsuarios.stream()
                .map(u
                        -> u.getNombre().toUpperCase()
                        .concat(" ")
                        .concat(u.getApellido().toUpperCase())
                ).flatMap(nombre -> {
                    if (nombre.contains("bruce".toUpperCase())) {
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");

        long t2 = System.currentTimeMillis();

        System.out.println("Tiempo Total: " + (t2 - t1));
        System.out.println(streamListaUsuarios);
    }

    public static void ejemplo04() {
        //creamos una lista de tipo Usuario
        List<Usuario> listaUsuarios = new ArrayList<>();

        listaUsuarios.add(new Usuario("Andrez", "Guzman"));
        listaUsuarios.add(new Usuario("Luci", "Martinez"));
        listaUsuarios.add(new Usuario("Pepe", "Fernandez"));
        listaUsuarios.add(new Usuario("Cata", "Perez"));
        listaUsuarios.add(new Usuario("Lalo", "Mena"));
        listaUsuarios.add(new Usuario("Exequiel", "Doe"));
        listaUsuarios.add(new Usuario("Bruce", "Lee"));
        listaUsuarios.add(new Usuario("Bruce", "wills"));

        long t1 = System.currentTimeMillis();

        String resultado = listaUsuarios.stream()
                .map(u -> u.toString().toUpperCase()
                ).flatMap(nombre -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    if (nombre.contains("bruce".toUpperCase())) {
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");

        long t2 = System.currentTimeMillis();

        System.out.println("Tiempo Total: " + (t2 - t1));
        System.out.println(resultado);
    }

    public static void ejemplo05Parallel() {
        //creamos una lista de tipo Usuario
        List<Usuario> listaUsuarios = new ArrayList<>();

        listaUsuarios.add(new Usuario("Andrez", "Guzman"));
        listaUsuarios.add(new Usuario("Luci", "Martinez"));
        listaUsuarios.add(new Usuario("Pepe", "Fernandez"));
        listaUsuarios.add(new Usuario("Cata", "Perez"));
        listaUsuarios.add(new Usuario("Lalo", "Mena"));
        listaUsuarios.add(new Usuario("Exequiel", "Doe"));
        listaUsuarios.add(new Usuario("Bruce", "Lee"));
        listaUsuarios.add(new Usuario("Bruce", "wills"));

        long t1 = System.currentTimeMillis();

        String resultado = listaUsuarios.stream()
                .parallel()
                .map(u -> u.toString().toUpperCase())
                //opcional para mostrar
                .peek(System.out::println)
                .flatMap(nombre -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    if (nombre.contains("bruce".toUpperCase())) {
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");

        long t2 = System.currentTimeMillis();

        System.out.println("Tiempo Total: " + (t2 - t1));
        System.out.println(resultado);
    }

    public static void ejemplo06Parallel() {
        //creamos una lista de tipo Usuario
        List<Usuario> listaUsuarios = new ArrayList<>();

        listaUsuarios.add(new Usuario("Andrez", "Guzman"));
        listaUsuarios.add(new Usuario("Luci", "Martinez"));
        listaUsuarios.add(new Usuario("Pepe", "Fernandez"));
        listaUsuarios.add(new Usuario("Cata", "Perez"));
        listaUsuarios.add(new Usuario("Lalo", "Mena"));
        listaUsuarios.add(new Usuario("Exequiel", "Doe"));
        listaUsuarios.add(new Usuario("Bruce", "Lee"));
        listaUsuarios.add(new Usuario("Bruce", "wills"));

        long t1 = System.currentTimeMillis();

        String resultado = listaUsuarios.stream()
               // .parallel()
                .map(u -> u.toString().toUpperCase())
                //opcional para mostrar
                .peek(
                        (t) -> {
                            System.out.println("Nombre Thread: " + Thread.currentThread().getName() + " - " + t);
                        }
                )
                .flatMap(nombre -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    if (nombre.contains("bruce".toUpperCase())) {
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");

        long t2 = System.currentTimeMillis();

        System.out.println("Tiempo Total: " + (t2 - t1));
        System.out.println(resultado);
    }
}
