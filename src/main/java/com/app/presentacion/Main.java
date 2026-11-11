package com.app.presentacion;

import com.app.logica.Gato;
import com.app.logica.Adoptante;
import com.app.logica.ControladoraLogica;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ControladoraLogica conLog = new ControladoraLogica();

        try {

            // Instanciamos dos adoptantes.
            Adoptante adop1 = new Adoptante("Lucia", "Perez", "1123456789", "lucia@gmail.com");
            Adoptante adop2 = new Adoptante("Martin", "Gomez", "1145678901", "martin@gmail.com");

            // Instanciamos dos gatos.
            Gato gato1 = new Gato("Michi", 2, "Siames", "Hembra", 4.5, adop1);
            Gato gato2 = new Gato("Tomas", 3, "Persa", "Macho", 5.2, adop2);

            // Creamos los adoptantes.
            conLog.crearAdoptante(adop1);
            conLog.crearAdoptante(adop2);

            // Creamos los gatos.
            conLog.crearGato(gato1);
            conLog.crearGato(gato2);

            System.out.println("Se crearon los gatos y adoptantes correctamente.");

            // ----- LECTURA DE GATOS -----
            System.out.println("ESTOY EJECUTANDO LA PARTE DE LECTURA");

            System.out.println("=== TODOS LOS GATOS ===");

            List<Gato> gatos = conLog.listarGatos();

            for (Gato g : gatos) {
                System.out.println(g);
            }

            System.out.println("=== BUSCAR GATO CON ID 1 ===");

            Gato encontrado = conLog.buscarUnGato(1);

            if (encontrado != null) {
                System.out.println(encontrado);
            } else {
                System.out.println("No existe un gato con ese id");
            }

            System.out.println("=== BUSCAR GATO CON ID 999 ===");

            Gato noExiste = conLog.buscarUnGato(999);

            if (noExiste != null) {
                System.out.println(noExiste);
            } else {
                System.out.println("No existe un gato con ese id");
            }

            // ----- LECTURA DE ADOPTANTES -----

            System.out.println("=== TODOS LOS ADOPTANTES ===");

            List<Adoptante> adoptantes = conLog.listarAdoptantes();

            for (Adoptante a : adoptantes) {
                System.out.println(a);
            }

            System.out.println("=== BUSCAR ADOPTANTE CON ID 1 ===");

            Adoptante encontradoAdop = conLog.buscarUnAdoptante(1);

            if (encontradoAdop != null) {
                System.out.println(encontradoAdop);
            } else {
                System.out.println("No existe un adoptante con ese id");
            }

            System.out.println("=== BUSCAR ADOPTANTE CON ID 999 ===");

            Adoptante noExisteAdop = conLog.buscarUnAdoptante(999);

            if (noExisteAdop != null) {
                System.out.println(noExisteAdop);
            } else {
                System.out.println("No existe un adoptante con ese id");
            }

        } catch (Exception e) {

            System.out.println("No se pudo crear el elemento: " + e.getMessage());

        }
    }
}