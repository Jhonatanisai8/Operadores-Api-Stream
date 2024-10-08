package org.isai.api.stream.ejemplos;

import java.util.List;
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
public class EjemploStreamFilter {
    
    public static void main(String[] args) {
        
        System.out.println("\n\tHola Stream");
        ejemplo03MapStreamApellido();
    }
    
    public static void ejemplo03MapStreamApellido() {
        
        System.out.println("\tOperador map y peek con Objetos");
        //creamos un Stream de tipo String
        
        /*
        en este ejemplo filtra los usuario por nombre pepe
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
        
        List<Usuario> listaNombre = nombres.collect(Collectors.toList());
        listaNombre.forEach(System.out::println);
    }
}
