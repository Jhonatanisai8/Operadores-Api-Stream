package org.isai.api.stream.ejemplos.Ejercicios;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class EjemploStreamInfinitoGenerate {

    public static void main(String[] args) {
        System.out.println("\tHola Stream");
        ejemplo04AtomicInteger();
    }

    public static void ejemplo01() {
        Stream.generate(() -> "Hola Mundo!").forEach(System.out::println);
    }

    public static void ejemplo02Limit() {

        //solo imprimira 10 veces
        Stream.generate(() -> "Hola Mundo!").limit(10)
                .forEach(System.out::println);
    }

    public static void ejemplo03Limit() {

        //solo imprimira la frase cada 2 segundos 10 veces
        Stream.generate(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
            }
            return "Hola Mundo!";
        }).limit(10)
                .forEach(System.out::println);
    }

    public static void ejemplo04AtomicInteger() {

        AtomicInteger contador = new AtomicInteger(0);
        Stream.generate(() -> {

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
            }
            return contador.incrementAndGet();
        }).limit(10)
                .forEach(System.out::println);
    }
}
