package org.isai.api.stream.ejemplos;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.isai.api.stream.ejemplos.models.Usuario;

/*

El operador filter en Streams de Java es una operación intermedia
que se utiliza para filtrar elementos de un Stream basado en una
condición especificada. Es una de las herramientas más comunes y 
poderosas cuando se trabaja con Streams, permitiendo que solo los
elementos que cumplan con un determinado criterio pasen a la 
siguiente etapa del procesamiento.
 */
public class EjemploStreamFilterSingle {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        ejemplo01FiltrerStream();
    }

    public static void ejemplo01FiltrerStream() {

        System.out.println("\tOperador Filter con Objetos");
        /*
        1- creacion del Stream
        2- Transformacion del Stream map
        3- filtrado con filter cuyo nombre es pepe:
        4- Inspección con peek.
        5- Operación Terminal findFirst: findFirst es una operación 
        terminal que devuelve un Optional<Usuario> con el primer
        elemento del Stream que cumple con las condiciones anteriores.
        6- Salida del Resultado.
        
         */
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
        System.out.println(usuario.get());
    }
}
