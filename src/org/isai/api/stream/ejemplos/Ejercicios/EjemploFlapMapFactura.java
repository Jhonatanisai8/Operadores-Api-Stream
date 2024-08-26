package org.isai.api.stream.ejemplos.Ejercicios;

import java.util.Arrays;
import java.util.List;
import org.isai.api.stream.ejemplos.models.Factura;
import org.isai.api.stream.ejemplos.models.Usuario;

public class EjemploFlapMapFactura {

    public static void main(String[] args) {
        System.out.println("Ejemplo");
        ejemplo014();
    }

    public static void ejemplo018() {
        Usuario user1 = new Usuario("Jhon", "Doe");
        Usuario user2 = new Usuario("Pepe", "Perez");

        user1.addFacuras(new Factura("Compras Tecnologicas"));
        user1.addFacuras(new Factura("Compras Muebles"));

        user2.addFacuras(new Factura("Bicicleta"));
        user2.addFacuras(new Factura("Notebook Gamer"));

        List<Usuario> usurios = Arrays.asList(user1, user2);

        for (Usuario usurio : usurios) {
            for (Factura factura : usurio.getFacturas()) {
                System.out.println(factura.getDescripcion());
            }
        }

    }

    public static void ejemplo012() {
        Usuario user1 = new Usuario("Jhon", "Doe");
        Usuario user2 = new Usuario("Pepe", "Perez");

        user1.addFacuras(new Factura("Compras Tecnologicas"));
        user1.addFacuras(new Factura("Compras Muebles"));

        user2.addFacuras(new Factura("Bicicleta"));
        user2.addFacuras(new Factura("Notebook Gamer"));

        List<Usuario> usurios = Arrays.asList(user1, user2);

        //iteramos
        usurios.stream().flatMap(u -> u.getFacturas()
                .stream())
                .forEach(f -> System.out.println(f.getDescripcion()));

    }

    public static void ejemplo013() {
        Usuario user1 = new Usuario("Jhon", "Doe");
        Usuario user2 = new Usuario("Pepe", "Perez");

        user1.addFacuras(new Factura("Compras Tecnologicas"));
        user1.addFacuras(new Factura("Compras Muebles"));

        user2.addFacuras(new Factura("Bicicleta"));
        user2.addFacuras(new Factura("Notebook Gamer"));

        List<Usuario> usurios = Arrays.asList(user1, user2);

        //mostramos la factura y su cliente
        usurios.stream().flatMap(u -> u.getFacturas()
                .stream())
                .forEach(f -> System.out.println(f.getDescripcion()
                .concat(" : Cliente ")
                .concat(f.getUsuario().getNombre())));

    }

    public static void ejemplo014() {
        Usuario user1 = new Usuario("Jhon", "Doe");
        Usuario user2 = new Usuario("Pepe", "Perez");

        user1.addFacuras(new Factura("Compras Tecnologicas"));
        user1.addFacuras(new Factura("Compras Muebles"));

        user2.addFacuras(new Factura("Bicicleta"));
        user2.addFacuras(new Factura("Notebook Gamer"));

        List<Usuario> usurios = Arrays.asList(user1, user2);

        //mostramos la factura y su cliente
        usurios.stream()
                .map(u -> u.getFacturas()).
                flatMap(u -> u.stream())
                .forEach(f -> System.out.println(f.getDescripcion()
                .concat(" : Cliente ")
                .concat(f.getUsuario().getNombre())));
        System.out.println("\tForma simpleficada");
        
        /*
        El primer map: convierte la lista usuarios a un Stream del tipo list de facturas
        el flatMap: convertimos la lista de facturas a un stream de facturas
        */
        usurios.stream()
                .map(Usuario::getFacturas).
                flatMap(List::stream)
                .forEach(f -> System.out.println(f.getDescripcion()
                .concat(" : Cliente ")
                .concat(f.getUsuario().getNombre())));
    }
}
