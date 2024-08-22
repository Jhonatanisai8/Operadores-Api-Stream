package org.isai.api.stream.ejemplos;

import java.util.NoSuchElementException;
import java.util.Optional;
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
public class EjemploStreamFilterSingle2 {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        ejemplo01FiltrerStream();
    }

    public static void ejemplo01FiltrerStream() {

        System.out.println("\tOperador Filter con Objetos");
        /*
        1. Definición del idBuscar:
        2. Creación del Stream:
        3. findFirst():
            Busca el primer Usuario que cumpla con el criterio especificado por el filter.
        4. get():
            Extrae el valor del Optional si está presente. Si no hay ningún usuario que coincida, 
            lanzará una excepción NoSuchElementException.
         */
        try {
            int idBuscar = 120;
            Usuario usuario = Stream.
                    of("Pato Guzman",
                            "Paco Gonzales",
                            "Pepa Gutierrez",
                            "Pepe Mena",
                            "Pepe Garcia")
                    .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                    .filter(u -> u.getId().equals(idBuscar))
                    .findFirst().get();
            System.out.println(usuario);
        } catch (NoSuchElementException e) {
            System.out.println("No se pudo encontrar");
        }

    }
}
