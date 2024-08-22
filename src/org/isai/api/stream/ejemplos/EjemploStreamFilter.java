package org.isai.api.stream.ejemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.isai.api.stream.ejemplos.models.Usuario;

/*

El operador map en la API de Streams de Java se utiliza para transformar
los elementos de un flujo (Stream) de datos. Es una operación intermedia 
que aplica una función a cada elemento del flujo, produciendo un nuevo flujo
con los resultados de esas transformaciones.
 */
public class EjemploStreamFilter {
    
    public static void main(String[] args) {
        
        System.out.println("\n\tHola Stream");
        ejemplo03MapStreamApellido();
    }
    
    public static void ejemplo03MapStreamApellido() {
        
        System.out.println("\tOperador map y peek con Objetos");
        //creamos un Stream de tipo String
        //en este ejemplo convierte todos los elementos que hay a Mayusculas
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
        System.out.println("\tApellidos");
    }
}
