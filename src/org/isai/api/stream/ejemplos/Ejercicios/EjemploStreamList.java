package org.isai.api.stream.ejemplos.Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.isai.api.stream.ejemplos.models.Usuario;

public class EjemploStreamList {

    public static void main(String[] args) {
        System.out.println("\tHOLA STREAM");
        ejemplo03();
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

        /*
        Si el nombre completo (en mayúsculas) contiene la cadena
        "BRUCE" (independientemente de las mayúsculas/minúsculas 
        gracias a toUpperCase()), se retorna un Stream que contiene 
        nombre.
        Si el nombre no contiene "BRUCE", se retorna un Stream.empty(), es decir, 
        un Stream vacío.
        
        Al final mostramos la cantidad de elementos  que hay en el Stream
         */
        Stream<String> streamListaUsuarios = listaUsuarios.stream()
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
                .peek(System.out::println);
        
        System.out.println("Cantidad de elementos: "+streamListaUsuarios.count());

    }
}
