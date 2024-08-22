package org.isai.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
STREAM: 
En Java, un Stream es una secuencia de elementos que se pueden procesar 
de manera funcional. Es parte de la API de streams introducida en Java 8, 
y está diseñada para hacer más fácil y eficiente el procesamiento de grandes
cantidades de datos de una manera más declarativa, como lo harías en una
consulta de base de datos o en un lenguaje funcional.
 */
public class EjemploStream {

    public static void main(String[] args) {

        System.out.println("\n\tHola Stream");
        ejemplo01CrearStream();
        ejemplos01CrearStreamArreglo();
        ejemplo03CrearStreamConBuilder();
        ejemplo04CrearStreamConUnaLista();
        ejemploEnteros8();
        ejemploObject();
    }

    public static void ejemplo01CrearStream() {

        System.out.println("\tPRIMERA FORMA");
        //creamos un Stream de tipo String
        Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa", "Pepe");

        //primer operador (imprime los elementos)
        nombres.forEach(System.out::println);
    }

    public static void ejemplos01CrearStreamArreglo() {

        System.out.println("\tSEGUNDA FORMA A PARTIR DE UN ARREGLO");
        //creamos un arreglo
        String[] nombres = {"Pato", "Paco", "Pepa", "Pepe"};
        Stream<String> nombres02 = Arrays.stream(nombres);
        nombres02.forEach(System.out::println);

    }

    public static void ejemplo03CrearStreamConBuilder() {

        System.out.println("\tTERCER FORMA CON builder");
        Stream<String> nombres = Stream.<String>builder()
                .add("Paco")
                .add("Paco")
                .add("Pepa")
                .add("Pepe")
                .build();

        //mostramos los datos
        nombres.forEach(System.out::println);

    }

    public static void ejemplo04CrearStreamConUnaLista() {

        System.out.println("\tCUARTA FORMA CREAR STREAM A PARTIR DE UNA LISTA");
        List<String> lista = new ArrayList<>();
        lista.add("Paco");
        lista.add("Paco");
        lista.add("Pepa");
        lista.add("Pepa");

        Stream<String> straNombres = lista.stream();
        straNombres.forEach(System.out::println);
        //otra forma
        System.out.println("Otra forma de iterar");
        lista.stream().forEach(System.out::println);
    }

    public static void ejemploEnteros8() {
        System.out.println("\tEjemplo Enteros");
        List<Integer> listaNumeros = Arrays.asList(1, 4, 7, 9, 34, 23);
        Stream<Integer> numeros = listaNumeros.stream();
        numeros.forEach(System.out::println);
    }

    public static void ejemploObject() {
        System.out.println("\tEjemplo de Tipo Object");
        Object arreglo[] = {"Hola", 2, 4.6, true, "Lima", 23, 786543};
        Stream<Object> stramObject = Arrays.stream(arreglo);
        stramObject.forEach(System.out::println);
    }
}
