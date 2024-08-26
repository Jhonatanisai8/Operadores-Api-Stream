package org.isai.api.stream.ejemplos.Ejercicios;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/*
El operador rangeClosed es una forma concisa y eficiente de generar
una secuencia de números enteros consecutivos dentro de un Stream.
Es una herramienta muy útil cuando necesitas realizar operaciones en un rango específico de números.
 */
public class EjemploStreamRangeClosed {

    public static void main(String[] args) {
        System.out.println("\n\tHola Stream");
        ejemplo03rangeStreamIntSummaryStatistics();
    }

    public static void ejemplo01rangeStream() {
        System.out.println("\tOperador rangeClosed");
        //en este caso nos dara numeros en el rango desde el  5 al 20 
        IntStream numeros = IntStream.range(5, 20).peek(System.out::println);

        //calculamos la suma 
        int sumaNumeros = numeros.reduce(0, Integer::sum);
        System.out.println("La suma desde el 5 al 20 es: " + sumaNumeros);
    }

    public static void ejemplo02rangeStream() {
        System.out.println("\tOperador rangeClosed");
        //en este caso nos dara numeros en el rango desde el  5 al 20 el 20 lo incluye
        IntStream numeros = IntStream.rangeClosed(5, 20).peek(System.out::println);

        //calculamos la suma 
        int sumaNumeros = numeros.sum();
        System.out.println("La suma desde el 5 al 20 es: " + sumaNumeros);

    }

    public static void ejemplo03rangeStreamIntSummaryStatistics() {
        System.out.println("\tOperador RANGE y IntSummaryStatistics");
        //en este caso nos dara numeros en el rango desde el  1 al 10 
        IntStream numeros = IntStream.rangeClosed(1, 11).peek(System.out::println);

        //uso de IntSummaryStatistics
        IntSummaryStatistics estadistica = numeros.summaryStatistics();

        //nos permite obtener varias como 
        System.out.println("Max: " + estadistica.getMax());
        System.out.println("Min: " + estadistica.getMin());
        System.out.println("Cantidad Elementos: " + estadistica.getCount());
        System.out.println("Suma: " + estadistica.getSum());
        System.out.println("Promedio: " + estadistica.getAverage());
    }

}
