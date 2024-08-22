package org.isai.api.stream.ejemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*

El operador map en la API de Streams de Java se utiliza para transformar
los elementos de un flujo (Stream) de datos. Es una operación intermedia 
que aplica una función a cada elemento del flujo, produciendo un nuevo flujo
con los resultados de esas transformaciones.
 */
public class EjemploStreamMap {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        ejemplo01MapStream();
        ejemplo02MapStream();
        ejemplo03PeekStream();
        ejemplo04PeekStreamSimpleficado();
        ejemplo05ConcvertirStreamALista();
        ejemplos06Bolean();
        ejemplo07Integer();
    }

    public static void ejemplo01MapStream() {

        System.out.println("\tOperador map");
        //creamos un Stream de tipo String
        //en este ejemplo convierte todos los elementos que hay a Mayusculas
        Stream<String> nombres = Stream.
                of("Pato", "Paco", "Pepa", "Pepe")
                .map((nombre) -> {
                    return nombre.toUpperCase();
                });
        //operador map
        nombres.forEach(System.out::println);

    }

    public static void ejemplo02MapStream() {

        System.out.println("\tOperador map Simpleficado");
        //creamos un Stream de tipo String
        //en este ejemplo convierte todos los elementos que hay a Mayusculas
        Stream.of("Pato", "Paco", "Pepa", "Pepe")
                .map((nombre) -> {
                    return nombre.toUpperCase();
                }).forEach(System.out::println);

    }

    public static void ejemplo03PeekStream() {

        System.out.println("\tOperador pek");

        /*
        1. Creación del Stream
        2. Uso del operador peek: peek es un operador intermedio que permite 
        "espiar" cada elemento que pasa por el Stream.
        3. Transformación con map: en este caso a mayusculas cada elemento.
        4. Ejecución de la operación terminal forEach: imprime el Stream*/
        Stream<String> nombres = Stream.
                of("Pato", "Paco", "Pepa", "Pepe")
                .peek((e) -> {
                    System.out.println(e);
                }).map((nombre) -> {
            return nombre.toUpperCase();
        });

        nombres.forEach(System.out::println);

    }

    public static void ejemplo04PeekStreamSimpleficado() {

        System.out.println("\tOperador pek y map de forma mas simpleficada: ");

        /*
        1. Creación del Stream
        2. Uso del operador peek: peek es un operador intermedio que permite 
        "espiar" cada elemento que pasa por el Stream.
        3. Transformación con map: en este caso a mayusculas cada elemento.
        4. Ejecución de la operación terminal forEach: imprime el Stream*/
        Stream<String> nombres = Stream.
                of("Pato", "Paco", "Pepa", "Pepe")
                .map(String::toUpperCase)
                .peek(System.out::println)
                .map(String::toLowerCase);

        nombres.forEach(System.out::println);

    }

    public static void ejemplo05ConcvertirStreamALista() {

        System.out.println("\tConvertir un Stream a una lista ");

        /*
        1. Creación del Stream
        2. Uso del operador peek: peek es un operador intermedio que permite 
        "espiar" cada elemento que pasa por el Stream.
        3. Transformación con map: en este caso a mayusculas cada elemento.
        4. Ejecución de la operación terminal forEach: imprime el Stream*/
        Stream<String> nombres = Stream.
                of("Pato", "Paco", "Pepa", "Pepe")
                .map(String::toLowerCase)
                .peek(System.out::println) //opcional para el ejemplo
                .map(String::toUpperCase);

        /*convertimos el Stream a una Lista*/
        List<String> listaNombres = nombres.collect(Collectors.toList());

        listaNombres.forEach(System.out::println);
    }

    public static void ejemplos06Bolean() {
        System.out.println("\t Ejemplo Mio");

        /*
        Ejemplo de tipo Boolean
         */
        Stream<Boolean> nombres = Stream.of("Juan", "Pedro", "Pedro")
                .map((nombre) -> {
                    return nombre.equals("Juan");
                });
        nombres.forEach((t) -> {
            System.out.println(t);
        });
    }

    public static void ejemplo07Integer() {

        System.out.println("\tEjemplo Stream de Enteros");
        Stream<String> nombres = Stream.of("uno", "dos", "tres", "cuatro", "cinco")
                .peek((t) -> {
                    System.out.println(t);
                }).map((t) -> "Caracteres: " + t.length());
        nombres.forEach(System.out::println);
    }
}
