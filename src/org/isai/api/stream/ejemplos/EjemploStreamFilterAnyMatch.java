package org.isai.api.stream.ejemplos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.isai.api.stream.ejemplos.models.Usuario;

/*
El operador anyMatch en Streams de Java es una operación terminal
que se utiliza para verificar si algún elemento del Stream cumple
con una condición dada. Es muy útil cuando quieres saber si existe
al menos un elemento en el Stream que satisfaga un predicado sin 
necesidad de procesar todos los elementos si ya has encontrado 
uno que cumple la condición.
 */
public class EjemploStreamFilterAnyMatch {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        ejemplo05AnyMatchlista();
    }

    public static void ejemplo04AnyMatch() {

        /*
        1. Creación del Stream.
        2. Transforma cada cadena de texto en un objeto Usuario.
        3. peek(System.out::println):
            Este operador es opcional y permite "espiar" cada objeto Usuario creado. Imprime cada usuario en la consola.
        4.anyMatch(u -> u.getId().equals(idBuscar)):
            Verifica si algún objeto Usuario en el Stream tiene un id igual a idBuscar (en este caso, 3).
            Devuelve true si encuentra al menos un usuario con el id buscado, o false si no lo encuentra. 
        5. Imprime el resultado.
        */
        
        System.out.println("\tEJEMPLO ANY MATCH");
        int idBuscar = 3;
        
        boolean existe = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))/*opcional*/
                .peek(System.out::println)/*opcional*/
                .anyMatch(u -> u.getId().equals(idBuscar));

        System.out.println("¿Existe usuario con id " + idBuscar + ": " + existe);
    }

    public static void ejemplo05AnyMatchlista() {

        System.out.println("\n\tEJEMPLO BUSCAR ID CON LISTA");
        List<Usuario> listaUsuarios = Arrays.asList(
                new Usuario("Pato", "Guzman"),
                new Usuario("Paco", "Gonsales"),
                new Usuario("Pepa", "Gutierrez"),
                new Usuario("Pepe", "Mena"),
                new Usuario("Pepe", "Garcia"));

        boolean encontrado = false;
        int idBuscar = 3;
        for (Usuario u : listaUsuarios) {
            if (u.getId().equals(idBuscar)) {
                encontrado = true;
                break;
            }
        }

        System.out.println("¿Existe usuario con id " + idBuscar + ":? " + encontrado);

    }
}
