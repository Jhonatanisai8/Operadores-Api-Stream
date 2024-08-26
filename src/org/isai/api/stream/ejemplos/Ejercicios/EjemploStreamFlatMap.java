package org.isai.api.stream.ejemplos.Ejercicios;

/*
El operador flatMap en los Streams de Java es una operación 
intermedia que se utiliza para transformar cada elemento de un
Stream en otro Stream y luego aplanar esos Streams en un único 
Stream. A diferencia de map, que aplica una función a cada elemento
del Stream y devuelve un Stream con el mismo número de elementos,
flatMap permite que cada elemento original se transforme en un
número arbitrario de elementos, incluidos cero.
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.isai.api.stream.ejemplos.models.Usuario;

public class EjemploStreamFlatMap {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        ejemplo03FlatMapStreamApellido();
        ejemplo02ListasFlatMap();
    }

    public static void ejemplo03FlatMapStreamApellido() {
        /*
        Imprimirá el mensaje "Operador flatMap con Objetos".
Creará un Stream de objetos Usuario a partir de los nombres completos.
Filtrará para incluir solo los usuarios cuyo nombre sea "Pepe".
Imprimirá los objetos Usuario que pasan el filtro.
Contará e imprimirá cuántos usuarios con el nombre "Pepe" existen en la lista.
         */
        System.out.println("\tOperador flatMap con Objetos");

        Stream<Usuario> nombres = Stream.
                of("Pato Guzman",
                        "Paco Gonzales",
                        "Pepa Gutierrez",
                        "Pepe Mena",
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .flatMap((t) -> {
                    if (t.getNombre().equalsIgnoreCase("Pepe")) {
                        return Stream.of(t);
                    }
                    return Stream.empty();
                })
                .peek(System.out::println);
        /*
        En resumen, solo los objetos Usuario cuyo nombre es "Pepe" pasarán al siguiente paso en el Stream.
         */
        //nombres.forEach(System.out::println);
        System.out.println("Cantidad de elementos: " + nombres.count());

    }

    public static void ejemplo02ListasFlatMap() {

        /*
        En este ejemplo, flatMap toma cada lista dentro de 
        listOfLists y la convierte en un Stream, luego aplanando 
        estos Streams en un único Stream de palabras individuales. 
        Finalmente, las palabras se recopilan en una lista.
         */
        List<List<String>> listaPalabaras = Arrays.asList(
                Arrays.asList("Banana", "Uva", "Platano"),
                Arrays.asList("Pera", "Limon", "Coco"),
                Arrays.asList("Mango", "Cacao", "Fresa")
        );

        // Usando flatMap para aplanar la estructura de listas
        List<String> listaFinal = listaPalabaras
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("ELEMENTOS EN UNA SOLA LISTA");
        System.out.println(listaFinal);
    }
}
